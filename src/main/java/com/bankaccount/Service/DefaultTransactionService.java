package com.bankaccount.Service;

import com.bankaccount.DAO.transaction;
import com.bankaccount.Entity.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class DefaultTransactionService implements TransactionsService {

    @Autowired
    private TransactionData transactionData;

    @Override
    public Collection<transaction> getAllTransaction() {
        return this.transactionData.getAllTransaction();
    }

    @Override
    public  Float getBalance() {
        return transactionData.getBalance();
    }

    @Override
    public String withdrawFunds(transaction withdraw) {
        if(getBalance()<withdraw.getAmount()){
            return "1";
        }else if(this.transactionData.getTransactionCount("Withdrawal")>=3){
            return "2";
        }else if(this.transactionData.getTransactionAmount("Withdrawal")-withdraw.getAmount()<-50000){
            return "3";
        }else if(withdraw.getAmount()>20000){
            return "4";
        }else {
            return transactionData.withdrawfunds(withdraw);
        }

    }

    @Override
    public String depositFunds(transaction deposit) {
        if(deposit.getAmount()>40000 ){
            return "1";
        }if(this.transactionData.getTransactionCount("Deposit")>=4 ){
            return "2";
        }if(deposit.getAmount()+this.transactionData.getTransactionAmount("Deposit")>150000){
            float max=150000-getBalance();
            return "3";
        }else {
            return transactionData.depositfunds(deposit);
        }
    }
}
