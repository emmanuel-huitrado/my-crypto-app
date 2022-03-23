package coe.unosquare.userregistration.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
