package com.example.otherpatterns.feature_toggle.versions;

import com.example.otherpatterns.feature_toggle.user.User;

public interface Service {

    String getWelcomeMessage(User user);

    boolean isEnhanced();
}
