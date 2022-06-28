package com.partho.poc.webcrawlerservice.clients;

import com.partho.poc.webcrawlerservice.model.HeadlineRequest;
import com.partho.poc.webcrawlerservice.model.HeadlineResponse;
import org.springframework.stereotype.Service;

@Service
public interface NewsFeedClient {


    HeadlineResponse getHeadLines(HeadlineRequest request);
}
