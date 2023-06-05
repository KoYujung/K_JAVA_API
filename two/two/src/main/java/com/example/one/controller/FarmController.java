package com.example.one.controller;

import com.example.one.model.Farm;
import com.example.one.model.Response;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {

    private Log logger = LogFactory.getLog(this.getClass());


    @GetMapping("/get")
    @ResponseBody
    public Response getXX(@RequestParam String apiKey, String kidofcomdtySeCode) throws Exception {

        //apiKey "20230601JKDXVD39FWGMF0PJBPWMA"
        //kidofcomdtySeCode  "210004"

        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleLst"
                + "?apiKey=" + kidofcomdtySeCode
                + "&kidofcomdtySeCode=" + kidofcomdtySeCode;

        RestTemplate restTemplate = new RestTemplate();

        String xml =  restTemplate.getForObject(url, String.class);

        XmlMapper xmlMapper = new XmlMapper();
        Response response = xmlMapper.readValue(xml, Response.class);
        return response;
    }

}
