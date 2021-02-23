package com.jakubpszczolka.covidapp.Controllers;

import com.jakubpszczolka.covidapp.Model.DTO.CovidInfoDto;
import com.jakubpszczolka.covidapp.Services.CovidInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    private final CovidInfoService covidInfoService;
    private final CovidInfoController covidInfoController;

    public IndexController(CovidInfoService covidInfoService, CovidInfoController covidInfoController) {
        this.covidInfoService = covidInfoService;
        this.covidInfoController = covidInfoController;
    }

    @GetMapping("/index")
    public String getPage(Model model){
        model.addAttribute("covidInfos", covidInfoService.getCovidInfos());
        model.addAttribute("newInfo", new CovidInfoDto());
        return "index";
    }

    @PostMapping("/index/save")
    public String getPage(@ModelAttribute CovidInfoDto covidInfoDto){
        covidInfoController.getInfoAndSave(covidInfoDto.getCountry());
        return "redirect:/index";
    }
}
