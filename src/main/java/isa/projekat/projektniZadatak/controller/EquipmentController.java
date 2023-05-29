package isa.projekat.projektniZadatak.controller;

import isa.projekat.projektniZadatak.model.Centre;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.model.dto.UpdateUsersDTO;
import isa.projekat.projektniZadatak.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/equipments")
@CrossOrigin(origins= "http://localhost:4200/")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

//    @PostMapping("/add")
//    public void registerNewEquipment(@RequestBody EquipmentDTO equipment){
//        equipmentService.createEquipment(equipment);
//    }

    @PutMapping(path="/update/{equipmentId}")
    public void updateEquipment(@PathVariable("equipmentId") Long equipmentId, @RequestBody EquipmentDTO equipmentDTO) {
        equipmentService.updateEquipment(equipmentId, equipmentDTO);
    }

    @GetMapping("/all")
    public List<Equipment> getAllEquipment(){
        return equipmentService.getAllEquipment();
    }
}
