package com.example.otherpatterns.flux_pattern.action;

public class MenuAction extends Action {
    private MenuItem menuItem;

    public MenuAction(MenuItem menuItem) {
        super(ActionType.MENU_ITEM_SELECTED);
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return this.menuItem;
    }

}
