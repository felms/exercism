import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {
    
    public static String message(String logLine) {
        Pattern pattern = Pattern.compile("^\\[.+\\]:\\s+(.*)$");
        Matcher m = pattern.matcher(logLine);
        return m.find() ? m.group(1).trim() : "";
    }

    public static String logLevel(String logLine) {
        Pattern pattern = Pattern.compile("^\\[(.+)].*");
        Matcher m = pattern.matcher(logLine);
        return m.find() ? m.group(1).toLowerCase() : "";
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}
