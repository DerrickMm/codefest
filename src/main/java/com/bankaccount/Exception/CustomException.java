package com.bankaccount.Exception;

public class CustomException extends Exception {
    private static final long serialVersionUID = -8359815273355580630L;
    private String errormessage;

    public String getErrormessage(){
        return errormessage;
    }

    public CustomException(String errormessage){
        super(errormessage);
        this.errormessage=errormessage;
    }
    public  CustomException(){
        super();
    }
}
