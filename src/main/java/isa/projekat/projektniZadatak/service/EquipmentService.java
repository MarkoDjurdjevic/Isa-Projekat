package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {


    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void createEquipment(EquipmentDTO equipmentDTO, Appointments appointments) {
        Optional<Equipment>existingEquipment = equipmentRepository.findByName(equipmentDTO.getNameEquipment());
     /*   if(existingEquipment.isPresent()){
            System.out.println("Postoji vec oprema sa datim nazivom");
        }else {*/
            Equipment equipment = new Equipment();
            equipment.setNameEquipment(equipmentDTO.getNameEquipment());
            equipment.setQuantitiofEquipment(equipmentDTO.getQuantitiofEquipment());
            equipment.setAppointments(appointments);
            equipmentRepository.save(equipment);
       //}

    }

    public void updateEquipment(Long id,EquipmentDTO equipmentDTO) {
        Optional<Equipment>equipment1 = equipmentRepository.findById(id);
        if(equipment1.isPresent()){
            Equipment equipment = equipment1.get();
            //equipment.setNameEquipment(equipmentDTO.getNameEquipment());
            equipment.setQuantitiofEquipment(equipmentDTO.getQuantitiofEquipment());
            equipmentRepository.save(equipment);

        }

    }

    public List<Equipment> getAllEquipment(){
       return equipmentRepository.findAll();
    }


}
