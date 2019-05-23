package com.example.patterns.bridge.pattern_2;

public class Sword implements Weapon {

    private Enchantment enchantment;

    public Sword(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public Enchantment getEnchantment() {
        return this.enchantment;
    }

    @Override
    public void swing() {
        this.enchantment.apply();
    }

    @Override
    public void unwield() {
        this.enchantment.onDeactivate();
    }

    @Override
    public void wield() {
        this.enchantment.onActivate();
    }

}
