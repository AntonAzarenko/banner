package com.azarenko.service;

import com.azarenko.entity.Banner;
import com.azarenko.to.ImageNameTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {

    void save(Banner banner);

    void add(MultipartFile file);

    List<Banner> getBannersByUserId(Long id);

    List<ImageNameTO> getImagesName(List<Banner> list);

    void update(MultipartFile file, Long id);

    void remove(Long id);

    Banner getBannersById(Long id);
}
