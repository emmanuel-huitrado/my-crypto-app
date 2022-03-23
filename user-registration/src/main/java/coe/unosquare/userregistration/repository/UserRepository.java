package coe.unosquare.userregistration.repository;

import coe.unosquare.userregistration.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findUserDocumentByEmail(String email);
    void deleteByEmail(String email);
}
