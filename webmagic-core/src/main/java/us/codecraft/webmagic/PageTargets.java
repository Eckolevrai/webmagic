package us.codecraft.webmagic;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

public class PageTargets {
    private List<Request> targetRequests = new ArrayList<>();
    private PageContext context;

    public PageTargets(PageContext context) {
        this.context = context;
    }

    public List<Request> getTargetRequests() {
        return targetRequests;
    }

    public void addTargetRequests(Iterable<String> requests) {
        addTargetRequests(requests, 0);
    }

    public void addTargetRequests(Iterable<String> requests, long priority) {
        if (requests == null) {
            return;
        }

        for (String req : requests) {
            addRequestIfValid(req, priority);
        }
    }

    public void addTargetRequest(String requestString) {
        if (StringUtils.isBlank(requestString) || requestString.equals("#") || requestString.startsWith("javascript:")) {
            return;
        }

        String canonicalizedUrl = canonicalize(requestString);
        targetRequests.add(new Request(canonicalizedUrl));
    }

    public void addTargetRequest(Request request) {
        if (request != null) {
            targetRequests.add(request);
        }
    }

    private void addRequestIfValid(String url, long priority) {
        if (StringUtils.isBlank(url) || url.equals("#") || url.startsWith("javascript:")) {
            return;
        }

        String canonicalizedUrl = canonicalize(url);
        Request req = new Request(canonicalizedUrl);
        if (priority > 0) {
            req.setPriority(priority);
        }
        targetRequests.add(req);
    }

    private String canonicalize(String url) {
        Selectable pageUrl = context.getUrl();
        String baseUrl = pageUrl != null ? pageUrl.toString() : null;
        return UrlUtils.canonicalizeUrl(url, baseUrl);
    }
}
