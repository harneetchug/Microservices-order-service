package com.example.orderservice.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

  private int paymentId;
  private double amount;
  private int orderId;
  private String paymentStatus;
  private String transactionId;

}
