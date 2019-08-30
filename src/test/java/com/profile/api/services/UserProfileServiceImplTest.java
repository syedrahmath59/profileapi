package com.profile.api.services;

import com.profile.api.dto.ProfileDTO;
import com.profile.api.exceptions.UserProfileException;
import com.profile.api.utils.TestDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
//@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
public class UserProfileServiceImplTest {

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    @Mock
    private TestDataUtils testDataUtils;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
       // userProfileService = new UserProfileServiceImpl();
    }

    @Test
    public void validateCreateUserProfileWithValidData() throws UserProfileException {
        Mockito.doNothing().when(testDataUtils).pushProfile(any());
        userProfileService.createUserProfile(getProfileDto());
    }

    @Test(expected = UserProfileException.class)
    public void throwExceptionOnInvalidRequest() throws UserProfileException {
        Mockito.doThrow(UserProfileException.class).when(testDataUtils).pushProfile(any());
        userProfileService.createUserProfile(getProfileDto());
    }

    private ProfileDTO getProfileDto(){
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setCity("Hyderabad");
        profileDTO.setProfileId("srahmath1");
        profileDTO.setEmailId("syed@gap.com");
        profileDTO.setFirstName("rahmath");
        profileDTO.setLastName("syed");
        profileDTO.setPhoneNumber("1234567890");
        return profileDTO;
    }

}
