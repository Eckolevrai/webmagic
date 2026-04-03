package us.codecraft.webmagic;

public class PageExtraction {
    private ResultItems resultItems = new ResultItems();

    public ResultItems getResultItems() {
        return resultItems;
    }

    public void putField(String key, Object field) {
        resultItems.put(key, field);
    }

    public void setSkip(boolean skip) {
        resultItems.setSkip(skip);
    }

    public void setRequest(Request request) {
        resultItems.setRequest(request);
    }
}
