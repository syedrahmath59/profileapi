package com.profile.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    private String profileId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String phoneNumber;
    private String city;

}
