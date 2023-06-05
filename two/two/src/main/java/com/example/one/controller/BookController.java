//package com.example.one.controller;
//
//import com.example.one.model.Book;
//import com.example.one.model.SearchResult;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectReader;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/book")
//public class BookController {
//
//
//    private Log logger = LogFactory.getLog(this.getClass());
//
//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    @GetMapping("/get")
//    @ResponseBody
//    public String getBook(@RequestParam String query) throws IOException {
//
//        String url = "https://openapi.naver.com/v1/search/book.json?query=" + query
//                + "&display=10&start=1&sort=sim";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Naver-Client-Id", "8fwthSTB3nhUPo52wost");
//        headers.set("X-Naver-Client-Secret", "qK3enOFUB_");
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), String.class);
//
//        String json = responseEntity.getBody();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<SearchResult>(){});
//        SearchResult searchResult = objectReader.readValue(json);
//
//        for(Book book : searchResult.getItems()){
//            sqlSessionTemplate.insert("book.insertBook", book);
//        }
//        return "Hello " + query;
//    }
//
//    @GetMapping("/list")
//    @ResponseBody
//    public List<Book> listBook(@RequestParam String query)  {
//
//        List<Book> books = sqlSessionTemplate.selectList("book.listBook", query);
//
//        return books;
//    }
//}
