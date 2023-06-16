package Logger;

import Logger.ILogger;

public class LoggerService {
    ILogger logService;
    public LoggerService(ILogger ls) {
        logService = ls;
    }
    public void log(String msg) {
        logService.log(msg);
    }

}
