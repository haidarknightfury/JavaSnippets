package com.example.otherpatterns.flux_pattern.action;

public abstract class Action {
    private ActionType type;

    public Action(ActionType type) {
        this.setType(type);
    }

    public ActionType getType() {
        return this.type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }
}
