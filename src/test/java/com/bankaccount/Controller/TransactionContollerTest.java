package com.bankaccount.Controller;


import com.bankaccount.DAO.transaction;
import com.bankaccount.Service.DefaultTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionController.class, secure = false)
public class TransactionContollerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DefaultTransactionService transactionService;

    transaction mockTransaction= new transaction("A","Deposit",100,"2018-01-27 12:01:10");

    String Json="{\"amount\": 200000}";

    @Test
    public void getBalance() throws Exception {
        Mockito.when(transactionService.getBalance()).thenReturn(mockTransaction.getAmount());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/balance").accept(MediaType.APPLICATION_JSON_VALUE);
        MvcResult result =mvc.perform(requestBuilder).andReturn();
        String expected="{Balance: 100}";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

   // @Test

//    public void getAllTransactions()throws Exception{
//        Mockito.when(transactionService.getBalance()).thenReturn(mockTransaction.getAmount());
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions").accept(MediaType.APPLICATION_JSON_VALUE);
//        MvcResult result =mvc.perform(requestBuilder).andReturn();
//        String expected="[\n" +
//                "    {\n" +
//                "        \"reference\": \"A\",\n" +
//                "        \"type\": \"Deposit\",\n" +
//                "        \"amount\": 100,\n" +
//                "        \"time\": \"2018-01-27 12:01:10\"\n" +
//                "    }\n" +
//                "]";
//        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
//    }

    @Test
    public void deposit() throws Exception {

        transaction mockTransaction= new transaction("A","Deposit",10,"2018-01-27 12:01:10");
        Mockito.when(transactionService.depositFunds(Mockito.any(transaction.class))).thenReturn(String.valueOf(mockTransaction));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/deposit")
                .accept(MediaType.APPLICATION_JSON).content(Json)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();


        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

    @Test
    public void withdraw() throws Exception{
        transaction mockTransaction= new transaction("A","Deposit",10,"2018-01-27 12:01:10");
        Mockito.when(transactionService.withdrawFunds(Mockito.any(transaction.class))).thenReturn(String.valueOf(mockTransaction));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/withdraw")
                .accept(MediaType.APPLICATION_JSON).content(Json)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();


        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }



}
