package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import isa.projekat.projektniZadatak.model.Appointments;
import isa.projekat.projektniZadatak.model.Statement;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.repository.AppointmentRepository;
import isa.projekat.projektniZadatak.repository.StatementRepository;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatementService {

    private final StatementRepository statementRepository;
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;

    public StatementService(StatementRepository statementRepository,
                            UserRepository userRepository,
                            AppointmentRepository appointmentRepository) {
        this.statementRepository = statementRepository;
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<Statement> getAllStatements(){
        return statementRepository.findAll();
    }


    public void createStatement(Long id,StatementDTO statementDTO){

        Optional<Appointments>appointmentsOptional = appointmentRepository.findById(id);
        System.out.println("aaaaaaaaa"+id);
        if (appointmentsOptional.isPresent()) {

            Statement statement = new Statement();
            statement.setBloodType(statementDTO.getBloodType());
            statement.setNapomena(statementDTO.getNapomena());
            statement.setBakarSulfat(statementDTO.getBakarSulfat());
            statement.setHemoglobinometar(statementDTO.getHemoglobinometar());
            statement.setSrce(statementDTO.getSrce());
            statement.setPluca(statementDTO.getPluca());
            statement.setKrvniPritisak(statementDTO.getKrvniPritisak());
            statement.setZahtev(statementDTO.isZahtev());
            statement.setNapomenaPregleda(statementDTO.getNapomenaPregleda());
            statement.setRazlogOdbijanja(statementDTO.getRazlogOdbijanja());
            statement.setMestoPunkcije(statementDTO.getMestoPunkcije());
            statement.setKolicinaUzeteKrvi(statementDTO.getKolicinaUzeteKrvi());
            statement.setPocetakKrvi(statementDTO.getPocetakKrvi());
            statement.setKrajKrvi(statementDTO.getKrajKrvi());
            statement.setAppointments(appointmentsOptional.get());

            statementRepository.save(statement);

        }

    }

    public void updateStatement(Long id,StatementDTO statementDTO){

        Optional<Statement>statementOptional = statementRepository.findById(id);
        System.out.println("aaaaaaaaa"+id);
        if (statementOptional.isPresent()) {
            statementOptional.get().setKolicinaUzeteKrvi(statementDTO.getKolicinaUzeteKrvi());
            statementRepository.save(statementOptional.get());

        }

    }
}
