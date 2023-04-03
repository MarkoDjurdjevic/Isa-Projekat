package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import isa.projekat.projektniZadatak.model.Terms;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.model.dto.RegistrationDTO;
import isa.projekat.projektniZadatak.model.dto.UpdateUsersDTO;
import isa.projekat.projektniZadatak.model.dto.UsersDTO;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(UsersDTO usersDTO){
        Users users = new Users();
        users.setEmail(usersDTO.getEmail());
        users.setPassword(usersDTO.getPassword());
        users.setName(usersDTO.getName());
        users.setLastname(usersDTO.getLastname());
        users.setAdress(usersDTO.getAdress());
        users.setCity(usersDTO.getCity());
        users.setCountry(usersDTO.getCountry());
        users.setPhone(usersDTO.getPhone());
        users.setJmbg(usersDTO.getJMBG());
        users.setProfession(usersDTO.getProfession());
        users.setInformation(usersDTO.getInformation());
        users.setCategory(usersDTO.getCategory());
        users.setGenderEnum(usersDTO.getGenderEnum());
        users.setUserRoleEnum(usersDTO.getUserRoleEnum());


        userRepository.save(users);
    }

    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public List<Users> getUsersByName(String name, String lastname){
        return userRepository.findUserByName(name, lastname);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }


    @Transactional
    public Users updateUser(Long userId, UpdateUsersDTO updateUsersDTO) {
        Users users = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with that id does not exist"));

        if (updateUsersDTO.getPassword() != null && updateUsersDTO.getPassword().length() > 0 && !Objects.equals(users.getPassword(), updateUsersDTO.getPassword())) {
            users.setPassword(updateUsersDTO.getPassword());
        }

        if (updateUsersDTO.getName() != null && updateUsersDTO.getName().length() > 0 && !Objects.equals(users.getName(), updateUsersDTO.getName())) {
            users.setName(updateUsersDTO.getName());
        }

        if (updateUsersDTO.getLastname() != null && updateUsersDTO.getLastname().length() > 0 && !Objects.equals(users.getLastname(), updateUsersDTO.getLastname())) {
            users.setLastname(updateUsersDTO.getLastname());
        }

        if (updateUsersDTO.getAdress() != null && updateUsersDTO.getAdress().length() > 0 && !Objects.equals(users.getAdress(), updateUsersDTO.getAdress())) {
            users.setAdress(updateUsersDTO.getAdress());
        }

        if (updateUsersDTO.getCity() != null && updateUsersDTO.getCity().length() > 0 && !Objects.equals(users.getCity(), updateUsersDTO.getCity())) {
            users.setCity(updateUsersDTO.getCity());

            users.setCity(updateUsersDTO.getCity());
        }


        if(updateUsersDTO.getCountry()!=null&&updateUsersDTO.getCountry().length()>0&&!Objects.equals(users.getCountry(), updateUsersDTO.getCountry())){
            users.setCountry(updateUsersDTO.getCountry());
        }

        if(updateUsersDTO.getPhone()!=null&&updateUsersDTO.getPhone().length()>0&&!Objects.equals(users.getPhone(), updateUsersDTO.getPhone())){
            users.setPhone(updateUsersDTO.getPhone());
        }

        if(updateUsersDTO.getProfession()!=null&&updateUsersDTO.getProfession().length()>0&&!Objects.equals(users.getProfession(), updateUsersDTO.getProfession())){
            users.setProfession(updateUsersDTO.getProfession());
        }

        if(updateUsersDTO.getInformation()!=null&&updateUsersDTO.getInformation().length()>0&&!Objects.equals(users.getInformation(), updateUsersDTO.getInformation())){
            users.setInformation(updateUsersDTO.getInformation());
        }

        if(updateUsersDTO.getJmbg()!=null&&updateUsersDTO.getJmbg().length()>0&&!Objects.equals(users.getJmbg(), updateUsersDTO.getJmbg())){
            users.setJmbg(updateUsersDTO.getJmbg());
        }

        return userRepository.save(users);
    }


    public Users register(RegistrationDTO registrationDTO){
        Users users = registrationDTO.convertToUser(registrationDTO);
        users.setUserRoleEnum(UserRoleEnum.REGISTERED_USER);
        users = userRepository.save(users);
        return users;
    }

    public Users login(String email, String password) {
        List<Users> users = userRepository.findUserByEmailAndPassword(email, password);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public List<Users>getMedicalUsers(){
        return  userRepository.findUserByUserRole(UserRoleEnum.CENTRE_ADMINISTRATOR);
    }
}
