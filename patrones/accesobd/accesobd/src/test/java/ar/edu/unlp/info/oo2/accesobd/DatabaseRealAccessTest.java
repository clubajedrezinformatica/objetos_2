package ar.edu.unlp.info.oo2.accesobd;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseRealAccessTest {
    private DatabaseAccess database;

    @BeforeEach
    void setUp() throws Exception {
        this.database = new DatabaseRealAccess();
    }

    @Test
    void testGetSearchResults() {
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.database.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.database.getSearchResults("select * from comics where id=10"));
    }

    @Test
    void testInsertNewRow() {
        assertEquals(3, this.database.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.database.getSearchResults("select * from comics where id=3"));
    }

    @Test 
    public void sinAutenticarNoDelegaAlRealSubject(){
        DatabaseAccessSpy spy = new DatabaseAccessSpy();
        DatabaseAccessProxy proxy = new DatabaseAccessProxy(spy);

        assertThrows(RuntimeException.class, 
            () -> proxy.getSearchResults("select * from comics where id=1")
        );
        assertFalse(spy.fueInvocado());
    }

    @Test 
    public void autenticadoDelegaAlRealSubject(){
        DatabaseAccessSpy spy = new DatabaseAccessSpy();
        DatabaseAccessProxy proxy = new DatabaseAccessProxy(spy);
        
        assertTrue(proxy.autenticar("admin", "1234"));
        proxy.getSearchResults("select * from comics where id=1");

        assertEquals(1, spy.getLlamadas().size());
    }
}