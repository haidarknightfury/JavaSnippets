package com.example.otherpatterns.flux_pattern.store;

import com.example.otherpatterns.flux_pattern.action.Action;
import com.example.otherpatterns.flux_pattern.action.ActionType;
import com.example.otherpatterns.flux_pattern.action.ContentAction;
import com.example.otherpatterns.flux_pattern.action.ContentItem;

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
