package com.example.patterns.visitor_pattern.basic;

public class Notebook implements Item {

    private int numberofpages;
    private int price;

    public Notebook(int price, int numberofpages) {
        super();
        this.price = price;
        this.numberofpages = numberofpages;
    }

    /**
     * accept - a visitor class
     * pass this as reference - to refer to the object
     */
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public int getNumberofpages() {
        return this.numberofpages;
    }

    public int getPrice() {
        return this.price;
    }

    public void setNumberofpages(int numberofpages) {
        this.numberofpages = numberofpages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
