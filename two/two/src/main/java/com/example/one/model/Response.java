package com.example.one.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    @JacksonXmlProperty(localName = "header")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Header header;


    @JacksonXmlProperty(localName = "body")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Body body;


/*
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Header {
        @JacksonXmlProperty(localName = "resultCode")
        @JacksonXmlElementWrapper(useWrapping = false)
        private String resultCode;

        @JacksonXmlProperty(localName = "resultMsg")
        @JacksonXmlElementWrapper(useWrapping = false)
        private String resultMsg;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Body {
        @JacksonXmlProperty(localName = "items")
        @JacksonXmlElementWrapper(useWrapping = false)
        private Items items;


    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Items {
        @JacksonXmlProperty(localName = "items")
        @JacksonXmlElementWrapper(useWrapping = false)
        private List<Items> items;


    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Item {
        @JacksonXmlProperty(localName = "cntntsNo")
        @JacksonXmlElementWrapper(useWrapping = false)
        private String cntntsNo;

        @JacksonXmlProperty(localName = "fileDownUrlInfo")
        @JacksonXmlElementWrapper(useWrapping = false)
        private int fileDownUrlInfo;

        @JacksonXmlProperty(localName = "fileName")
        @JacksonXmlElementWrapper(useWrapping = false)
        private String fileName;

    }*/
}
