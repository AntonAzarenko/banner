package com.azarenko.service;

import com.azarenko.entity.Banner;
import com.azarenko.entity.User;
import com.azarenko.repository.BannerRepository;
import com.azarenko.to.ImageNameTO;
import com.azarenko.web.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerRepository repository;

    @Override
    @Transactional
    public void save(Banner banner) {
        repository.save(banner);
    }

    @Override
    @Transactional
    public void add(MultipartFile file) {
        Banner banner = create(file);
        save(banner);
    }

    @Override
    public List<Banner> getBannersByUserId(Long id) {
        return repository.getBannersByUser_Id(id);
    }

    @Override
    public List<ImageNameTO> getImagesName(List<Banner> list) {
        List<ImageNameTO> imagesName = new ArrayList<>();
        list.forEach(b -> imagesName.add(converterBannerToImageName(b)));
        return imagesName;
    }

    @Override
    public void update(MultipartFile file, Long id) {
        Banner banner = create(file);
        banner.setId(id);
        save(banner);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Banner getBannersById(Long id) {
        return repository.getById(id);
    }

    private ImageNameTO converterBannerToImageName(Banner banner) {
        ImageNameTO imageNameTO = new ImageNameTO();
        String fullname = banner.getName() + "." + banner.getType();
        imageNameTO.setId(banner.getId());
        imageNameTO.setName(fullname);
        return imageNameTO;
    }

    private Banner create(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String[] temp = fileName.split("\\.");
        String name = temp[0];
        String type = temp[1];
        User user = new User();
        user.setId(LoggedUser.getId());
        return new Banner(name, type, user);
    }
}
