

RssFeed resolver

This micro-service takes a rss url as param and should give back title, description and a link to the article

You can just ignore the Product Folder, it was just to get a refresher
This project requires Rome to be installed, this is a tool designed for Rss feeds.
Postman commmand:

localhost:8080/rss?url=https://www.vg.no/rss/feed/?categories=1069 

localhost:8080/rss?url=https://www.nrk.no/toppsaker.rss

This can should be able to take in any rss feed that you give it.

I'm a bit unsure of what i want to do with this since converting the entire XML to Json has caused me some problems.

There is another command that just return the XML file as given by the rss:

Postman commmand:
localhost:8080/rss-to-xml?rssUrl=https://www.vg.no/rss/feed/?categories=1069

localhost:8080/rss-to-xml?rssUrl=https://www.nrk.no/toppsaker.rss