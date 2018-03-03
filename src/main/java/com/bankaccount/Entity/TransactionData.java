package com.bankaccount.Entity;
import com.bankaccount.DAO.transaction;
import org.springframework.stereotype.Repository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class TransactionData {

    private String transactionReference() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    private String currentTimestamp(){
        DateFormat TSdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return TSdateFormat.format(date);
    }

    public int getTransactionAmount(String type){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int sum =0;
        Collection<transaction> values=transactions.values();
        for (transaction i : values) {
            if(i.getType().equals(type) && i.getTime().substring(0,10).equals(dateFormat.format(date))){
                sum +=i.getAmount();
            }
        }
        return sum;
    }

    public int getTransactionCount(String type){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int count =0;
        Collection<transaction> values=transactions.values();
        for (transaction i : values) {
            if(i.getType().equals(type) && i.getTime().substring(0,10).equals(dateFormat.format(date))){
                count ++;
            }
        }
        return count;
    }

    private static Map<Integer, transaction> transactions;
    static {
        transactions=new HashMap<Integer, transaction>(){
        };
    }

    public Collection<transaction> getAllTransaction(){
        return this.transactions.values();
    }

    public float getBalance(){
        float balance =0;
        Collection<transaction> values=transactions.values();
        for (transaction i : values) {
            balance += i.getAmount();
        }
        return balance;
    }


    public String depositfunds(transaction deposit) {
        int number=this.transactions.size()+1;
        this.transactions.put(number,new transaction(transactionReference(),"Deposit",deposit.getAmount(),currentTimestamp()));
        return "success";
    }

    public String withdrawfunds(transaction withdraw) {
        int index=this.transactions.size();
        this.transactions.put(index+1, new transaction(transactionReference(),"Withdrawal",-withdraw.getAmount(),currentTimestamp()));
        return "success";
    }
}
