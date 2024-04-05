public enum LogLevel {
    UNKNOWN (0),
    TRACE (1),
    DEBUG (2),
    INFO (4),
    WARNING (5),
    ERROR (6),
    FATAL (42);

    private int shortFormat;
    
    private LogLevel(int shortFormat){
        this.shortFormat = shortFormat;
    }

    public int getShortFormat() {
        return this.shortFormat;
    }
}
