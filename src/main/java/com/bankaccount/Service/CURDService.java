package com.bankaccount.Service;

import java.util.Collection;


public interface CURDService<T> {

    Collection<T> getAllTransaction();

     Float getBalance();

    String withdrawFunds(T entity);

    String depositFunds(T entity);

}
