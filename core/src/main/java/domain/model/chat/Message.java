package domain.model.chat;

import domain.model.User;

import java.time.LocalDate;

public class Message {

    private String text;
    private LocalDate createAt;
    private User owner;
}
