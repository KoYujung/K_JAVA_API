package com.example.one.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class Item {
    @XmlElement(name = "cntntsNo")
    private String cntntsNo;

    @XmlElement(name = "fileDownUrlInfo")
    private int fileDownUrlInfo;

    @XmlElement(name = "fileName")
    private String fileName;
}
