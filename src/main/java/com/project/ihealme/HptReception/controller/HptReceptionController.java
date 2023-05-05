package com.project.ihealme.HptReception.controller;

import com.project.ihealme.HptReception.domain.HptReception;
import com.project.ihealme.HptReception.service.HptReceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HptReceptionController {

    private final HptReceptionService hptReceptionService;

    public HptReceptionController(HptReceptionService hptReceptionService) {
        this.hptReceptionService = hptReceptionService;
    }

    @GetMapping("/HptReception")
    public String hptReception(Model model) {
        int rtCount = hptReceptionService.getRtCount();
        model.addAttribute("rtCount", rtCount);
        List<HptReception> hptReceptionList = hptReceptionService.getHptReceptionList();
        model.addAttribute("hptReceptionList", hptReceptionList);
        return "HptReception";
    }

    @PostMapping("/HptReception/addCounter")
    @ResponseBody
    public String addCounter() {
        hptReceptionService.increaseRtCount();
        return "success";
    }

    @PostMapping("/HptReception/subCounter")
    @ResponseBody
    public String subCounter() {
        hptReceptionService.decreaseRtCount();
        return "success";
    }

    @PostMapping("/HptReception/updateCurrentStatus")
    @ResponseBody
    public String updateCurrentStatus(@RequestParam("resNo") int resNo) {
        hptReceptionService.updateCurrentStatus(resNo, "진료 전", LocalDateTime.now());
        hptReceptionService.increaseRtCount(); // 대기자 수 +1

        return "redirect:/HptReception";
    }

}




