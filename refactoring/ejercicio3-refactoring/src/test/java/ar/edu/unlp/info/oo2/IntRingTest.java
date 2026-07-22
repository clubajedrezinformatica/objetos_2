package ar.edu.unlp.info.oo2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IntRingTest {

    @Test
    public void shouldReturnIntegersInOrder() {
        IntRing ring = new IntRing(new int[] {1, 2, 3});

        assertEquals(1, ring.next());
        assertEquals(2, ring.next());
        assertEquals(3, ring.next());
    }

    @Test
    public void shouldWrapAroundWhenReachingTheEnd() {
        IntRing ring = new IntRing(new int[] {7, 9});

        assertEquals(7, ring.next());
        assertEquals(9, ring.next());
        assertEquals(7, ring.next());
        assertEquals(9, ring.next());
    }
}