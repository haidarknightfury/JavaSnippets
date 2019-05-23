package com.example.otherpatterns.feature_toggle.versions;

import java.util.Properties;

import com.example.otherpatterns.feature_toggle.user.User;

public class PropertiesFeatureToggleVersion implements Service {

    private boolean isEnhanced;

    public PropertiesFeatureToggleVersion(final Properties properties) {
        if (properties == null) {
            throw new IllegalArgumentException("No properties provided");
        } else {
            try {
                this.isEnhanced = (boolean) properties.get("enhancedWelcome");
            } catch (Exception e) {
                throw e;
            }

        }
    }

    @Override
    public String getWelcomeMessage(User user) {
        return this.isEnhanced() ? "Welcome " + user + ". You are using enhanced version" : "Welcome to the application";
    }

    @Override
    public boolean isEnhanced() {
        return this.isEnhanced;
    }

}
