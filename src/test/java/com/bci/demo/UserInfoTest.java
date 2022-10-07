package com.bci.demo;

import com.bci.demo.content.Payload;
import com.bci.demo.repo.UserInfoDao;
import com.bci.demo.request.UserPhoneRequest;
import com.bci.demo.request.UserRequest;
import com.bci.demo.service.UserInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class UserInfoTest {

    @Mock
    private UserInfoService userInfoService;

    @Mock
    private UserInfoDao userInfoDao;


    @Test
    void contextLoads() {
        UserRequest userRequest = buildUserRequest();
        Mockito.doNothing().when(userInfoDao).existEmail(userRequest.getEmail());
        Mockito.doNothing().when(userInfoDao).saveUserInformation(Mockito.any());
        Mockito.when(userInfoService.createUserInfo(Mockito.any(), Mockito.any())).thenReturn(Payload.builder().message("User saved successfully").build());
        Payload response = userInfoService.createUserInfo(userRequest, "valid-token");
        Mockito.verify(userInfoService, Mockito.times(1)).createUserInfo(userRequest, "valid-token");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getMessage(), "User saved successfully");
    }

    private UserRequest buildUserRequest() {
        return UserRequest.builder().name("Juan Rodriguez")
                .email("juan@rodriguez.org").password("Hunter2@hg")
                .phones(Arrays.asList(UserPhoneRequest.builder().number("1234567").citycode("1").countrycode("57").build())).build();
    }
}
