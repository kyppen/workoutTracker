package com.example.demo.rssResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.http.ResponseEntity;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@RestController
public class RssController {

    @Autowired
    private RssService rssService;


    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/rss-to-xml")
    public ResponseEntity<String> convertRssToXml(@RequestParam String rssUrl) {
        try {
            // Fetch and parse the RSS feed
            SyndFeed feed = rssService.getSyndFeed(rssUrl);
            System.out.println("convertRssToXML");
            // Convert the SyndFeed object back to XML
            String xmlOutput = rssService.convertFeedToXml(feed);
            return ResponseEntity.ok(xmlOutput);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("<error>Failed to fetch or parse RSS feed</error>");
        }
    }

    @GetMapping("/rss")
    public String getRssFeed (@RequestParam("url") String feedUrl) throws IOException, FeedException {
        String jsonObject = rssService.getRssFeedJson(feedUrl);
        return jsonObject;
    }

}
