package com.bci.demo.map;

import com.bci.demo.entity.UserInfo;
import com.bci.demo.entity.UserPhone;
import com.bci.demo.request.UserPhoneRequest;
import com.bci.demo.request.UserRequest;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserInfoMap {

    public UserInfo buildUserInfo(final UserRequest userRequest, final String token) {
        return UserInfo.builder().name(userRequest.getName()).email(userRequest.getEmail())
                .password(
                        Base64.getEncoder().encodeToString(userRequest.getPassword().getBytes())
                ).token(token).isActive(Boolean.TRUE)
                .phones(buildUserPhone(userRequest.getPhones())).build();
    }

    public List<UserPhone> buildUserPhone(final List<UserPhoneRequest> phones) {
        return phones.stream().map(item -> UserPhone.builder().number(item.getNumber()).citycode(item.getCitycode()).contrycode(item.getCitycode()).build()).collect(Collectors.toList());
    }
}
