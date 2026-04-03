package us.codecraft.webmagic;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Object storing extracted result and urls to fetch.<br>
 * Not thread safe.<br>
 * Main method：                                               <br>
 * {@link #getUrl()} get url of current page                   <br>
 * {@link #getHtml()}  get content of current page                 <br>
 * {@link #putField(String, Object)}  save extracted result            <br>
 * {@link #getResultItems()} get extract results to be used in {@link us.codecraft.webmagic.pipeline.Pipeline}<br>
 * {@link #addTargetRequests(Iterable)} {@link #addTargetRequest(String)} add urls to fetch                 <br>
 *
 * @author code4crafter@gmail.com <br>
 * @see us.codecraft.webmagic.downloader.Downloader
 * @see us.codecraft.webmagic.processor.PageProcessor
 * @since 0.1.0
 */
public class Page {
    private PageContext context;
    private PageContent content;
    private PageResponse response;
    private PageExtraction extraction;
    private PageTargets targets;

    public static Page ofSuccess(Request request) {
        return new Page(request, true);
    }

    public static Page ofFailure(Request request) {
        return new Page(request, false);
    }

    public Page() {
        this.context = new PageContext();
        this.content = new PageContent(context);
        this.response = new PageResponse();
        this.extraction = new PageExtraction();
        this.targets = new PageTargets(context);
    }

    private Page(Request request, boolean downloadSuccess) {
        this();
        setRequest(request);
        setDownloadSuccess(downloadSuccess);
    }

    public Page setSkip(boolean skip) {
        extraction.setSkip(skip);
        return this;
    }

    public void putField(String key, Object field) {
        extraction.putField(key, field);
    }

    public Html getHtml() {
        return content.getHtml();
    }

    public Json getJson() {
        return content.getJson();
    }

    public List<Request> getTargetRequests() {
        return targets.getTargetRequests();
    }

    public void addTargetRequests(Iterable<String> requests) {
        targets.addTargetRequests(requests);
    }

    public void addTargetRequests(Iterable<String> requests, long priority) {
        targets.addTargetRequests(requests, priority);
    }

    public void addTargetRequest(String requestString) {
        targets.addTargetRequest(requestString);
    }

    public void addTargetRequest(Request request) {
        targets.addTargetRequest(request);
    }

    public Selectable getUrl() {
        return context.getUrl();
    }

    public void setUrl(Selectable url) {
        context.setUrl(url);
    }

    public Request getRequest() {
        return context.getRequest();
    }

    public void setRequest(Request request) {
        context.setRequest(request);
        extraction.setRequest(request);
    }

    public ResultItems getResultItems() {
        return extraction.getResultItems();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public void setStatusCode(int statusCode) {
        response.setStatusCode(statusCode);
    }

    public String getRawText() {
        return content.getRawText();
    }

    public Page setRawText(String rawText) {
        content.setRawText(rawText);
        return this;
    }

    public Map<String, List<String>> getHeaders() {
        return response.getHeaders();
    }

    public void setHeaders(Map<String, List<String>> headers) {
        response.setHeaders(headers);
    }

    public boolean isDownloadSuccess() {
        return response.isDownloadSuccess();
    }

    public void setDownloadSuccess(boolean downloadSuccess) {
        response.setDownloadSuccess(downloadSuccess);
    }

    public byte[] getBytes() {
        return content.getBytes();
    }

    public void setBytes(byte[] bytes) {
        content.setBytes(bytes);
    }

    public String getCharset() {
        return content.getCharset();
    }

    public void setCharset(String charset) {
        content.setCharset(charset);
    }

    public PageContext context() {
        return context;
    }

    public PageContent content() {
        return content;
    }

    public PageResponse response() {
        return response;
    }

    public PageExtraction extraction() {
        return extraction;
    }

    public PageTargets targets() {
        return targets;
    }

    @Override
    public String toString() {
        return "Page{" +
                "request=" + getRequest() +
                ", resultItems=" + getResultItems() +
                ", html=" + content().getHtml() +
                ", json=" + content().getJson() +
                ", rawText='" + getRawText() + '\'' +
                ", url=" + getUrl() +
                ", headers=" + getHeaders() +
                ", statusCode=" + getStatusCode() +
                ", downloadSuccess=" + isDownloadSuccess() +
                ", targetRequests=" + getTargetRequests() +
                ", charset='" + getCharset() + '\'' +
                ", bytes=" + Arrays.toString(getBytes()) +
                '}';
    }
}
