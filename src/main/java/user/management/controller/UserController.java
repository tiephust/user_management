package user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import user.management.entity.User;
import user.management.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public ResponseEntity<?> home(){
        return ResponseEntity.ok("Welcome to home page");
    }

//    @GetMapping("login")
//    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
//
//    }
    // getUser by id in localhost:8080/user/1
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    // search user by keyword filled by username, name, gmail, phone, address
    @GetMapping("/search-user")
    public ResponseEntity<?> searchUser(@RequestParam String keyword){
        List<User> users = userService.getListUserByKeyword(keyword);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/all-user")
    public ResponseEntity<?> allUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
     }
}
