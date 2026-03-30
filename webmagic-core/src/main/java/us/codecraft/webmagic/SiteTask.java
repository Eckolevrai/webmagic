package us.codecraft.webmagic;

import java.util.UUID;

public class SiteTask {

    private SiteTask() {
    }

    public static Task fromSite(Site site) {
        return new Task() {
            @Override
            public String getUUID() {
                String uuid = site.getDomain();
                return uuid != null ? uuid : UUID.randomUUID().toString();
            }

            @Override
            public Site getSite() {
                return site;
            }
        };
    }
}
