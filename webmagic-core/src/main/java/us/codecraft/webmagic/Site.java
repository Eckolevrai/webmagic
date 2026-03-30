package us.codecraft.webmagic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import us.codecraft.webmagic.CharsetConfig;
import us.codecraft.webmagic.CookieConfig;
import us.codecraft.webmagic.HttpConfig;
import us.codecraft.webmagic.RetryConfig;
import us.codecraft.webmagic.SiteConfig;

/**
 * Object contains setting for crawler.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @see us.codecraft.webmagic.processor.PageProcessor
 * @since 0.1.0
 */
public class Site {
    private SiteConfig identity = new SiteConfig();
    private CookieConfig cookieConfig = new CookieConfig();
    private CharsetConfig charsetConfig = new CharsetConfig();
    private RetryConfig retryConfig = new RetryConfig();
    private HttpConfig httpConfig = new HttpConfig();

    public static Site me() {
        return new Site();
    }

    public SiteConfig identity() {
        return identity;
    }

    public CookieConfig cookies() {
        return cookieConfig;
    }
    public CharsetConfig charset() {
        return charsetConfig;
    }

    public RetryConfig retry() {
        return retryConfig;
    }

    public HttpConfig http() {
        return httpConfig;
    }

    public Site setDomain(String domain) {
        identity.setDomain(domain);
        return this;
    }

    public String getDomain() {
        return identity.getDomain();
    }

    public Site setUserAgent(String userAgent) {
        identity.setUserAgent(userAgent);
        return this;
    }

    public String getUserAgent() {
        return identity.getUserAgent();
    }

    public Site addCookie(String name, String value) {
        cookieConfig.addDefaultCookie(name, value);
        return this;
    }

    public Site addCookie(String domain, String name, String value) {
        cookieConfig.addCookie(domain, name, value);
        return this;
    }

    public Map<String, String> getCookies() {
        return cookieConfig.getDefaultCookies();
    }

    public Map<String, Map<String, String>> getAllCookies() {
        return cookieConfig.getCookieByDomain();
    }

    public Site setDisableCookieManagement(boolean disableCookieManagement) {
        cookieConfig.setDisableCookieManagement(disableCookieManagement);
        return this;
    }

    public boolean isDisableCookieManagement() {
        return cookieConfig.isDisableCookieManagement();
    }

    public Site setCharset(String charset) {
        charsetConfig.setCharset(charset);
        return this;
    }

    public String getCharset() {
        return charsetConfig.getCharset();
    }

    public Site setDefaultCharset(String defaultCharset) {
        charsetConfig.setDefaultCharset(defaultCharset);
        return this;
    }

    public String getDefaultCharset() {
        return charsetConfig.getDefaultCharset();
    }

    public Site setSleepTime(int sleepTime) {
        retryConfig.setSleepTime(sleepTime);
        return this;
    }

    public int getSleepTime() {
        return retryConfig.getSleepTime();
    }

    public Site setRetrySleepTime(int retryTime) {
        retryConfig.setRetrySleepTime(retryTime);
        return this;
    }

    public int getRetrySleepTime() {
        return retryConfig.getRetrySleepTime();
    }

    public Site setCycleRetryTimes(int cycleRetryTimes) {
        retryConfig.setCycleRetryTimes(cycleRetryTimes);
    }

    public int getCycleRetryTimes() {
        return retryConfig.getCycleRetryTimes();
    }

    public Site setRetrySleepTime(int retrySleepTime) {
        retryConfig.setRetrySleepTime(retrySleepTime);
        return this;
    }

    public int getRetrySleepTime() {
        return retryConfig.getRetrySleepTime();
    }

    public Site setTimeOut(int timeOut) {
        httpConfig.setTimeOut(timeOut);
        return this;
    }

    public int getTimeOut() {
        return httpConfig.getTimeOut();
    }

    public Site setAcceptStatCode(Set<Integer> acceptStatCodes) {
        httpConfig.setAcceptStatusCodes(acceptStatCodes);
        return this;
    }

    public Set<Integer> getAcceptStatCodes() {
        return httpConfig.getAcceptStatusCodes();
    }

    public Site addHeader(String name, String value) {
        httpConfig.addHeader(name, value);
        return this;
    }

    public Map<String, String> getHeaders() {
        return httpConfig.getHeaders();
    }

    public Site setUseGzip(boolean useGzip) {
        httpConfig.setUseGzip(useGzip);
        return this;
    }

    public boolean isUseGzip() {
        return httpConfig.isUseGzip();
    }

    @Override
    public String toString() {
        return "Site{" +
                "identity=" + identity +
                ", cookieConfig=" + cookieConfig +
                ", charsetConfig=" + charsetConfig +
                ", retryConfig=" + retryConfig +
                ", httpConfig=" + httpConfig +
                '}';
    }
}
