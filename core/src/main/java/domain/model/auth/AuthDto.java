package domain.model.auth;

import domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto implements Serializable {
    private String username;
    private String password;
    public User getUser(){
        return new User(username, password);
    }
}
