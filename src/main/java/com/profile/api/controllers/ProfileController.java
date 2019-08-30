package com.profile.api.controllers;

import com.profile.api.dto.ProfileDTO;
import com.profile.api.exceptions.UserProfileException;
import com.profile.api.services.UserProfileService;
import com.profile.api.utils.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping(value = "/all")
    public ResponseEntity<ProfileResponse> getUserProfiles() {
        List<ProfileDTO> profiles = userProfileService.populateUserActiveProfiles();
        ProfileResponse response = new ProfileResponse();
        if(profiles.size() > 0){
            response.setData(profiles);
            response.setStatus(200);
            response.setMessage("success");
        }else{
            response.setMessage("unsuccess or no profiles");
            response.setStatus(202);
        }
        return new ResponseEntity<ProfileResponse>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUserProfile(@RequestBody ProfileDTO profileDTO){

        try{
            userProfileService.createUserProfile(profileDTO);
        }catch (UserProfileException upe){
            return new ResponseEntity<ProfileResponse>(new ProfileResponse(null,upe.getStatusCode(),upe.getMessage()),HttpStatus.FOUND);
        }
        return new ResponseEntity<ProfileResponse>(new ProfileResponse(null,201,"created success"),HttpStatus.CREATED);
    }
}
