package com.example.patterns.visitor_pattern.basic;

/**
 * Visitor class
 * a method for each type of item
 * @author hdargaye
 *
 */
public interface Visitor {

    int visit(Notebook notebook);

    int visit(Pen pen);

}
