package com.example.one.controller;

import com.example.one.model.Color;
import com.example.one.service.MainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {


    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private MainService mainService;

    @GetMapping("/hello")
    public ModelAndView pageHome(@RequestParam String name) {

        Map<String, Object> maps = new HashMap<>();
        maps.put("name", name);

        return new ModelAndView("hello", maps);
    }



}
