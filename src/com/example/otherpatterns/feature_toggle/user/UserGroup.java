package com.example.otherpatterns.feature_toggle.user;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {

    private static List<User> freeGroup = new ArrayList<User>();
    private static List<User> paidGroup = new ArrayList<>();

    public static void addUserToFreeGroup(final User user) {
        if (paidGroup.contains(user)) {
            throw new IllegalArgumentException(" User is already group of paidgroup");
        } else {
            if (!freeGroup.contains(user)) {
                freeGroup.add(user);
            }
        }
    }

    public static void addUserToPaidGroup(final User user) {
        if (freeGroup.contains(user)) {
            throw new IllegalArgumentException("free group already contains this user");
        } else {
            if (!paidGroup.contains(user)) {
                paidGroup.add(user);
            }
        }
    }

    public static boolean isPaid(User user) {
        return paidGroup.contains(user);
    }

}
