public class LogLine {

    private LogLevel log;
    private String msg;

    public LogLine(String logLine) {
        String str = logLine.replaceAll("\\[|\\].*", "");
        this.log = switch(str) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };

        this.msg = logLine.replaceAll(".*:\\s+", "");
    }

    public LogLevel getLogLevel() {
        return this.log;
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", this.log.getShortFormat(), this.msg);
    }
}
