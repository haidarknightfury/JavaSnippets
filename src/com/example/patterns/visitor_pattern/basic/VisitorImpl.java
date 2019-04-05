package com.example.patterns.visitor_pattern.basic;

/**
 * Actual implementation of visitor class
 * The one actually to contain the logic
 * May have different VisitorImpl - therefore different strategies of calculation
 * @author hdargaye
 *
 */
public class VisitorImpl implements Visitor {

    @Override
    public int visit(Notebook notebook) {
        if (notebook.getNumberofpages() > 200) {
            return notebook.getPrice() + 50;
        } else {
            return notebook.getPrice();
        }
    }

    @Override
    public int visit(Pen pen) {
        int price = pen.getPrice();
        System.out.println("Pen price is " + price);
        return price;
    }

}
