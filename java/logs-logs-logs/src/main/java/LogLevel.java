public enum LogLevel {

    UNKNOWN (0),
    TRACE (1),
    DEBUG (2),
    INFO (4),
    WARNING (5),
    ERROR (6),
    FATAL (42);

    private final int shortFormat;

    LogLevel(int shortFormat) {
        this.shortFormat = shortFormat;
    }

    public static LogLevel getLevel(String level) {
        return switch (level) {
            case "TRC" ->  LogLevel.TRACE;
            case "DBG" ->  LogLevel.DEBUG;
            case "INF" ->  LogLevel.INFO;
            case "WRN" ->  LogLevel.WARNING;
            case "ERR" ->  LogLevel.ERROR;
            case "FTL" ->  LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    public int getShortFormat() {
        return this.shortFormat;
    }
}
