import Logger.FileLogger;
import Services.Crawler;

public class Main {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Insufficient arguments provided. use --help");
            return;
        }

        if(args[0].equals("--help")) {
            System.out.println("Usage: cmd <url>");
            return;
        }



        Crawler crawler = new Crawler(new FileLogger("crawl_log"));
        crawler.crawl(args[0]);

    }
}