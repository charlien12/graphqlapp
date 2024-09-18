package com.employee.server.controller;

import com.employee.server.models.UsersDtoEntity;
import com.employee.server.models.UsersInput;
import com.employee.server.service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor/**/
public class UsersController {

    private final IUsersService usersService;
    @MutationMapping
    public ResponseEntity<?> AddUser(@Argument(name = "input") UsersInput usersInput){
        usersService.Add(usersInput);
        return new ResponseEntity<>("user is successfully added",HttpStatus.CREATED);
    }
    @QueryMapping
    public List<UsersDtoEntity> getUser(){
        return usersService.getAll();
    }
    @MutationMapping
    public ResponseEntity<?> UpdateUser(@Argument(name = "updateUser") UsersInput usersInput){
        usersService.UpdateUsers(usersInput);
        return new ResponseEntity<>("user is successfully added",HttpStatus.CREATED);
    }
}
