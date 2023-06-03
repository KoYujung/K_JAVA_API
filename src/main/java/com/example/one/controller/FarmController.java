package com.example.one.controller;

import com.example.one.model.Farm;
import com.example.one.model.Response;
import com.example.one.model.SearchResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
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
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@RestController
@RequestMapping("/farm")
public class FarmController {

    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("/get")
    @ResponseBody
    public String getBook(@RequestParam String query1, String query2) throws Exception {


        String url = "http://api.nongsaro.go.kr/service/farmWorkingPlanNew/workScheduleLst?apiKey=" + query1
                + "&kidofcomdtySeCode=" + query2;

        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", "20230601JKDXVD39FWGMF0PJBPWMA");
        headers.set("kidofcomdtySeCode", "210004");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), String.class);

        String xml = responseEntity.getBody();

        //Response response = (Response) xmlToObject(json, Response.class);


        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Response response = (Response)  unmarshaller.unmarshal(new StringReader(xml));
        //logger.info(response.getBody().toString());

//        for(Farm farm : searchResult.getItems()){
//            sqlSessionTemplate.insert("farm.insertFarm", farm);
//        }
        return "Hello " + query1;
    }


    public static Object xmlToObject(String xml, Class<?> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new IllegalArgumentException("Error while converting xml to object", e);
        }
    }
    @GetMapping("/list")
    @ResponseBody
    public List<Farm> listBook(@RequestParam String query1)  {

        List<Farm> farms = sqlSessionTemplate.selectList("farm.insertFarm", query1);

        return farms;
    }
}
