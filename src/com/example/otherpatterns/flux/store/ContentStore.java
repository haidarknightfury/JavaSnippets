package com.example.otherpatterns.flux.store;

import com.example.otherpatterns.flux.action.Action;
import com.example.otherpatterns.flux.action.ActionType;
import com.example.otherpatterns.flux.action.ContentItem;
import com.example.otherpatterns.flux.action.ContentAction;

public class ContentStore extends Store {

    private ContentItem content = ContentItem.PRODUCTS;

    public ContentItem getContent() {
        return this.content;
    }

    @Override
    public void onAction(Action action) {
        if (action.getType().equals(ActionType.CONTENT_CHANGED)) {
            ContentAction contentAction = (ContentAction) action;
            this.content = contentAction.getContent();
            this.notifyChange();
        }
    }

}
