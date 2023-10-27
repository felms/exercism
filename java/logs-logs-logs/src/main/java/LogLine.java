public class LogLine {

    private final LogLevel logLvl;
    private final String message;
    public LogLine(String logLine) {
        String[] info = logLine.split(": ");
        this.logLvl = LogLevel.getLevel(info[0].replaceAll("[\\[\\]]", ""));
        this.message = info[1];
    }

    public LogLevel getLogLevel() {
        return this.logLvl;
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", this.logLvl.getShortFormat(), this.message);
    }
}
