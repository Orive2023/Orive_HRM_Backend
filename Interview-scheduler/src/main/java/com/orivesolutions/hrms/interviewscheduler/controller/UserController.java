package com.orivesolutions.hrms.interviewscheduler.controller;

import com.orivesolutions.hrms.interviewscheduler.dto.ResponseDto;
import com.orivesolutions.hrms.interviewscheduler.dto.UserDto;
import com.orivesolutions.hrms.interviewscheduler.service.UserService;
import com.orivesolutions.hrms.interviewscheduler.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public HttpEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
        userDto = userService.createUser(userDto);
        return new ResponseEntity<>(ResponseUtil.getSuccessResponse(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public HttpEntity<ResponseDto> getUser(@PathVariable Long id) {
        UserDto userDto = userService.getUser(id);
        return new ResponseEntity<>(ResponseUtil.getSuccessResponse(userDto), HttpStatus.OK);
    }

    @GetMapping()
    public HttpEntity<ResponseDto> getAll() {
        List<UserDto> userDtos = userService.getUsers();
        return new ResponseEntity<>(ResponseUtil.getSuccessResponse(userDtos), HttpStatus.OK);
    }
}
