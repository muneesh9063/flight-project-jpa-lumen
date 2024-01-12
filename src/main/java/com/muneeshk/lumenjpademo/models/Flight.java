package com.muneeshk.lumenjpademo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String flightCode;
    private String source;
    private String destination;
    private LocalDateTime time;
    private int capacity;
    @OneToMany(mappedBy = "customer")
    private List<Passenger> accounts = new ArrayList<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Passenger> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Passenger> accounts) {
        this.accounts = accounts;
    }
}