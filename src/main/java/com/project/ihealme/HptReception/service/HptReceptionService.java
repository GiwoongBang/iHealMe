package com.project.ihealme.HptReception.service;

import com.project.ihealme.HptReception.domain.HptReception;
import com.project.ihealme.HptReception.repository.HptReceptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HptReceptionService {

    private final HptReceptionRepository hptReceptionRepository;

    public HptReceptionService(HptReceptionRepository hptReceptionRepository) {
        this.hptReceptionRepository = hptReceptionRepository;
    }

    public List<HptReception> getHptReceptionList() {
        return hptReceptionRepository.findAll();
    }

    public HptReception save(HptReception hptReception) {
        return hptReceptionRepository.save(hptReception);
    }

//    public void deleteById(Long id) {
//        hptReceptionRepository.deleteById(id);
//    }

}
