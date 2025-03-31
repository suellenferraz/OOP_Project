import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PontoTest {

    @Test
    void testConstrutorGets() {
        Ponto p = new Ponto(3.5, 4.2);
        assertEquals(3.5, p.getX(), 0.001);
        assertEquals(4.2, p.getY(), 0.001);
    }

    // Testes para toString()
    @Test
    void testToString() {
        Ponto p1 = new Ponto(3.0, 4.0);
        assertEquals("(3,00,4,00)", p1.toString());

        Ponto p2 = new Ponto(0.0, 0.0);
        assertEquals("(0,00,0,00)", p2.toString());

        Ponto p3 = new Ponto(123.456, 789.123);
        assertEquals("(123,46,789,12)", p3.toString()); // Verifica arredondamento
    }

    // Testes para move()
    @Test
    void testMove() {
        Ponto p = new Ponto(2.0, 3.0);

        // Movimento positivo
        p.move(1.5, 2.5);
        assertEquals(3.5, p.getX(), 0.001);
        assertEquals(5.5, p.getY(), 0.001);

        // Movimento negativo
        p.move(-1.0, -2.0);
        assertEquals(2.5, p.getX(), 0.001);
        assertEquals(3.5, p.getY(), 0.001);

        // Movimento zero
        p.move(0.0, 0.0);
        assertEquals(2.5, p.getX(), 0.001);
        assertEquals(3.5, p.getY(), 0.001);
    }

    // Testes para isCollinear()
    @Test
    void testIsCollinear() {
        Ponto p1 = new Ponto(1.0, 1.0);

        // Caso colinear (mesma linha horizontal)
        Ponto p2 = new Ponto(2.0, 1.0);
        Ponto p3 = new Ponto(3.0, 1.0);
        assertTrue(p1.isCollinear(p2, p3));

        // Caso colinear (mesma linha vertical)
        Ponto p4 = new Ponto(1.0, 2.0);
        Ponto p5 = new Ponto(1.0, 3.0);
        assertTrue(p1.isCollinear(p4, p5));

        // Caso colinear (linha diagonal)
        Ponto p6 = new Ponto(2.0, 2.0);
        Ponto p7 = new Ponto(3.0, 3.0);
        assertTrue(p1.isCollinear(p6, p7));

        // Caso não colinear
        Ponto p8 = new Ponto(2.0, 3.0);
        Ponto p9 = new Ponto(3.0, 2.0);
        assertFalse(p1.isCollinear(p8, p9));

        // Caso com pontos iguais
        assertTrue(p1.isCollinear(p1, p1));
    }

    @Test
    void testInvarianteQuadrante() {
        assertDoesNotThrow(() -> new Ponto(0.0, 0.0));
        assertDoesNotThrow(() -> new Ponto(1.0, 1.0));
    }
}