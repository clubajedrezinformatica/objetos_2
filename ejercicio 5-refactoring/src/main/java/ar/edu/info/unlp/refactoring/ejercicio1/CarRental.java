package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class CarRental extends Product {
    private double cost;
    private TimePeriod timePeriod;
    private Company company;

    public double getCost() {
        return cost;    
    }

    public void setCost(double cost) {
        this.cost = cost;   
    }

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        this.setCost(cost);
        this.timePeriod = timePeriod;
        this.company = company;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double cost() {
        return getCost();
    }
}
