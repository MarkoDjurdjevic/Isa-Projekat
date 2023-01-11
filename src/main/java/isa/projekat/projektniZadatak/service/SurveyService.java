package isa.projekat.projektniZadatak.service;



import isa.projekat.projektniZadatak.model.Survey;
import isa.projekat.projektniZadatak.dto.SurveyDTO;
import isa.projekat.projektniZadatak.repository.SurveyRepository;

import isa.projekat.projektniZadatak.repository.UserRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;



    public Survey add(SurveyDTO surveyDTO){
        Survey survey = surveyDTO.convertToSurvey(surveyDTO);
        survey.setUsers(userRepository.findById(surveyDTO.getUsersId()).get());
        survey = surveyRepository.save(survey);
        return survey;
    }
}
