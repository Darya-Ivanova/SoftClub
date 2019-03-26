package core.utils;

import org.apache.log4j.Logger;

public class Log {

    private static Logger getLog(String className) {
        return Logger.getLogger(className);
    }

    private static String getClassname() {
        StackTraceElement[] stackTrace = (new Throwable()).getStackTrace();
        return stackTrace[2].getClassName();
    }

    public static void debug(String message) {
        getLog(getClassname()).debug(message);
    }

    public static void info(String message) {
        getLog(getClassname()).info(message);
    }

    public static void warn(String message) {
        getLog(getClassname()).warn(message);
    }

    public static void error(String message) {
        getLog(getClassname()).error(message);
    }
}
