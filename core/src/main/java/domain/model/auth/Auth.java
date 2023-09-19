package domain.model.auth;

import domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Auth implements Serializable {
    User user;
    LocalDate expireAt;
}
