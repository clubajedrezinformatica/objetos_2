package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class HotelStay extends Product {
    private double cost;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost) {
        this.cost = cost;   
    }

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.setCost(cost);
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.getCost() / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }
}
