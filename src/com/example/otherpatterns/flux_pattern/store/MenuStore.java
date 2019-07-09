package com.example.otherpatterns.flux_pattern.store;

import com.example.otherpatterns.flux_pattern.action.Action;
import com.example.otherpatterns.flux_pattern.action.ActionType;
import com.example.otherpatterns.flux_pattern.action.MenuAction;
import com.example.otherpatterns.flux_pattern.action.MenuItem;

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
