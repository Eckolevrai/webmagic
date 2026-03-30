package us.codecraft.webmagic;

import us.codecraft.webmagic.selector.Selectable;

public class PageContext {
    private Request request;
    private Selectable url;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Selectable getUrl() {
        return url;
    }

    public void setUrl(Selectable url) {
        this.url = url;
    }
}
