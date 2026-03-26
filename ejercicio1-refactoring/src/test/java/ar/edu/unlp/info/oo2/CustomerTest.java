package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;
    private Movie regularMovie;
    private Movie newReleaseMovie;
    private Movie childrensMovie;

    @BeforeEach
    void setUp() {
        customer = new Customer("Mauro");
        regularMovie = new Movie("Star Wars", Movie.REGULAR);
        newReleaseMovie = new Movie("Avatar 3", Movie.NEW_RELEASE);
        childrensMovie = new Movie("Toy Story", Movie.CHILDRENS);
    }

    @Test
    void testRegularMovieStatement() {
        customer.addRental(new Rental(regularMovie, 3)); // 2 (base) + 1.5 (extra) = 3.5
        String expected = "Rental Record for Mauro\n" +
                          "\tStar Wars\t3.5\n" +
                          "Amount owed is 3.5\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testNewReleaseStatement() {
        customer.addRental(new Rental(newReleaseMovie, 2)); // 2 * 3 = 6
        // Al ser New Release y > 1 día, suma 2 puntos
        String expected = "Rental Record for Mauro\n" +
                          "\tAvatar 3\t6.0\n" +
                          "Amount owed is 6.0\n" +
                          "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testChildrensMovieStatement() {
        customer.addRental(new Rental(childrensMovie, 4)); // 1.5 (base) + 1.5 (extra) = 3.0
        String expected = "Rental Record for Mauro\n" +
                          "\tToy Story\t3.0\n" +
                          "Amount owed is 3.0\n" +
                          "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    void testMultipleRentalsStatement() {
        customer.addRental(new Rental(regularMovie, 1));      // 2.0
        customer.addRental(new Rental(newReleaseMovie, 3));   // 9.0
        
        String expected = "Rental Record for Mauro\n" +
                          "\tStar Wars\t2.0\n" +
                          "\tAvatar 3\t9.0\n" +
                          "Amount owed is 11.0\n" +
                          "You earned 3 frequent renter points";
        assertEquals(expected, customer.statement());
    }
}