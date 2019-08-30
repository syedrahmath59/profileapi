package com.profile.api.utils;

import com.profile.api.dto.ProfileDTO;
import com.profile.api.exceptions.UserProfileException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestDataUtils {

    Map<String, ProfileDTO> userProfiles = new HashMap<>();

    public void pushProfile(ProfileDTO profileDTO)throws UserProfileException {
        if(!userProfiles.containsKey(profileDTO.getProfileId())){
            userProfiles.put(profileDTO.getProfileId(),profileDTO);
        }else{
            throw new UserProfileException(302,"Profile already exists");
        }
    }

    public ProfileDTO getUserProfileByProfileId(String profileId) throws  UserProfileException{
        if(userProfiles.containsKey(profileId)){
           return userProfiles.get(profileId);
        }else{
            throw new UserProfileException(404,"Profile not found");
        }
    }

    public List<ProfileDTO> populateAllProfiles(){
        List<ProfileDTO> profiles = new ArrayList<>();
        userProfiles.forEach((s, profileDTO) -> {
            profiles.add(profileDTO);
        });
        return profiles;
    }
}
