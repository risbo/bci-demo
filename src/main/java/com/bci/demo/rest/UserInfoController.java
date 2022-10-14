package com.bci.demo.rest;

import com.bci.demo.content.Payload;
import com.bci.demo.request.UserRequest;
import com.bci.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "users")
    public ResponseEntity<Payload> create(@RequestBody UserRequest userRequest, @RequestHeader("token") String token){
        final Payload response = userInfoService.createUserInfo(userRequest,token);
        return ResponseEntity.ok(response);
    }

}
