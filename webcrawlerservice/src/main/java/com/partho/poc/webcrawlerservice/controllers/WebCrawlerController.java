package com.partho.poc.webcrawlerservice.controllers;

import com.partho.poc.webcrawlerservice.clients.NewsFeedClient;
import com.partho.poc.webcrawlerservice.model.HeadlineRequest;
import com.partho.poc.webcrawlerservice.model.HeadlineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebCrawlerController {

    @Autowired
    public NewsFeedClient newsFeedClient;

    @RequestMapping(value="/wc/getnewsfeed", method = RequestMethod.GET)
    @ResponseBody
    public HeadlineResponse getNewsFeed(@RequestParam String topic,
                                        @RequestParam(required = false) String lang,
                                        @RequestParam(required = false) String country,
                                        @RequestParam(required = false) String query,
                                        @RequestParam(required = false) String max
                                        ){
        HeadlineRequest request = new HeadlineRequest(topic,country,lang,query,max);
        return newsFeedClient.getHeadLines(request);
    }
}
