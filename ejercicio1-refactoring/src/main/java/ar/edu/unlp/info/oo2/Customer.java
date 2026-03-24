package ar.edu.unlp.info.oo2;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private String name; 
    private ArrayList<Rental> rentals = new ArrayList<>();
    public Customer(String name){
        this.name = name;
    }

    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public String getName(){
        return name; 
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            double thisAmount = 0;

            // Determinar montos para cada línea (El famoso Switch a refactorizar)
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // Añadir puntos de alquiler frecuente
            frequentRenterPoints++;
            // Bono por alquiler de un nuevo lanzamiento de más de un día
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && 
                each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // Mostrar cifras para este alquiler
            result += "\t" + each.getMovie().getTitle() + "\t" + 
                      String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // Añadir líneas de pie de página
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + 
                  " frequent renter points";
        return result;
    }
}