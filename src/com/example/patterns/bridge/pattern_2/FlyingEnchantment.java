package com.example.patterns.bridge.pattern_2;

public class FlyingEnchantment implements Enchantment {

    @Override
    public void apply() {
        System.out.println("Flying Enchantment");
    }

    @Override
    public void onActivate() {
        System.out.println("Activating");
    }

    @Override
    public void onDeactivate() {
        System.out.println("Deactivating");
    }

}
