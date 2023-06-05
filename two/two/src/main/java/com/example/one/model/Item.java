package com.example.one.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName="item")
public class Item {
    @JacksonXmlProperty(localName = "cntntsNo")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String cntntsNo;

    @JacksonXmlProperty(localName = "fileDownUrlInfo")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String fileDownUrlInfo;

    @JacksonXmlProperty(localName = "fileName")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlCData
    private String fileName;

}
