package com.GamePlan.GamePlan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GamePlan.GamePlan.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{
   boolean existsByUserName(String name);
   boolean existsByEmail(String email); 
}
