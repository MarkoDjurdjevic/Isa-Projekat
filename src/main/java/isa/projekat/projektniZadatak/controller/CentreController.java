package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.dto.SortCentresDTO;
import isa.projekat.projektniZadatak.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="/centre")
public class CentreController {
    private final CentreService centreService;


    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    @GetMapping("/all")
    public List<Centre> getCentres(){
        return centreService.getCentres();
    }

    @PostMapping("/add")
    public void registerNewCentre(@RequestBody Centre centre){
        centreService.addNewCentre(centre);
    }

    @DeleteMapping(path="/delete/{centreId}")
    public void deleteCentre(@PathVariable("centreId") Long centreId){
        centreService.deleteCentre(centreId);
    }

    @PutMapping(path="/update/{centreId}")
    public void updateCentre(@PathVariable("centreId") Long centreId,@RequestParam(required =false) String name,
                             @RequestParam(required =false) String adress,
                             @RequestParam(required =false) String description){
        centreService.updateCentre(centreId,name,adress,description);
    }
    @GetMapping("/sortCentres")
    public ResponseEntity<?> sortCentres(@RequestBody SortCentresDTO sortCentresDTO){
        List<Centre> centres = new ArrayList<>();
        if(sortCentresDTO.getByWhatCategory().equals("Name")){
            centres = centreService.sortByName(sortCentresDTO.getByWhatOrder());
        } else if (sortCentresDTO.getByWhatCategory().equals("Adress")) {
            centres = centreService.sortByAdress(sortCentresDTO.getByWhatOrder());
        }else{
            centres = centreService.sortByAvgGrade(sortCentresDTO.getByWhatOrder());
        }
        return  new ResponseEntity<>(centres, HttpStatus.OK);
    }

}
