package com.employee.server.service;

import com.employee.server.models.UsersDtoEntity;
import com.employee.server.models.UsersInput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsersService {
    void Add(UsersInput usersDtoEntity);
    List<UsersDtoEntity> getAll();
    UsersDtoEntity UpdateUsers(UsersInput usersInput);
}
