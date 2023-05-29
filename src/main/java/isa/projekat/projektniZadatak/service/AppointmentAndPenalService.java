//package isa.projekat.projektniZadatak.service;
//
//import isa.projekat.projektniZadatak.model.AppointmentAndPenal;
//import isa.projekat.projektniZadatak.model.Appointments;
//import isa.projekat.projektniZadatak.model.dto.AppointmentAndPenalRequestDto;
//import isa.projekat.projektniZadatak.repository.AppointmentAndPenalRepository;
//import isa.projekat.projektniZadatak.repository.AppointmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AppointmentAndPenalService {
//    @Autowired
//    private AppointmentAndPenalRepository appointmentAndPenalRepository;
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//
//    public int addPenal(Long id) {
//
//        Optional<Appointments> appointmentsOptional = appointmentRepository.findById(id);
////        if(appointmentsOptional.isPresent()){
////            if(!appointmentsOptional.get().isAvailable()){
////                Appointments appointments = new Appointments();
////                appointments.setAvailable(appointments.isAvailable());
////
////                penal += 1;
////                appointments.setPenal(penal);
////                appointmentRepository.save(appointments);
////                System.out.println("penaal" +penal);
////
////            }
////        }
////        return penal;
////
//    }
//    private void addApointmentAndPenal(Long id,AppointmentAndPenalRequestDto appointmentAndPenalRequestDto) {
//        Optional<Appointments> appointmentsOptional = appointmentRepository.findById(id);
//        if (appointmentsOptional.isPresent()) {
//            AppointmentAndPenal appointmentAndPenal = new AppointmentAndPenal();
//            appointmentAndPenal.setAppointments(appointmentsOptional.get());
//            appointmentAndPenal.setFree(appointmentAndPenalRequestDto.isAvailable());
//            appointmentAndPenal.setPenal(appointmentAndPenalRequestDto.getPenal());
//        }
//    }
//
//
//}
