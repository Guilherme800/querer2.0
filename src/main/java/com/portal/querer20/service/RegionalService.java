package com.portal.querer20.service;

import com.portal.querer20.model.Regional;
import com.portal.querer20.repository.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionalService {

    @Autowired
    private RegionalRepository regionalRepository;

    public List<Regional> listarRegional (){
        return regionalRepository.findAll();
    }

}
