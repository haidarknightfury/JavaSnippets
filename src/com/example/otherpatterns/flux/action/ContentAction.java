package com.example.otherpatterns.flux.action;

public class ContentAction extends Action {

    private ContentItem content;

    public ContentAction(ContentItem content) {
        super(ActionType.CONTENT_CHANGED);
        this.setContent(content);
    }

    public ContentItem getContent() {
        return this.content;
    }

    public void setContent(ContentItem content) {
        this.content = content;
    }

}
