package com.azarenko.web.controller;

import com.azarenko.entity.Banner;
import com.azarenko.service.BannerService;
import com.azarenko.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Controller
public class EditController {

    @Autowired
    BannerService bannerService;

    @Autowired
    private FileService service;

    @PostMapping(value = "upload")
    public String uploadFile(@PathVariable("file") MultipartFile file) {
        if (file.getSize() > 0) {
            service.upload(file);
            bannerService.add(file);
        }
        return "redirect:/edit";
    }

    @PostMapping(value = "update")
    public String updateFile(@RequestParam(required = false) @PathVariable("file") MultipartFile file,
                             @RequestParam(required = false) @PathVariable("id") Long id) {
        if (file.getSize() > 0) {
            service.update(file, id);
            bannerService.update(file, id);
        }
        return "redirect:/edit";
    }

    @PostMapping(value = "remove")
    public String removeFile(@RequestParam(required = false) @PathVariable("id") Long id) {
        service.remove(id);
        bannerService.remove(id);
        return "redirect:/edit";
    }
}
