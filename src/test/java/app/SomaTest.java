package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

public class SomaTest {
    Soma soma;

    @BeforeEach
    public void setup() {
        soma = new Soma();
    }

    @Test
    public void testSomaSuccess() {
        assertEquals(4, soma.soma("2", "2"));
    }

    @Test
    public void testSomaFirstInputString() {
        assertThrows(IllegalArgumentException.class, ()->{
            soma.soma("a", "1");
        });
    }

    @Test
    public void testSomaLastInputString() {
        assertThrows(IllegalArgumentException.class, ()->{
            soma.soma("1", "a");
        });
    }

    @Test
    public void testSomaBothInputString() {
        assertThrows(IllegalArgumentException.class, ()->{
            soma.soma("a", "a");
        });
    }
}