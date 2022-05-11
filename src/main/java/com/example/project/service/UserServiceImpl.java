package com.example.project.service;

import com.example.project.model.User;
import com.example.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class UserServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public Optional<User> getUser(int id) {
       return this.usersRepository.findById(id);
    }

    @Override
    public User updateUser(int id,User user) {
            Optional<User> u = getUser(id);
            if(u.isPresent())
            {
                User userUpdate = u.get();
                userUpdate.setName(user.getName());
                userUpdate.setSurname(user.getSurname());
                userUpdate.setEmail(user.getEmail());
                usersRepository.save(userUpdate);
                return userUpdate;


            }else
            {
                return null;
            }
    }

    @Override
    public boolean addUser(User user) {

        usersRepository.save(user);
        return true;

    }

    @Override
    public boolean deleteUser(int id) {

        if(usersRepository.findById(id).isPresent())
        {
            usersRepository.deleteById(id);
            return true;
        }

            return false;
    }



}
