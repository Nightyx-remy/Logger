package com.mystic.logger;

/**
 * This class is used to log info, warn, error and critical error in the console<br>
 * You can change the color of each type of log using {@link Logger#infoColor}, {@link Logger#warnColor}, {@link Logger#errorColor} and {@link Logger#criticalColor}<br>
 * You can also change the {@link Logger#logLevel}.<br>
 * <br>
 * To log an info see {@link Logger#info(String, String)}<br>
 * To log a warn see {@link Logger#warn(String, String)}<br>
 * To log an error see {@link Logger#error(String, String)}<br>
 * And too log a critical error see {@link Logger#critical(String, String)}<br>
 * <br>
 * @see TerminalColor
 */
public class Logger {

    /**
     * The Log level constants
     */
    public static final int
            INFO_LEVEL = 0,
            WARN_LEVEL = 1,
            ERROR_LEVEL = 2,
            CRITICAL_LEVEL = 3;

    public static int logLevel = INFO_LEVEL;

    public static TerminalColor infoColor = TerminalColor.RESET;
    public static TerminalColor warnColor = TerminalColor.YELLOW;
    public static TerminalColor errorColor = TerminalColor.MAGENTA;
    public static TerminalColor criticalColor = TerminalColor.RED;

    /**
     * Log an info to the console
     * @param type the info type (the category)
     * @param message the message you want to log
     */
    public static void info(String type, String message) {
        if(logLevel > INFO_LEVEL) return;
        System.out.print(infoColor.code);
        System.out.println("[" + type + " info]: " + message);
        System.out.print(TerminalColor.RESET.code);
    }

    /**
     * Log a warning to the console
     * @param type the warning type (the category)
     * @param message the message you want to log
     */
    public static void warn(String type, String message) {
        if(logLevel > WARN_LEVEL) return;
        System.out.print(warnColor.code);
        System.out.println("[" + type + " warn]: " + message);
        System.out.print(format(Thread.currentThread().getStackTrace()));
        System.out.print(TerminalColor.RESET.code);
    }

    /**
     * Log an error to the console
     * @param type the error type (the category)
     * @param message the message you want to log
     */
    public static void error(String type, String message) {
        if(logLevel > ERROR_LEVEL) return;
        System.out.print(errorColor.code);
        System.out.println("[" + type + " error]: " + message);
        System.out.print(format(Thread.currentThread().getStackTrace()));
        System.out.print(TerminalColor.RESET.code);
    }

    /**
     * Log a critical error to the console, it will exit the program with a -1 exit code.
     * @param type the critical error type (the category)
     * @param message the message you want to log
     */
    public static void critical(String type, String message) {
        if(logLevel > CRITICAL_LEVEL) return;
        System.out.print(criticalColor.code);
        System.out.println("[" + type + " critical]: " + message);
        System.out.print(format(Thread.currentThread().getStackTrace()));
        System.out.print(TerminalColor.RESET.code);
        System.exit(-1);
    }

    /**
     * This method is used to format the stackTrace into a printable String
     * @param stackTraceElements the stack trace you want to format
     * @return a string containing the stackTrace
     */
    private static String format(StackTraceElement[] stackTraceElements) {
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < stackTraceElements.length; i++) {
            StackTraceElement element = stackTraceElements[i];
            builder.append("\t").append("at ").append(element.getClassName()).append("(").append(element.getFileName())
                    .append(":").append(element.getLineNumber()).append(")").append("\n");
        }
        return builder.toString();
    }

}
