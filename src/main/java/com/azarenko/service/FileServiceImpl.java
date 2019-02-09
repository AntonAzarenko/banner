package com.azarenko.service;

import com.azarenko.entity.Banner;
import com.azarenko.exception.RemoveException;
import com.azarenko.web.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ServletContext context;

    @Autowired
    private BannerService bannerService;

    @Override
    public void upload(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            String name = file.getOriginalFilename();

            String filePath = context.getRealPath("") + "/resources" + File.separator + "uploads" + File.separator + LoggedUser.safeGet().getUsername() + File.separator + "image";

            Path resourceDirectory = Paths.get(filePath);

            File dir = new File(resourceDirectory + File.separator);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File loadFile = new File(dir.getAbsolutePath() + File.separator + name);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {

        }

    }

    @Override
    public void update(MultipartFile file, Long id) {
        remove(id);
        upload(file);
    }

    @Override
    public void remove(Long id) {
        String filePath = context.getRealPath("") + "/resources" + File.separator + "uploads" + File.separator
                + LoggedUser.safeGet().getUsername() + File.separator + "image";
        Banner banner = bannerService.getBannersById(id);
        String name = banner.getName() + "." + banner.getType();

        Path resourceDirectory = Paths.get(filePath);

        File dir = new File(resourceDirectory + File.separator);
        File remFile = new File(dir.getAbsolutePath() + File.separator + name);
        if (!remFile.delete()) {
            throw new RemoveException("Файл не был удален");
        }
    }

    @Override
    public String getPath(Long id) {
        String userName = LoggedUser.safeGet().getUsername();
        String path = "resources/uploads/" + userName + "/image/";
        return path;
    }
}
