package com.example.project.service;

import com.example.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {


    public List<User> getUsers();
    public Optional<User> getUser(int id);
    public User updateUser(int id,User user);
    public boolean addUser(User user);
    public boolean deleteUser(int id);






}
