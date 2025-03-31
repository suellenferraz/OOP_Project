import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransformTest {

    @Test
    void testConstrutorValido() {
        Transform transform = new Transform("10.5 20.0 1 45 2.0");
        assertEquals(10.5, transform.position().getX(), 0.001);
        assertEquals(20.0, transform.position().getY(), 0.001);
        assertEquals(1, transform.layer());
        assertEquals(45.0, transform.angle(), 0.001);
        assertEquals(2.0, transform.scale(), 0.001);
    }

    @Test
    void testConstrutorInvalido() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new Transform("10 20 1"); // Faltam angle e scale
        });
    }

    @Test
    void testMove() {
        Transform transform = new Transform("0 0 0 0 1.0");
        transform.move(new Ponto(2.5, 3.5), 1);

        assertEquals(2.5, transform.position().getX(), 0.001);
        assertEquals(3.5, transform.position().getY(), 0.001);
        assertEquals(1, transform.layer());
    }

    @Test
    void testRotate() {
        Transform transform = new Transform("0 0 0 0 1.0");
        transform.rotate(90.0);
        assertEquals(90.0, transform.angle(), 0.001);

        transform.rotate(350.0);
        assertEquals(80.0, transform.angle(), 0.001); // 90 + 350 = 440 → 440-360=80
    }

    @Test
    void testScale() {
        Transform transform = new Transform("0 0 0 0 1.0");
        transform.scale(0.5);
        assertEquals(1.5, transform.scale(), 0.001);

        transform.scale(-0.3);
        assertEquals(1.2, transform.scale(), 0.001);
    }

    @Test
    void testPosition() {
        Transform transform = new Transform("5.5 6.6 0 0 1.0");
        Ponto pos = transform.position();
        assertEquals(5.5, pos.getX(), 0.001);
        assertEquals(6.6, pos.getY(), 0.001);
    }

    @Test
    void testLayer() {
        Transform transform = new Transform("0 0 2 0 1.0");
        assertEquals(2, transform.layer());
    }

    @Test
    void testAngle() {
        Transform transform = new Transform("0 0 0 30.5 1.0");
        assertEquals(30.5, transform.angle(), 0.001);
    }

    @Test
    void testScaleValue() {
        Transform transform = new Transform("0 0 0 0 1.5");
        assertEquals(1.5, transform.scale(), 0.001);
    }

    @Test
    void testToString() {
        Transform transform = new Transform("10.5 20.0 1 45 2.0");
        String expected = "(10,50,20,00) 1 45,00 2,00";
        assertEquals(expected, transform.toString());
    }
}