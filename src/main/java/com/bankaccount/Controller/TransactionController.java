package com.bankaccount.Controller;

import com.bankaccount.Exception.CustomException;
import com.bankaccount.Service.DefaultTransactionService;
import com.bankaccount.DAO.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController

public class TransactionController {

    @Autowired

    private DefaultTransactionService transactionService;

    //Return all transactions

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public Collection<transaction> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    //Do a fund deposit
    @RequestMapping(value = "/deposit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deposit(@RequestBody transaction deposit) throws CustomException{

        String responce = transactionService.depositFunds(deposit);
        if(responce=="3") {
            throw new CustomException("You have exceeded your maximum Deposit amount");
        }
        else if(responce=="1"){
            throw new CustomException("Maximum Deposit amount is 40,0000");
        }else if(responce=="2"){
            throw new CustomException("You have Reached your four daily maximum Deposits");
        }else {

            return new ResponseEntity<>(Collections.singletonMap("Response",responce),HttpStatus.CREATED);
        }
    }

    //Do a funds withdrawal.
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> withdraw(@RequestBody transaction withdraw) throws CustomException {

        String responce= transactionService.withdrawFunds(withdraw);
        if(responce=="4") {
            throw new CustomException("Maximum withdraw amount is 20,000");
        }
        else if(responce=="1"){
            throw new CustomException("Insufficient Funds in your account");
        }else if (responce=="2"){
            throw new CustomException("You have withdrawn three times today");
        }else if(responce=="3") {
            throw new CustomException("You have reached your withdrawal limit of 50000");
        }else {
            return new ResponseEntity<>(Collections.singletonMap("Response",responce),HttpStatus.CREATED);

        }
    }
    //Check account balance.
    @RequestMapping(value = "/balance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getBalance() {
        return Collections.singletonMap("Balance", transactionService.getBalance());
    }


}
