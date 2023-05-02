package com.project.ihealme.HptReception.controller;

import com.project.ihealme.HptReception.domain.HptReception;
import com.project.ihealme.HptReception.service.HptReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HptReceptionController {
    @Autowired
    private HptReceptionService hptReceptionService;

    @GetMapping("/HptReception")
    public String getHptReception(Model model) {
        List<HptReception> hptReceptionList = hptReceptionService.getHptReceptionList();
        model.addAttribute("hptReceptionList", hptReceptionList);
        return "HptReception";
    }
}
