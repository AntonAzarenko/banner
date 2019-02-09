package com.azarenko.web.controller;

import com.azarenko.entity.Banner;
import com.azarenko.service.BannerService;
import com.azarenko.service.FileService;
import com.azarenko.web.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userPage(Model model) {
        setImage(model);
        return "userPage";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model) {
        setImage(model);
        return "editPage";
    }

    private void setImage(Model model){
        Long userId = LoggedUser.getId();
        List<Banner> banners = bannerService.getBannersByUserId(userId);
        model.addAttribute("path", fileService.getPath(userId));
        model.addAttribute("images", bannerService.getImagesName(banners));
    }
}
