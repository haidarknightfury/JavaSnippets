package com.example.otherpatterns.flux;

import com.example.otherpatterns.flux.action.MenuItem;
import com.example.otherpatterns.flux.dispatcher.Dispatcher;
import com.example.otherpatterns.flux.store.ContentStore;
import com.example.otherpatterns.flux.store.MenuStore;
import com.example.otherpatterns.flux.view.ContentView;
import com.example.otherpatterns.flux.view.MenuView;

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
