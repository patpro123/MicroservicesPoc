package com.partho.poc.webcrawlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class HeadlineResponse {

    private float totalArticles;
    private List<Article> articles;

}
