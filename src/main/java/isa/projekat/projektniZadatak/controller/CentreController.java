package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.CentreAdmin;
import isa.projekat.projektniZadatak.model.dto.CentreDTO;
import isa.projekat.projektniZadatak.model.dto.RateForCentreDTO;
import isa.projekat.projektniZadatak.service.CentreService;
import isa.projekat.projektniZadatak.service.RateForCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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

    @Autowired
    public RateForCentreService rateForCentreService;


    @PostMapping("/add")
    public void registerNewCentre(@RequestBody Centre centre){
        centreService.addNewCentre(centre);
    }



    @DeleteMapping(path="/delete/{centreId}")
    public void deleteCentre(@PathVariable("centreId") Long centreId){
        centreService.deleteCentre(centreId);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('UNREGISTERED_USER','REGISTERED_USER','SYSTEM_ADMINISTRATOR','CENTRE_ADMINISTRATOR')")
    public ResponseEntity<Optional<Centre>> searchCentres(@RequestParam String name, @RequestParam String adress){

        Optional<Centre> centre = centreService.searchCentres(name,adress);
        if(centre.isPresent()){
            return ResponseEntity.ok(centre);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public void updateCentre(@RequestBody CentreDTO centreDTO){
        centreService.updateCentre(centreDTO);
        ResponseEntity.status(HttpStatus.OK);

    }

    @GetMapping("/getAllCentreAdmin")
    @PreAuthorize("hasAnyAuthority('CENTRE_ADMINISTRATOR')")
    public List<CentreAdmin> getAllCentreAdmin(){
        return centreService.getAllCentreAdmin();
    }




//
//    @GetMapping("/appointments")
//  public ResponseEntity<List<Centre>> getAvailableCentres(@RequestParam("date") String date, @RequestParam("time") String time,
//  @RequestParam("duration") Integer duration) {
//      try {
//        System.out.println("This is the date IN BACKEND: ");
//        System.out.println(date);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate newDate = LocalDate.parse(date,formatter);
//        //LocalDate newDate = LocalDate.parse(date);
//        System.out.println("This is formmated date: ");
//        System.out.println(newDate);
//
//        //int duration = 60;
//        LocalTime startTime = LocalTime.parse(time);
//        LocalTime endTime = startTime.plusMinutes(duration);
//        String endTimeString = endTime.toString();
//        System.out.println(endTimeString);
//        System.out.println(time);
//        List<Centre> availableCentres = centreService.getAvailableCentres(newDate, time,endTimeString);
//
//        //List<Centre> availableCentres = centreService.getAvailableCentres(newDate, time,duration);
//
//        return new ResponseEntity<>(availableCentres, HttpStatus.OK);
//      } catch (Exception e) {
//        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//      }
//
//  }
//
//  @GetMapping("/appointments1")
//  public ResponseEntity<List<Centre>> getAvailableCentresRegUser(@RequestParam("date") String date, @RequestParam("time") String time ) {
//
//    try {
//      System.out.println("This is the date IN BACKEND: ");
//      System.out.println(date);
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//      LocalDate newDate = LocalDate.parse(date,formatter);
//
//      List<Centre> availableCentresRegUser = centreService.getAvailableCentresRegUser(newDate, time);
//
//      return new ResponseEntity<>(availableCentresRegUser, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//  }


    //ovde  se umesto reqest param koriti requestbody anotacija da bi se u http telu zahteva prosledio ceo objekat
//    @PutMapping(path="/update/{centreId}")
//    public ResponseEntity<Centre> updateCentre(@PathVariable("centreId") Long centreId, @RequestBody Centre centre){
//        Centre updatedCentre = centreService.updateCentre(centreId, centre);
//        return ResponseEntity.ok(updatedCentre);
//    }




  @GetMapping("/{id}")
  public ResponseEntity<Centre> getCentreById(@PathVariable(value = "id") Long id) {
    Centre centre = centreService.getCentreById(id);
    return ResponseEntity.ok().body(centre);
  }

    @PostMapping("/rate")
    @PreAuthorize("hasAnyAuthority('REGISTERED_USER')")
    public void rateForCenter(@RequestBody RateForCentreDTO rateForCentreDTO) {
        rateForCentreService.RateCentre(rateForCentreDTO);
    }



//    @PostMapping("/{id}/rate")
//    public void rateCentre(@PathVariable Long id,@RequestBody CentreDTO centreDTO){
//        centreService.rateForCentre(id,centreDTO);
//
//    }

}
