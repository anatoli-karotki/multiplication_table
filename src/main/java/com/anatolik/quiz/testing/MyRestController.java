package com.anatolik.quiz.testing;

import com.anatolik.quiz.security.dao.UserRepository;
import com.anatolik.quiz.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    private UserRepository userRepository;

//    @Secured("ROLE_USER")
    @RequestMapping("/user")
    public String user() {
        Iterable<User> all = userRepository.findAll();
        return "Hello user!";
    }

//    @Secured("ROLE_ADMIN")
    @RequestMapping("/admin")
    public String admin() {
        return "Hello admin!";
    }
}
