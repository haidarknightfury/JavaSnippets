package com.example.otherpatterns.flux_pattern.dispatcher;

import java.util.LinkedList;
import java.util.List;

import com.example.otherpatterns.flux_pattern.action.Action;
import com.example.otherpatterns.flux_pattern.action.ContentAction;
import com.example.otherpatterns.flux_pattern.action.ContentItem;
import com.example.otherpatterns.flux_pattern.action.MenuAction;
import com.example.otherpatterns.flux_pattern.action.MenuItem;
import com.example.otherpatterns.flux_pattern.store.Store;

public class Dispatcher {

    private static Dispatcher instance = new Dispatcher();

    public static Dispatcher getInstance() {
        return instance;
    }

    private List<Store> stores = new LinkedList<>();

    private Dispatcher() {
    }

    private void dispatchAction(Action action) {
        this.stores.stream().forEach(store -> store.onAction(action));
    }

    public void menuItemSelected(MenuItem menuItem) {
        this.dispatchAction(new MenuAction(menuItem));
        switch (menuItem) {
        case HOME:
        case PRODUCTS:
        default:
            this.dispatchAction(new ContentAction(ContentItem.PRODUCTS));
            break;
        case COMPANY:
            this.dispatchAction(new ContentAction(ContentItem.COMPANY));
            break;
        }

    }

    public void registerStore(Store store) {
        this.stores.add(store);
    }
}
