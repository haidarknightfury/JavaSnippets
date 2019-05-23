package com.example.patterns.bridge.pattern_2;

public interface Weapon {

    Enchantment getEnchantment();

    void swing();

    void unwield();

    void wield();
}
