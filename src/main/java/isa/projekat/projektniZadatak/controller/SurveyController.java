package isa.projekat.projektniZadatak.controller;


import isa.projekat.projektniZadatak.model.Survey;
import isa.projekat.projektniZadatak.dto.SurveyDTO;
import isa.projekat.projektniZadatak.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/survey")
public class SurveyController {
    private  final SurveyService surveyService;
    @Autowired
    public SurveyController(SurveyService surveyService){
        this.surveyService=surveyService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SurveyDTO surveyDTO){
        Survey survey = surveyService.add(surveyDTO);

        return new ResponseEntity<>(survey, HttpStatus.OK);
    }
}
