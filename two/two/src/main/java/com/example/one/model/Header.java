package com.example.one.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Header {
    @JacksonXmlProperty(localName = "resultCode")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String resultCode;

    @JacksonXmlProperty(localName = "resultMsg")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String resultMsg;

}
