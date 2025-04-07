package user.management.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.management.entity.User;
import user.management.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void init(){

    }

    public Optional<User> getUser(Long id){
        return userRepo.findById(id);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public List<User> getListUserByKeyword(String keyword){
        return userRepo.searchByUsernameOrEmail(keyword);
    }
}
