package com.citizens.citizensapi.controller;
import com.citizens.citizensapi.primary.entity.Citizens;
import com.citizens.citizensapi.primary.entity.User;
import com.citizens.citizensapi.service.UserCopyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/copy")
public class UserCopyController<CitizenRepository> {

    private final UserCopyService userCopyService;



    public UserCopyController(UserCopyService userCopyService) {
        this.userCopyService = userCopyService;
    }

    @GetMapping("/users")
    public List<User> copyUsers() {

        return userCopyService.copyUsers();
    }

    @GetMapping("/citizens")
    public List<Citizens> getCitizens() {

        return userCopyService.getCitizens();
    }


}