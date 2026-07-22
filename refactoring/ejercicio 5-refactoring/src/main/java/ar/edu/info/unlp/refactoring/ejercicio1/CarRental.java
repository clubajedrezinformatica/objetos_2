package ar.edu.info.unlp.refactoring.ejercicio1;

public class CarRental extends Product {
    private double cost;
    private Company company;

    public double getCost() {
        return cost;    
    }

    public void setCost(double cost) {
        this.cost = cost;   
    }

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        super(timePeriod);
        this.setCost(cost);
        this.company = company;
    }

    public double price() {
        return this.company.priceWithPromotion();
    }

    public double cost() {
        return getCost();
    }
}
