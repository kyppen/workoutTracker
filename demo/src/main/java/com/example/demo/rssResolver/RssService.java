package com.example.demo.rssResolver;


import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.SyndFeedOutput;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.io.StringWriter;



import java.io.IOException;
import java.net.URL;
import java.util.List;




@Service("customRssService")
public class RssService {
    public List<SyndEntry> getRssFeed(String feedUrl) throws IOException, FeedException {

        URL url = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(url));
        return feed.getEntries();
    }
    public SyndFeed getSyndFeed(String url) throws Exception {
        URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        return input.build(new XmlReader(feedUrl));
    }
    public String convertFeedToXml(SyndFeed feed) throws Exception {
        SyndFeedOutput output = new SyndFeedOutput();
        StringWriter writer = new StringWriter();
        output.output(feed, writer);
        System.out.println(output.toString());
        return writer.toString();
    }

    public String getRssFeedJson(String feedUrl) throws IOException, FeedException {

        try{
            URL url = new URL(feedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(url));


            System.out.println( "Feed Title " + feed.getTitle());
            System.out.println( "Feed Description " + feed.getDescription());


            JSONArray array = new JSONArray();

            feed.getEntries().forEach(entry -> {


                //Getting Title, link to article and Publication date, returning this as a Jso
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Link", entry.getLink());
                jsonObject.put("Description", entry.getDescription().toString());
                jsonObject.put("Title", entry.getTitle());
                jsonObject.put("PubDate", entry.getPublishedDate());
                //Adding all times to a Json arrow that we can return.
                array.add(jsonObject);
            });

            return array.toJSONString();
        }catch (IOException | FeedException e){
            e.printStackTrace();
        }
        return null;
    }


}

