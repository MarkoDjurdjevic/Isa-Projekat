package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/report")
@CrossOrigin(origins= "http://localhost:4200/")
public class ReportController {

    @Autowired
    private ReportService reportService;

//    @PostMapping("/add")

}
