package com.profile.api.services;

import com.profile.api.dto.ProfileDTO;
import com.profile.api.exceptions.UserProfileException;
import com.profile.api.utils.TestDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private TestDataUtils testDataUtils;

    @Override
    public void createUserProfile(ProfileDTO profileRequest) throws UserProfileException {
        testDataUtils.pushProfile(profileRequest);
    }

    @Override
    public List<ProfileDTO> populateUserActiveProfiles() {
        return testDataUtils.populateAllProfiles();
    }

    @Override
    public ProfileDTO fetchUserProfileByProfileId(String profileId) throws UserProfileException{
        return testDataUtils.getUserProfileByProfileId(profileId);
    }

    @Override
    public ProfileDTO fetchUserProfileByEmail(String emailId) {
        return null;
    }
}
