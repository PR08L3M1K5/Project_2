package com.example.project.api;

import com.example.project.model.User;
import com.example.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


   @Autowired
   private UsersService usersService;





   @GetMapping
   public List<User> getUsers()
   {
      return  usersService.getUsers();
   }

   @GetMapping("/{id}")
   public Optional<User> getUser(@PathVariable("id") int id)
   {

      return usersService.getUser(id);
   }
   @PutMapping("/{id}")
           public User updateUser(@PathVariable("id") int id, @RequestBody User user)
   {
            return usersService.updateUser(id,user);
   }



   @DeleteMapping("/{id}")
   public boolean deleteUser(@PathVariable("id") int id)
   {

         return usersService.deleteUser(id);
   }

   @PostMapping
           public boolean addUser(@RequestBody User user)
   {
         return usersService.addUser(user);

   }



}
