package org.example.models;

import org.example.exceptions.InvalidEmailException;
import org.example.utilities.EmailUtility;

public class User {
    private final Integer id ;
    private final String name ;
    private final String email ;
    public User(Integer id, String name, String email) {
        if (!EmailUtility.validateEmail(email)) {
            throw new InvalidEmailException();
        }
        this.id = id ;
        this.name = name ;
        this.email = email ;
    }
}
