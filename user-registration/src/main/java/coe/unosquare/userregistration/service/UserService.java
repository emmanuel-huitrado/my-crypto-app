package coe.unosquare.userregistration.service;

import coe.unosquare.userregistration.model.UserDocument;
import coe.unosquare.userregistration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<UserDocument> getAllUsers(){
        return repository.findAll();
    }

    public UserDocument getUserByEmail(String email) throws NoSuchElementException {
        return repository.findUserDocumentByEmail(email).orElseThrow();
    }

    public void saveUser(UserDocument user) {
        repository.save(user);
    }

    public UserDocument updatePasswordByEmail(String email, UserDocument user) throws NoSuchElementException{
        UserDocument replaceUser = repository.findUserDocumentByEmail(email).orElseThrow();
        replaceUser.setPassword(user.getPassword());
        return replaceUser;
    }

    public void deleteUserByEmail(String email){
        repository.deleteByEmail(email);
    }
}
