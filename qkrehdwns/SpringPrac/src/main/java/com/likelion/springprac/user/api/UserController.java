package com.likelion.springprac.user.api;

import com.likelion.springprac.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("users")
    public void save(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @GetMapping("users/{id}")
    public UserDto findById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("users")
    public List<UserDto> findAllUsers(){
        return userService.findAllUsers();
    }

    @PatchMapping("users/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody UserDto userDto){
        userService.updateUserById(id, userDto);
    }

    @DeleteMapping("users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }


}
