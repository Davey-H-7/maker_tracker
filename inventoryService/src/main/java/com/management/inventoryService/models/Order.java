package com.management.inventoryService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name ="orders")
public class Order {

    @Column(name ="client")
    private String client;

    @Column(name ="dueDate")
    private Date dueDate;

    @Column(name ="priority")
    private Priority priority;

    @JsonIgnoreProperties("order")
    @OneToMany(cascade = ALL, mappedBy = "order")
    private List<Item> items;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Order(String client, Date dueDate) {
        this.client = client;
        this.dueDate = dueDate;
        this.priority = Priority.Low;

    }

    public Order() {
        this.priority = Priority.Low;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
