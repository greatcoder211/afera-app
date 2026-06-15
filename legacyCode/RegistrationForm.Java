package pl.afera.aferaapp;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    @Size(min = 5, message = "The username must contain at least 5 characters")
    private String username;
    @Size(min = 5, message = "The password must contain at least 5 characters")
    private String password;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User( username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone);
    }
}