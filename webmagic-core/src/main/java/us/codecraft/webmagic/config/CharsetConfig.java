package us.codecraft.webmagic.config;

import java.util.Objects;

public class CharsetConfig {

    private String charset;
    private String defaultCharset;

    public String getCharset() {
        return charset;
    }

    public CharsetConfig setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getDefaultCharset() {
        return defaultCharset;
    }

    public CharsetConfig setDefaultCharset(String defaultCharset) {
        this.defaultCharset = defaultCharset;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharsetConfig)) return false;
        CharsetConfig that = (CharsetConfig) o;
        return Objects.equals(charset, that.charset) &&
                Objects.equals(defaultCharset, that.defaultCharset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charset, defaultCharset);
    }

    @Override
    public String toString() {
        return "CharsetConfig{" +
                "charset='" + charset + '\'' +
                ", defaultCharset='" + defaultCharset + '\'' +
                '}';
    }
}
