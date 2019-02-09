package com.azarenko.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void upload(MultipartFile file);

    void update(MultipartFile file, Long id);

    void remove(Long id);

    String getPath(Long id);
}
