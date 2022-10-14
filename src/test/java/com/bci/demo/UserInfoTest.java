package com.bci.demo;

import com.bci.demo.content.Payload;
import com.bci.demo.request.UserPhoneRequest;
import com.bci.demo.request.UserRequest;
import com.bci.demo.service.UserInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Base64;

@SpringBootTest
@ActiveProfiles("test")
class UserInfoTest {

    @Autowired
    private UserInfoService userInfoService;


    @Test
    void contextLoads() {
        UserRequest userRequest = buildUserRequest();
        String token = Base64.getEncoder().encodeToString(userRequest.toString().getBytes());
        Payload response = userInfoService.createUserInfo(userRequest, token);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getMessage(), "User saved successfully");

    }

    private UserRequest buildUserRequest() {
        return UserRequest.builder().name("Juan Rodriguez")
                .email("juan@rodriguez.org").password("Hunter2@hg")
                .phones(Arrays.asList(UserPhoneRequest.builder().number("1234567").citycode("1").countrycode("57").build())).build();
    }
}
