package com.profile.api.services;

import com.profile.api.dto.ProfileDTO;
import com.profile.api.exceptions.UserProfileException;

import java.util.List;

public interface UserProfileService {

    void createUserProfile(ProfileDTO profileDTO) throws UserProfileException;
    List<ProfileDTO> populateUserActiveProfiles();
    ProfileDTO fetchUserProfileByProfileId(String profileId) throws UserProfileException;
    ProfileDTO fetchUserProfileByEmail(String emailId)throws UserProfileException;
}
