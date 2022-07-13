package com.greatlearning.stumanagement.StudentManagement1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.stumanagement.StudentManagement1.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
