package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.model.*;
import isa.projekat.projektniZadatak.model.dto.StatementDTO;
import isa.projekat.projektniZadatak.repository.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatementService {

    private final StatementRepository statementRepository;
    private final UserAppRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final BloodTypeRepository bloodTypeRepository;
    private final HistoryOfRegisterUserRepository historyOfRegisterUserRepository;
    private final RegiserUserRepository regiserUserRepository;

    public StatementService(StatementRepository statementRepository,
                            UserAppRepository userRepository,
                            AppointmentRepository appointmentRepository,
                            BloodTypeRepository bloodTypeRepository,
                            HistoryOfRegisterUserRepository historyOfRegisterUserRepository,
                            RegiserUserRepository regiserUserRepository) {
        this.statementRepository = statementRepository;
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
        this.bloodTypeRepository = bloodTypeRepository;
        this.historyOfRegisterUserRepository = historyOfRegisterUserRepository;
        this.regiserUserRepository = regiserUserRepository;
    }

    public List<Statement> getAllStatements(){
        return statementRepository.findAll();
    }


    public Statement createStatement(Long id,StatementDTO statementDTO){

        UserApp loggedInUser = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (loggedInUser.getRole().getName().equals("CENTRE_ADMINISTRATOR")) {
//            Optional<RegisterUser> registerUserOptional = regiserUserRepository.findById(id);
//            RegisterUser registerUser = registerUserOptional.get();
//            Appointments appointments = registerUser.getAppointments();
            Optional<Appointments>appointmentsOptional = appointmentRepository.findById(id);
            Appointments appointments = appointmentsOptional.get();
            RegisterUser registerUser = appointments.getRegisterUser();
            HistoryOfRegisterUser historyOfRegisterUser = new HistoryOfRegisterUser();
            BloodType bloodTypeOptional = bloodTypeRepository.findByName(statementDTO.getBloodTypeName());
            System.out.println("aaaaaaaaa" + id);
            if (appointmentsOptional.isPresent()) {

                Statement statement = new Statement();
                statement.setBloodType(bloodTypeOptional);
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
                statement.setAppointments(appointments);

                statementRepository.save(statement);

                appointments.setStatement(statement);
                appointmentRepository.save(appointments);

                historyOfRegisterUser.setStatement(statement);
                historyOfRegisterUser.setRegisterUser(registerUser);
                historyOfRegisterUserRepository.save(historyOfRegisterUser);

                return statement;

            }

        }

        return null;
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
