package com.example.otherpatterns.flux_pattern;

import com.example.otherpatterns.flux_pattern.action.MenuItem;
import com.example.otherpatterns.flux_pattern.dispatcher.Dispatcher;
import com.example.otherpatterns.flux_pattern.store.ContentStore;
import com.example.otherpatterns.flux_pattern.store.MenuStore;
import com.example.otherpatterns.flux_pattern.view.ContentView;
import com.example.otherpatterns.flux_pattern.view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuStore menuStore = new MenuStore();
        Dispatcher.getInstance().registerStore(menuStore);

        ContentStore contentStore = new ContentStore();
        Dispatcher.getInstance().registerStore(contentStore);

        MenuView menuView = new MenuView();
        menuStore.registerView(menuView);

        ContentView contentView = new ContentView();
        contentStore.registerView(contentView);

        menuView.render();
        contentView.render();

        menuView.itemClicked(MenuItem.COMPANY);

    }
}
