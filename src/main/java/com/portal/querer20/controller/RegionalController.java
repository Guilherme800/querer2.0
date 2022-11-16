package com.portal.querer20.controller;

import com.portal.querer20.model.Regional;
import com.portal.querer20.service.RegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regional")
public class RegionalController {

    @Autowired
    private RegionalService regionalService;

    @GetMapping
    public List<Regional> listarRegional (){
        return regionalService.listarRegional();
    }

}
