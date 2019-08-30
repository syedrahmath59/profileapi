package com.profile.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class UserProfileException extends Exception {

    private int statusCode;
    private String message;
    public UserProfileException(){
        super();
    }


}
