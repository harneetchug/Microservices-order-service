package com.example.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Order_TB")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  @Id
  private int id;
  private String name;
  private Double price;
  private int qty;

}
