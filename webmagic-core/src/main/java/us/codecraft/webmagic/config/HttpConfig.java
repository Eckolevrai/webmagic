package us.codecraft.webmagic.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import us.codecraft.webmagic.utils.HttpConstant;

public class HttpConfig {
    private static Set<Integer> DEFAULT_STATUS_CODES;

    static {
        Set<Integer> codes = new HashSet<>();
        codes.add(HttpConstant.StatusCode.CODE_200);
        DEFAULT_STATUS_CODES = Collections.unmodifiableSet(codes);
    }

    private int timeOut = 5000;
    private Set<Integer> acceptStatusCodes = new HashSet<>(DEFAULT_STATUS_CODES);
    private Map<String, String> headers = new HashMap<>();
    private boolean useGzip = false;

    public int getTimeOut() {
        return timeOut;
    }

    public HttpConfig setTimeOut(int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public Set<Integer> getAcceptStatusCodes() {
        return Collections.unmodifiableSet(acceptStatusCodes);
    }

    public HttpConfig setAcceptStatusCodes(Set<Integer> acceptStatusCodes) {
        this.acceptStatusCodes = new  HashSet<>(acceptStatusCodes);
        return this;
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    public HttpConfig addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public boolean isUseGzip() {
        return useGzip;
    }

    public HttpConfig setUseGzip(boolean useGzip) {
        this.useGzip = useGzip;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  HttpConfig)) return false;
        HttpConfig that = (HttpConfig) o;
        return timeOut == that.timeOut
                && useGzip == that.useGzip
                && Objects.equals(acceptStatusCodes, that.acceptStatusCodes)
                && Objects.equals(headers, that.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeOut, acceptStatusCodes, headers, useGzip);
    }

    @Override
    public String toString() {
        return "HttpConfig{" +
                "timeOut=" + timeOut +
                ", acceptStatusCodes=" + acceptStatusCodes +
                ", headers=" + headers +
                ", useGzip=" + useGzip +
                '}';
    }
}
