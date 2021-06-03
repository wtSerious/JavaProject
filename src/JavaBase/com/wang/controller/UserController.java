package JavaBase.com.wang.controller;

import JavaBase.com.wang.annotaion.Autowired;
import JavaBase.com.wang.service.UserService;

public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
