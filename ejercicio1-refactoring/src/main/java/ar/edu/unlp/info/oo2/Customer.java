package ar.edu.unlp.info.oo2;

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
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            // Mostrar cifras para este alquiler
            result += "\t" + each.getMovie().getTitle() + "\t" + 
                      String.valueOf(each.getCharge()) + "\n";
        }
        // Añadir líneas de pie de página
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + 
                  " frequent renter points";
        return result;
    }

    public String htmlStatement() {
    String result = "<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n";
    
    for (Rental each : rentals) {
        // Reutilizamos la lógica de cálculo sin repetirla
        result += each.getMovie().getTitle() + ": " + 
                String.valueOf(each.getCharge()) + "<br>\n";
    }
    result += "</p><p>You owed <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
    result += "<p>On this rental you earned <em>" + 
            String.valueOf(getTotalFrequentRenterPoints()) + 
            "</em> frequent renter points</p>";
    
    return result;
}

    private double getTotalCharge() {
        double result = 0;
        for (Rental each: rentals) {
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each: rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}