package com.example.memmgt.esc_references;

public class Customer implements CustomerReadOnly {

    private String name;
    private String contact;

    public Customer(String name, String contact) {
        super();
        this.name = name;
        this.contact = contact;
    }

    public Customer(CustomerReadOnly customer) {
        this.name = customer.getName();
        this.contact = customer.getContact();
    }

    /* (non-Javadoc)
     * @see com.example.memmgt.esc_references.CustomerRead#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see com.example.memmgt.esc_references.CustomerRead#getContact()
     */
    @Override
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    /* (non-Javadoc)
     * @see com.example.memmgt.esc_references.CustomerRead#toString()
     */
    @Override
    public String toString() {
        return "Customer [name=" + this.name + ", contact=" + this.contact + "]";
    }

}
