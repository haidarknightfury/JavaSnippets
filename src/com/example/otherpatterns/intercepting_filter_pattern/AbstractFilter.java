package com.example.otherpatterns.intercepting_filter_pattern;

public abstract class AbstractFilter implements Filter {

    private Filter next;

    public AbstractFilter() {
    }

    public AbstractFilter(Filter next) {
        this.next = next;
    }

    @Override
    public void setNext(Filter filter) {
        this.next = filter;
    }

    @Override
    public Filter getNext() {
        return this.next;
    }

    @Override
    public Filter getLast() {
        Filter last = this;
        while (this.getNext() != null) {
            last = last.getNext();
        }
        return last;
    }

    @Override
    public String execute(Order order) {
        if (this.getNext() != null) {
            return this.getNext().execute(order);
        } else {
            return "";
        }
    }

}
