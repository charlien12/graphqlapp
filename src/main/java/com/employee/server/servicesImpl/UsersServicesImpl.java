package com.employee.server.servicesImpl;

import com.employee.server.Repository.IUsersRepository;
import com.employee.server.models.UsersDtoEntity;
import com.employee.server.models.UsersInput;
import com.employee.server.service.IUsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServicesImpl implements IUsersService {
    @Autowired
    private IUsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void Add(UsersInput usersInput) {
        UsersDtoEntity usersDtoEntity = modelMapper.map(usersInput, UsersDtoEntity.class);
        System.out.println(usersDtoEntity);
        usersRepository.save(usersDtoEntity);

    }

    @Override
    public List<UsersDtoEntity> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public UsersDtoEntity UpdateUsers(UsersInput usersInput) {
        UsersDtoEntity findById = usersRepository.findById(usersInput.getId()).orElseThrow(()->
                new RuntimeException("user is not exist with this id"));
        findById.setName(usersInput.getName());
        findById.setDesignation(usersInput.getDesignation());
        findById.setSalary(usersInput.getSalary());
        usersRepository.save(findById);
        return findById;
    }
}
