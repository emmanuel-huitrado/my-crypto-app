package coe.unosquare.userregistration.controller;

import coe.unosquare.userregistration.model.UserDocument;
import coe.unosquare.userregistration.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/")
    public List<UserDocument> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/user/{email}")
    public UserDocument getUserById(@PathVariable  String email){
        return service.getUserByEmail(email);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserDocument userBody){
        UserDocument user = new UserDocument();
        user.setFirstname(userBody.getFirstname());
        user.setLastname(userBody.getLastname());
        user.setEmail(userBody.getEmail());
        user.setPassword(userBody.getPassword());
        service.saveUser(user);
    }

    @PatchMapping("/user/{email}")
    public UserDocument updatePasswordByEmail(@PathVariable String email, @RequestBody UserDocument user){
        return service.updatePasswordByEmail(email, user);
    }

    @DeleteMapping("/user/{email}")
    public void deleteUserByEmail(@PathVariable String email){
        service.deleteUserByEmail(email);
    }
}
