package com.example.otherpatterns.flux.view;

import com.example.otherpatterns.flux.action.ContentItem;
import com.example.otherpatterns.flux.store.ContentStore;
import com.example.otherpatterns.flux.store.Store;

public class ContentView implements View {

    private ContentItem content = ContentItem.PRODUCTS;

    @Override
    public void render() {
        System.out.println(this.content.toString());
    }

    @Override
    public void storeChanged(Store store) {
        ContentStore contentStore = (ContentStore) store;
        this.content = contentStore.getContent();
        this.render();
    }

}
