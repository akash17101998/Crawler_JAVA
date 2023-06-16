package Services;

import Logger.ILogger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Crawler {
    ILogger logger;
    String websitePath = "/Users/user/IdeaProjects/Logger/src/websites";

    int saveIntoFile(Path path, String data) {
        try{
            if(Files.exists(path)) {
                Files.createFile(path);
            }
            FileWriter fw = new FileWriter( path.toString());
            fw.write(data);
        } catch (IOException e) {}
        return 0;
    }

    public  Crawler(ILogger lg) {
        logger = lg;
    }
    public void crawl(String url) {
   try {
       Path p = Paths.get(websitePath);
       if(!Files.exists(p)) {
           Files.createDirectory(p);
       }
       Document document = Jsoup.connect(url).get();
       Path index = Path.of(websitePath+"/index.html");
       saveIntoFile(index, document.toString());
       for (Node n : document.select("a")) {
           if(n.hasAttr("href")) {
               String a = n.attr("href");
               if(!(a.startsWith("/") || a.startsWith("http"))) {
                   String s = "https://www.javatpoint.com/" + a;
                   System.out.println(s);

                   Document document1 = Jsoup.connect(s).get();
                   Path link = Path.of(websitePath+ "/"+a+".html");
                   saveIntoFile(link, document1.toString());
               }

           }
       }
       System.out.println("download successfully");
   }catch (Exception e){
       e.printStackTrace();
   }
    }
}
