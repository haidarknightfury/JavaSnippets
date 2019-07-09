package com.example.otherpatterns.flux_pattern.view;

import com.example.otherpatterns.flux_pattern.action.ContentItem;
import com.example.otherpatterns.flux_pattern.store.ContentStore;
import com.example.otherpatterns.flux_pattern.store.Store;

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
