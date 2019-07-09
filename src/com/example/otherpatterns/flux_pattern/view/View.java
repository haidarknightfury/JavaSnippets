package com.example.otherpatterns.flux_pattern.view;

import com.example.otherpatterns.flux_pattern.store.Store;

public interface View {

    void render();

    void storeChanged(Store store);
}
