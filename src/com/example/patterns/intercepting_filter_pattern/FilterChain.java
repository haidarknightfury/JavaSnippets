package com.example.patterns.intercepting_filter_pattern;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public void execute(String request) {
        this.filters.stream().forEach(filter -> filter.execute(request));
        this.target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}
