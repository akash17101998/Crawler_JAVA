package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class FileLogger implements ILogger {
    String path = "/Users/user/IdeaProjects/Logger/src/logs/";
    public FileLogger(String name) {
        Date dated = new Date();
        path += name + dated.getTime() + ".txt";
    }
    public int log(String msg) {
        Date dated = new Date();
        try(FileWriter fw = new FileWriter(path)) {
            fw.append(dated.toString() + " " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg.length();
    }
}
