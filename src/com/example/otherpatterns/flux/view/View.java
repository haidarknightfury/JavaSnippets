package com.example.otherpatterns.flux.view;

import com.example.otherpatterns.flux.store.Store;

public interface View {

    void render();

    void storeChanged(Store store);
}
