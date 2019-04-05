package com.example.patterns.visitor_pattern.basic;

/**
 * Item behavior class
 * accepts a visitor class which do the calculation in the place of item
 * @author hdargaye
 *
 */
public interface Item {

    public int accept(Visitor visitor);

}
