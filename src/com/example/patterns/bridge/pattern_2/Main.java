package com.example.patterns.bridge.pattern_2;

public class Main {

    public static void main(String[] args) {
        Enchantment enchantment = new FlyingEnchantment();
        Weapon weapon = new Sword(enchantment);
        weapon.wield();
        weapon.swing();
    }
}
