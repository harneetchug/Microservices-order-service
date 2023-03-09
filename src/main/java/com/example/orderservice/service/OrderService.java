package com.example.orderservice.service;

import com.example.orderservice.common.Payment;
import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private RestTemplate restTemplate;

  public TransactionResponse saveOrder(TransactionRequest transactionRequest)
  {

    Order order = transactionRequest.getOrder();
    Payment payment =transactionRequest.getPayment();
    payment.setOrderId(order.getId());
    payment.setAmount(order.getPrice());

    Payment paymentres= restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
    TransactionResponse response = new TransactionResponse();
    response.setOrder(order);
    response.setTransactionId(paymentres.getTransactionId());


    orderRepository.save(order);

    return response;
  }

}
