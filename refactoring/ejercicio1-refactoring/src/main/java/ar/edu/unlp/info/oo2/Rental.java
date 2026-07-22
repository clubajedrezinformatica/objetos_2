package ar.edu.unlp.info.oo2;

public class Rental {
    private Movie movie; 
    private int daysRented;

    public Rental(Movie movie, int daysRented){
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return getMovie().getCharge(daysRented);
    }

    int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(daysRented);
    }


}