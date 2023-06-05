package com.example.one.service;

import com.example.one.model.Color;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainService {

    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void insertColor(Color color){
        sqlSessionTemplate.insert("main.insertColor", color);
    }

    public void updateColor(Color color){
        sqlSessionTemplate.update("main.updateColor", color);
    }

    public Color selectColor(String colorId){
        Color color = sqlSessionTemplate.selectOne("main.selectColor", colorId);
        return color;
    }

    public void deleteColor(String colorId){
        sqlSessionTemplate.delete("main.deleteColor", colorId);
    }

}
