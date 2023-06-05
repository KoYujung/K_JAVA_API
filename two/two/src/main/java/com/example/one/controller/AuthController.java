package com.example.one.controller;

import com.example.one.model.Color;
import com.example.one.model.User;
import com.example.one.service.JwtService;
import com.example.one.service.MainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/getToken")
    @ResponseBody
    public String getToken(@RequestBody User user) {
        String token = jwtService.generateJwtToken(user);
        logger.info(token);
        return token;
    }

    @GetMapping("/getName")
    @ResponseBody
    public String getName(@RequestHeader String token) {
        String userName = jwtService.getUserNameToken(token);
        return userName;
    }


}
