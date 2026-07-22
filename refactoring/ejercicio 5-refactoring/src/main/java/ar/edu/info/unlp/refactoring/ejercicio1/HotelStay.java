package ar.edu.info.unlp.refactoring.ejercicio1;

public class HotelStay extends Product {
    private double quote;
    private Hotel hotel;

    public double getCost() {
        return quote;
    }
    
    public void setCost(double cost) {
        this.quote = cost;   
    }

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        super(timePeriod);
        this.setCost(cost);
        this.hotel = hotel;
    }

    public double priceFactor() {
        return this.getCost() / this.price();
    }

    public double price() {
        return this.hotel.calculatePrice(this.timePeriod);
    }
}
