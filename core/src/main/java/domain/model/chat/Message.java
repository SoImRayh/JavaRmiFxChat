package domain.model.chat;

import domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message implements Serializable {

    private String text;
    private LocalDate createAt;
    private User owner;
}
