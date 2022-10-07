package com.bci.demo.service;

import com.bci.demo.content.Payload;
import com.bci.demo.entity.UserInfo;
import com.bci.demo.entity.UserPhone;
import com.bci.demo.repo.UserInfoDao;
import com.bci.demo.request.UserPhoneRequest;
import com.bci.demo.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public Payload createUserInfo(final UserRequest userRequest, final String token) {
        try {
            validateEmail(userRequest.getEmail());
            validPassword(userRequest.getPassword());
            userInfoDao.existEmail(userRequest.getEmail());
            userInfoDao.saveUserInformation(buildUserInfo(userRequest, token));
            return Payload.builder().message("User saved successfully").build();
        } catch (Exception ex) {
            return Payload.builder().message(ex.getMessage()).build();
        }
    }

    private UserInfo buildUserInfo(final UserRequest userRequest, final String token) {
        return UserInfo.builder().name(userRequest.getName()).email(userRequest.getEmail())
                .password(userRequest.getPassword()).token(token)
                .phones(buildUserPhone(userRequest.getPhones())).build();
    }

    private List<UserPhone> buildUserPhone(final List<UserPhoneRequest> phones) {
        return phones.stream().map(item -> UserPhone.builder().number(item.getNumber()).citycode(item.getCitycode()).contrycode(item.getCitycode()).build()).collect(Collectors.toList());
    }


    private void validateEmail(final String email) {
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.find()) {
            throw new RuntimeException("Validar el email");
        }
    }


    private void validPassword(final String password) {
        final String PASSWORD_PATTERN =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new RuntimeException("1 La contraseña debe contener al menos un dígito [0-9]. " +
                    "2 La contraseña debe contener al menos un carácter latino en minúsculas [a-z]." +
                    "3 La contraseña debe contener al menos un carácter latino en mayúsculas [A-Z]." +
                    "4 La contraseña debe contener al menos un carácter especial como ! @ # & ( )." +
                    "5 La contraseña debe contener una longitud de al menos 8 caracteres y un máximo de 20 caracteres.");
        }
    }
}
