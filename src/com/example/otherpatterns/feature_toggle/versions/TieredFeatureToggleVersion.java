package com.example.otherpatterns.feature_toggle.versions;

import com.example.otherpatterns.feature_toggle.user.User;
import com.example.otherpatterns.feature_toggle.user.UserGroup;

public class TieredFeatureToggleVersion implements Service {

    @Override
    public String getWelcomeMessage(User user) {
        return UserGroup.isPaid(user) ? user + " paid for the application" : "you can use it unpaid";
    }

    @Override
    public boolean isEnhanced() {
        return true;
    }

}
