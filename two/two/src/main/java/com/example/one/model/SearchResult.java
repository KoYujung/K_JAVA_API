package com.example.one.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;

//    private List<Book> items;
    private List<Farm> items;
}
