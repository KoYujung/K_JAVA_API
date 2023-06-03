package com.example.one.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
@Getter
@Setter
@ToString
public class Response {
    @XmlElement(name = "header")
    private Header header;

    @XmlElement(name = "body")
    private Body body;

}
