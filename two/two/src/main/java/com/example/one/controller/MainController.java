package com.example.one.controller;

import com.example.one.model.Color;
import com.example.one.model.Farm;
import com.example.one.service.MainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class MainController {


    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private MainService mainService;

    @GetMapping("/hello")
    @ResponseBody
    public String helloName(@RequestParam String name) {
        logger.info(name);
        return "Hello " + name;
    }


    @PostMapping("/insertColor")
    @ResponseBody
    public String insertColor(@RequestBody Color color) {
        mainService.insertColor(color);
        return "Insert OK";
    }

    @PostMapping("/updateColor")
    @ResponseBody
    public String updateColor(@RequestBody Color color) {
        mainService.updateColor(color);
        return "Update OK";
    }

    @GetMapping("/selectColor/{colorId}")
    @ResponseBody
    //public Color selectColor(@RequestParam String colorId) {
    public Color selectColor(@PathVariable String colorId) {
        Color color = mainService.selectColor(colorId);
        return color;
    }

    @DeleteMapping("/deleteColor")
    @ResponseBody
    public String deleteColor(@RequestParam String colorId) {
        mainService.deleteColor(colorId);
        return "Delete OK";
    }



}
