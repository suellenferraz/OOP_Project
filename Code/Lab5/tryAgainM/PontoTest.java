import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PontoTest {

    @Test
    public void testConstrutorEGetters() {
        Ponto p = new Ponto(2.0, 3.0);
        assertEquals(2.0, p.getX(), 0.001);
        assertEquals(3.0, p.getY(), 0.001);
    }

    @Test
    public void testToString() {
        Ponto p1 = new Ponto(2.0, 3.0);
        Ponto p2 = new Ponto(5.0, 7.0);
        assertEquals("(2,00,3,00)", p1.toString());
        assertEquals("(5,00,7,00)", p2.toString());
    }

    @Test
    public void testMove() {
        Ponto p1 = new Ponto(2.0, 3.0);
        p1.move(1.5, -0.5);
        assertEquals(3.5, p1.getX(), 0.001);
        assertEquals(2.5, p1.getY(), 0.001);

        Ponto p2 = new Ponto(5.0, 7.0);
        p2.move(-2.0, -3.0);
        assertEquals(3.0, p2.getX(), 0.001);
        assertEquals(4.0, p2.getY(), 0.001);
    }

    @Test
    public void testIsCollinear() {
        Ponto p1 = new Ponto(2.0, 3.0);
        Ponto p2 = new Ponto(5.0, 7.0);
        Ponto p3 = new Ponto(4.0, 6.0);
        Ponto p4 = new Ponto(6.0, 9.0);
        Ponto p5 = new Ponto(1.0, 2.0);

        assertTrue(p1.isCollinear(p3, p4));
        assertFalse(p1.isCollinear(p2, p5));
        assertTrue(p1.isCollinear(p1, p1));
    }

    @Test
    public void testScale() {
        Ponto p1 = new Ponto(2.0, 3.0);
        Ponto p2 = new Ponto(5.0, 7.0);
        Ponto centro = new Ponto(1.0, 1.0);

        p1.scale(centro, 2.0);
        assertEquals(3.0, p1.getX(), 0.001);
        assertEquals(5.0, p1.getY(), 0.001);

        p2.scale(centro, 0.5);
        assertEquals(3.0, p2.getX(), 0.001);
        assertEquals(4.0, p2.getY(), 0.001);
    }

    @Test
    public void testRotate() {
        Ponto p1 = new Ponto(2.0, 3.0);
        Ponto p2 = new Ponto(5.0, 7.0);
        Ponto centro = new Ponto(2.0, 3.0);
        Ponto centro2 = new Ponto(5.0, 5.0);
        Ponto p = new Ponto(4.0, 4.0);

        p1.rotate(centro, 90);
        assertEquals(2.0, p1.getX(), 0.001);
        assertEquals(3.0, p1.getY(), 0.001);

        p2.rotate(centro2, 180);
        assertEquals(5.0, p2.getX(), 0.001);
        assertEquals(3.0, p2.getY(), 0.001);

        p.rotate(centro, 360);
        assertEquals(4.0, p.getX(), 0.001);
        assertEquals(4.0, p.getY(), 0.001);
    }

   @Test
   public void testInvarianteQuadrante() {
        assertDoesNotThrow(() -> new Ponto(0.0, 0.0));
        assertDoesNotThrow(() -> new Ponto(1.0, 1.0));
    }
}