package com.example.otherpatterns.feature_toggle;

import java.util.Properties;

import com.example.otherpatterns.feature_toggle.user.User;
import com.example.otherpatterns.feature_toggle.user.UserGroup;
import com.example.otherpatterns.feature_toggle.versions.PropertiesFeatureToggleVersion;
import com.example.otherpatterns.feature_toggle.versions.Service;
import com.example.otherpatterns.feature_toggle.versions.TieredFeatureToggleVersion;

public class Main {

    public static void main(String[] args) {
        final Properties properties = new Properties();
        properties.put("enhancedWelcome", true);
        Service service = new PropertiesFeatureToggleVersion(properties);
        String welcomeMessage = service.getWelcomeMessage(new User("ohayo"));
        System.out.println(welcomeMessage);

        User user = new User("HD");
        User user2 = new User("HD");
        UserGroup.addUserToFreeGroup(user);
        UserGroup.addUserToPaidGroup(user2);
        Service service2 = new TieredFeatureToggleVersion();
        String welcomemes2 = service2.getWelcomeMessage(user);
        System.out.println(welcomemes2);

        System.out.println(service2.getWelcomeMessage(user2));

    }
}
