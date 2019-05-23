package com.example.otherpatterns.flux.store;

import java.util.LinkedList;
import java.util.List;

import com.example.otherpatterns.flux.action.Action;
import com.example.otherpatterns.flux.view.View;

public abstract class Store {

    private List<View> views = new LinkedList<View>();

    protected void notifyChange() {
        this.views.stream().forEach(view -> view.storeChanged(this));
    }

    public abstract void onAction(Action action);

    public void registerView(View view) {
        this.views.add(view);
    }

}
