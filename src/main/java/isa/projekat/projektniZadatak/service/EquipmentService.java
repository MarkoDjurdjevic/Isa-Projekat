package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Equipment;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {


    private final EquipmentRepository equipmentRepository;
    private final AppointmentRepository appointmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository,
                            AppointmentRepository appointmentRepository) {
        this.equipmentRepository = equipmentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public void createEquipment(Long id , EquipmentDTO equipmentDTO) {

        Optional<Appointments>appointmentsOptional = appointmentRepository.findById(id);
        if(appointmentsOptional.isPresent()) {

            Equipment equipment = new Equipment();
            equipment.setNameEquipment(equipmentDTO.getNameEquipment());
            equipment.setQuantitiofEquipment(equipmentDTO.getQuantitiofEquipment());
            equipment.setAppointments(appointmentsOptional.get());
            equipmentRepository.save(equipment);

        }


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
