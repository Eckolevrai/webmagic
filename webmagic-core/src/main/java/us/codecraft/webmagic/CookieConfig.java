package us.codecraft.webmagic;

import java.util.*;

public class CookieConfig {
    private Map<String, String> defaultCookies = new LinkedHashMap<String, String>();
    private  Map<String, Map<String, String>> cookieByDomain = new HashMap<>();
    private boolean disableCookieManagement = false;

    public CookieConfig addDefaultCookie(String name, String value) {
        defaultCookies.put(name, value);
        return this;
    }

    public CookieConfig addCookie(String domain, String name, String value) {
        cookieByDomain.computeIfAbsent(domain, d -> new LinkedHashMap<>()).put(name, value);
        return this;
    }

    public Map<String, String> getDefaultCookies() {
        return Collections.unmodifiableMap(defaultCookies);
    }

    public Map<String, Map<String, String>> getCookieByDomain() {
        Map<String, Map<String, String>> result = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, String>> entry : cookieByDomain.entrySet()) {
            result.put(entry.getKey(), Collections.unmodifiableMap(entry.getValue()));
        }

        return Collections.unmodifiableMap(result);
    }

    public boolean isDisableCookieManagement() {
        return disableCookieManagement;
    }

    public CookieConfig setDisableCookieManagement(boolean disableCookieManagement) {
        this.disableCookieManagement = disableCookieManagement;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookieConfig that = (CookieConfig) o;
        return disableCookieManagement == that.disableCookieManagement
                && Objects.equals(defaultCookies, that.defaultCookies)
                && Objects.equals(cookieByDomain, that.cookieByDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultCookies, disableCookieManagement, cookieByDomain);
    }

    @Override
    public String toString() {
        return "CookieConfig{" +
                "defaultCookies=" + defaultCookies +
                ", cookiesByDomain=" + cookieByDomain +
                ", disableCookieManagement=" + disableCookieManagement +
                '}';
    }
}
