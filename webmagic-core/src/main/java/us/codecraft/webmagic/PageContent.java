package us.codecraft.webmagic;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;

public class PageContent {
    private PageContext context;

    private Html html;
    private Json json;
    private String rawText;
    private byte[] bytes;
    private String charset;

    public PageContent(PageContext context) {
        this.context = context;
    }

    public Html getHtml() {
        if  (html == null) {
            String baseUrl = context.getRequest() != null ? context.getRequest().getUrl() : null;
            html = new Html(rawText, baseUrl);
        }
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public Json getJson() {
        if (json == null) {
            json = new Json(rawText);
        }
        return json;
    }

    public void setJson(Json json) {
        this.json = json;
    }

    public String getRawText() {
        return rawText;
    }

    public PageContent setRawText(String rawText) {
        this.rawText = rawText;
        return this;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public PageContent setBytes(byte[] bytes) {
        this.bytes = bytes;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public PageContent setCharset(String charset) {
        this.charset = charset;
        return this;
    }
}
