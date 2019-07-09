package com.example.otherpatterns.flux_pattern.view;

import com.example.otherpatterns.flux_pattern.action.MenuItem;
import com.example.otherpatterns.flux_pattern.dispatcher.Dispatcher;
import com.example.otherpatterns.flux_pattern.store.MenuStore;
import com.example.otherpatterns.flux_pattern.store.Store;

public class MenuView implements View {

    private MenuItem selected = MenuItem.HOME;

    public void itemClicked(MenuItem item) {
        Dispatcher.getInstance().menuItemSelected(item);
    }

    @Override
    public void render() {
        for (MenuItem item : MenuItem.values()) {
            if (this.selected.equals(item)) {
                System.out.println(item);
            } else {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void storeChanged(Store store) {
        MenuStore menuStore = (MenuStore) store;
        this.selected = menuStore.getSelected();
        this.render();
    }
}
