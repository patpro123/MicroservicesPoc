package com.partho.poc.webcrawlerservice.clients;

import com.partho.poc.webcrawlerservice.model.HeadlineRequest;
import com.partho.poc.webcrawlerservice.model.HeadlineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class gNewsClient implements NewsFeedClient {

    @Value("${gnews.endpoint}")
    private String gNewsEndpoint;

    @Value("${gnews.api.key}")
    private String apiToken;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public HeadlineResponse getHeadLines(HeadlineRequest request){


        String url = gNewsEndpoint+"top-headlines?token="+apiToken;
        try {
            String optionalUrl = request.getQuery();
            if(optionalUrl != null && !"".equals(optionalUrl)){
                url = url+optionalUrl;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ResponseEntity<HeadlineResponse> response = restTemplate.getForEntity(url, HeadlineResponse.class);
        System.out.println(response.getBody().getTotalArticles());
        return response.getBody();
    }
}
