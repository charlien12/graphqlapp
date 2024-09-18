package com.employee.server.Repository;

import com.employee.server.models.UsersDtoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsersRepository extends JpaRepository<UsersDtoEntity,Integer> {

}
