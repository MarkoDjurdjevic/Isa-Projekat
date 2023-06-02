package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.model.dto.EquipmentDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.EquipmentRepository;
import isa.projekat.projektniZadatak.repository.RegiserUserRepository;
import isa.projekat.projektniZadatak.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {


    private final EquipmentRepository equipmentRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private UserAppRepository userRepository;

    @Autowired
    private RegiserUserRepository regiserUserRepository;

    public EquipmentService(EquipmentRepository equipmentRepository,
                            AppointmentRepository appointmentRepository) {
        this.equipmentRepository = equipmentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public void createEquipment(Long id , EquipmentDTO equipmentDTO) {

        UserApp loggedInUser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
            Optional<RegisterUser> registerUserOptional = regiserUserRepository.findById(id);
            RegisterUser registerUser = registerUserOptional.get();
            Appointments appointments = registerUser.getAppointments();
            HistoryOfRegisterUser historyOfRegisterUser = registerUser.getHistoryOfRegisterUser();
            if (!appointments.equals(null)) {

                Equipment equipment = new Equipment();
                equipment.setNameEquipment(equipmentDTO.getNameEquipment());
                equipment.setQuantitiofEquipment(equipmentDTO.getQuantitiofEquipment());
                equipment.setAppointments(appointments);
                equipment.setHistoryOfRegisterUser(historyOfRegisterUser);
                equipmentRepository.save(equipment);





            }
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
