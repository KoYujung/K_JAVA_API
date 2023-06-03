package com.example.one.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Farm {
    private String resultCode;
    private String item;
    private String cntntsNo;
    private String fileDownUrlInfo;
    private String fileName;
    private String fileSeCode;
    private String orginlFileNm;
    private String sj;
}
