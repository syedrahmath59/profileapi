package com.profile.api.controllers;

import com.profile.api.dto.ProfileDTO;
import com.profile.api.utils.ProfileResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfileControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void saveUserProfile(){

        HttpEntity<ProfileDTO> httpEntity = new HttpEntity<>(getProfileDto(),headers);
        ResponseEntity<ProfileResponse> responseEntity = restTemplate.postForEntity(createURLWithPort("/profile/create"),httpEntity,ProfileResponse.class);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void validateWithAlreadyExistsUserProfile(){
        {

            HttpEntity<ProfileDTO> httpEntity = new HttpEntity<>(getProfileDto(),headers);
            ResponseEntity<ProfileResponse> responseEntity = restTemplate.postForEntity(createURLWithPort("/profile/create"),httpEntity,ProfileResponse.class);
            Assert.assertNotNull(responseEntity);
            Assert.assertEquals(responseEntity.getBody().getStatus(),302);
            Assert.assertEquals(responseEntity.getStatusCode(),HttpStatus.FOUND);
        }
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

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
