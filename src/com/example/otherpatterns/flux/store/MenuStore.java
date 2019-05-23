package com.example.otherpatterns.flux.store;

import com.example.otherpatterns.flux.action.Action;
import com.example.otherpatterns.flux.action.ActionType;
import com.example.otherpatterns.flux.action.MenuAction;
import com.example.otherpatterns.flux.action.MenuItem;

public class MenuStore extends Store {

    private MenuItem selected = MenuItem.HOME;

    public MenuItem getSelected() {
        return this.selected;
    }

    @Override
    public void onAction(Action action) {
        if (action.getType().equals(ActionType.MENU_ITEM_SELECTED)) {
            MenuAction menuAction = (MenuAction) action;
            this.selected = menuAction.getMenuItem();
            this.notifyChange();
        }
    }

}
