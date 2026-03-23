package us.codecraft.webmagic;

import java.util.Objects;

public class SiteConfig {
    private String domain;
    private String userAgent;

    public String getDomain() {
        return domain;
    }

    public SiteConfig setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public SiteConfig setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof SiteConfig)) {
            return false;
        }

        SiteConfig that = (SiteConfig) o;
        return Objects.equals(domain, that.domain) && Objects.equals(userAgent, that.userAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, userAgent);
    }

    @Override
    public String toString() {
        return "SiteConfig{" +
                "domain='" + domain + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
