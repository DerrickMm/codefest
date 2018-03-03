package com.bankaccount.DAO;

public class ErrorResponse {

    private int errorcode;
    private String message;

    public ErrorResponse() {

    }
    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
