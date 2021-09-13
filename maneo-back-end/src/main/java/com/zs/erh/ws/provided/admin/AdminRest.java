package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Admin;
import com.zs.erh.bean.User;
import com.zs.erh.service.facade.AdminService;
import com.zs.erh.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "maneo-rh/admin/admin")
public class AdminRest {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @PutMapping("/edit")
    public User editePersonnel(User user) {
        return userService.editePersonnel(user);
    }
}
