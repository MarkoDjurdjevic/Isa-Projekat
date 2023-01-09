package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path ="/centre")
@CrossOrigin(origins= "http://localhost:4200/")

public class CentreController {
    private final CentreService centreService;

    @Autowired
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

//    @PutMapping(path="/update/{centreId}")
//    public void updateCentre(@PathVariable("centreId") Long centreId,@RequestParam(required =false) String name,
//                             @RequestParam(required =false) String adress,
//                             @RequestParam(required =false) String description){
//        centreService.updateCentre(centreId,name,adress,description);
//    }

    @PutMapping(path="/update/{centreId}")
    public ResponseEntity<Centre> updateCentre(@PathVariable("centreId") Long centreId, @RequestBody Centre centre){
        Centre updatedCentre = centreService.updateCentre(centreId, centre);
        return ResponseEntity.ok(updatedCentre);
    }


    @GetMapping("/search")
    public ResponseEntity<Optional<Centre>> searchCentres(@RequestParam String name, @RequestParam String adress){

        Optional<Centre> centre = centreService.searchCentres(name,adress);
        if(centre.isPresent()){
            return ResponseEntity.ok(centre);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
