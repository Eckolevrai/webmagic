package us.codecraft.webmagic.config;

import java.util.Objects;

public class RetryConfig {
    private int retryTimes = 0;
    private int cycleRetryTimes = 0;
    private int retrySleepTime = 1000;
    private int sleepTime = 5000;

    public int getRetryTimes() {
        return retryTimes;
    }

    public RetryConfig setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
        return this;
    }

    public int getCycleRetryTimes() {
        return cycleRetryTimes;
    }

    public RetryConfig setCycleRetryTimes(int cycleRetryTimes) {
        this.cycleRetryTimes = cycleRetryTimes;
        return this;
    }

    public int getRetrySleepTime() {
        return retrySleepTime;
    }

    public RetryConfig setRetrySleepTime(int retrySleepTime) {
        this.retrySleepTime = retrySleepTime;
        return this;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public RetryConfig setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RetryConfig)) return false;
        RetryConfig that = (RetryConfig) o;
        return retryTimes == that.retryTimes
                && cycleRetryTimes == that.cycleRetryTimes
                && retrySleepTime == that.retrySleepTime
                && sleepTime == that.sleepTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(retryTimes, cycleRetryTimes, retrySleepTime, sleepTime);
    }

    @Override
    public String toString() {
        return "RetryConfig{" +
                "retryTimes=" + retryTimes +
                ", cycleRetryTimes=" + cycleRetryTimes +
                ", retrySleepTime=" + retrySleepTime +
                ", sleepTime=" + sleepTime +
                '}';
    }
}
