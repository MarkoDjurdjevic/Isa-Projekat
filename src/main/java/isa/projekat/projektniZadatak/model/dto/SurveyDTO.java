package isa.projekat.projektniZadatak.model.dto;


import isa.projekat.projektniZadatak.model.Survey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SurveyDTO {
    private Long usersId;
    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;
    private boolean six;
    private boolean seven;
    private boolean eight;
    private boolean nine;
    private boolean ten;
    private boolean eleven;
    private boolean twelve;
    private boolean thirteen;
    private boolean fourteen;
    private boolean fifteen;

    public Survey convertToSurvey(SurveyDTO surveyDTO){
        Survey survey = new Survey();
        survey.setOne(surveyDTO.isOne());
        survey.setTwo(surveyDTO.isTwo());
        survey.setThree(surveyDTO.isThree());
        survey.setFour(surveyDTO.isFour());
        survey.setFive(surveyDTO.isFive());
        survey.setSix(surveyDTO.isSix());
        survey.setSeven(surveyDTO.isSeven());
        survey.setEight(surveyDTO.isEight());
        survey.setNine(surveyDTO.isNine());
        survey.setTen(surveyDTO.isTen());
        survey.setEleven(surveyDTO.isEleven());
        survey.setTwelve(surveyDTO.isTwelve());
        survey.setThirteen(surveyDTO.isThirteen());
        survey.setFourteen(surveyDTO.isFourteen());
        survey.setFifteen(surveyDTO.isFifteen());


        return survey;
    }

}
