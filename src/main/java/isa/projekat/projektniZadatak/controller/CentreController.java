package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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



  @GetMapping("/appointments")
  public ResponseEntity<List<Centre>> getAvailableCentres(@RequestParam("date") String date, @RequestParam("time") String time,
  @RequestParam("duration") Integer duration) {
      try {
        System.out.println("This is the date IN BACKEND: ");
        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newDate = LocalDate.parse(date,formatter);
        //LocalDate newDate = LocalDate.parse(date);
        System.out.println("This is formmated date: ");
        System.out.println(newDate);

        //int duration = 60;
        LocalTime startTime = LocalTime.parse(time);
        LocalTime endTime = startTime.plusMinutes(duration);
        String endTimeString = endTime.toString();
        System.out.println(endTimeString);
        System.out.println(time);
        List<Centre> availableCentres = centreService.getAvailableCentres(newDate, time,endTimeString);

        //List<Centre> availableCentres = centreService.getAvailableCentres(newDate, time,duration);

        return new ResponseEntity<>(availableCentres, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }

  }

  @GetMapping("/appointments1")
  public ResponseEntity<List<Centre>> getAvailableCentresRegUser(@RequestParam("date") String date, @RequestParam("time") String time ) {

    try {
      System.out.println("This is the date IN BACKEND: ");
      System.out.println(date);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate newDate = LocalDate.parse(date,formatter);

      List<Centre> availableCentresRegUser = centreService.getAvailableCentresRegUser(newDate, time);

      return new ResponseEntity<>(availableCentresRegUser, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

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

  @GetMapping("/{id}")
  public ResponseEntity<Centre> getCentreById(@PathVariable(value = "id") Long id) {
    Centre centre = centreService.getCentreById(id);
    return ResponseEntity.ok().body(centre);
  }

}
