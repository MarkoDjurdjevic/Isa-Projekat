package isa.projekat.projektniZadatak.service;

import isa.projekat.projektniZadatak.Enums.UserRoleEnum;
import isa.projekat.projektniZadatak.model.Users;
import isa.projekat.projektniZadatak.model.dto.RegistrationDTO;
import isa.projekat.projektniZadatak.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;



    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(Users users){
        userRepository.save(users);
    }

    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

   @Transactional
   public void updateUser(Long userId,String name,String email,String adress,String city,String country,String phone,
                         String information){
        Users users =userRepository.findById(userId).orElseThrow(()->new IllegalStateException("User with that id does not exist"));

        if(name!=null&&name.length()>0&&!Objects.equals(users.getName(),name)){
            users.setName(name);
        }

        if(email!=null&&email.length()>0&&!Objects.equals(users.getEmail(),email)){
            users.setEmail(email);
        }

        if(adress!=null&&adress.length()>0&&!Objects.equals(users.getAdress(),adress)){
            users.setAdress(adress);
        }

        if(city!=null&&city.length()>0&&!Objects.equals(users.getCity(),city)){
            users.setCity(city);
        }

        if(country!=null&&country.length()>0&&!Objects.equals(users.getCountry(),country)){
            users.setCountry(country);
        }

        if(phone!=null&&phone.length()>0&&!Objects.equals(users.getPhone(),phone)){
            users.setPhone(phone);
        }

        if(information!=null&&phone.length()>0&&!Objects.equals(users.getInformation(),information)){
            users.setInformation(information);
        }

    }
    public Users register(RegistrationDTO registrationDTO){
        Users users = registrationDTO.convertToUser(registrationDTO);
        users.setUserRoleEnum(UserRoleEnum.REGISTERED_USER);
        users = userRepository.save(users);
        return users;
    }

    public List<Users> getUsersByName(String name, String lastname){
        return userRepository.findUserByName(name, lastname);
    }
}
