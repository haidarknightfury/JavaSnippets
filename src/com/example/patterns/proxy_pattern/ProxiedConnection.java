package com.example.patterns.proxy_pattern;

import java.util.ArrayList;
import java.util.List;

public class ProxiedConnection implements ConnectionAccess {

    private static List<String> list;
    static {
        list = new ArrayList<String>();
        list.add("abc.def");
        list.add("baka.otaku");
    }

    private ConnectionAccess connectionAccess = new RealConnection();

    @Override
    public void connectTo(String host) {
        if (list.contains(host)) {
            throw new IllegalAccessError("host is not available");
        }
        this.connectionAccess.connectTo(host);
    }

}
