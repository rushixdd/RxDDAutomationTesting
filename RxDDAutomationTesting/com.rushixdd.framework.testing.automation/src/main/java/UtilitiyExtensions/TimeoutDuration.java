package UtilitiyExtensions;

public enum TimeoutDuration {

    // Timeout values in seconds
    SECOND_1(1, 1000),
    SECOND_5(5, 5000),
    SECOND_10(10, 10000),
    SECOND_20(20, 20000),
    SECOND_30(30, 30000),
    SECOND_60(60, 60000),
    SECOND_120(120, 120000),
    SECOND_180(180, 180000),
    SECOND_300(300, 300000);

    private final int seconds;
    private final int milliseconds;

    TimeoutDuration(int seconds, int milliseconds) {
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    @Override
    public String toString() {
        return seconds + " seconds (" + milliseconds + " milliseconds)";
    }
}