package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CharRingTest {

    @Test
    public void shouldReturnCharactersInOrder() {
        CharRing ring = new CharRing("abc");

        assertEquals('a', ring.next());
        assertEquals('b', ring.next());
        assertEquals('c', ring.next());
    }

    @Test
    public void shouldWrapAroundWhenReachingTheEnd() {
        CharRing ring = new CharRing("ab");

        assertEquals('a', ring.next());
        assertEquals('b', ring.next());
        assertEquals('a', ring.next());
        assertEquals('b', ring.next());
    }
}