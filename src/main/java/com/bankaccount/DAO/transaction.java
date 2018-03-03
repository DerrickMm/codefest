package com.bankaccount.DAO;

public class transaction {

    private String reference;
    private String type;
    private float amount;
    private String time;

    //constructor

    public transaction(String reference, String type, float amount, String time){
        this.reference=reference;
        this.type=type;
        this.amount=amount;
        this.time=time;
    }

    // default constructor
    public transaction(){

    }

    //Getters and Setters

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
