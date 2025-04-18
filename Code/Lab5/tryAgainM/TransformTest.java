import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformTest {
    @Test
    public void createTransformWithValidData() {
        Transform transform = new Transform("1.0 2.0 3 45.0 1.5");
        assertNotNull(transform);

        // Comparando as strings representando os pontos
        Ponto p = new Ponto(1.0, 2.0);
        assertEquals(p.toString(), transform.position().toString());

        assertEquals(3, transform.layer());
        assertEquals(45.0, transform.angle(), 0.001);  // Usando delta para doubles
        assertEquals(1.5, transform.scale(), 0.001);    // Usando delta para doubles
    }

    @Test
    public void moveTransformUpdatesPositionAndLayer() {
        Transform transform = new Transform("1.0 2.0 3 45.0 1.5");
        transform.move(new Ponto(2.0, 3.0), 2);

        // Comparando as strings dos pontos
        Ponto ponto = new Ponto(3.0, 5.0);
        assertEquals(ponto.toString(), transform.position().toString());

        assertEquals(5, transform.layer());
    }

    @Test
    public void rotateTransformUpdatesAngle() {
        Transform transform = new Transform("1.0 2.0 3 45.0 1.5");
        transform.rotate(15.0);
        assertEquals(60.0, transform.angle());
    }

    @Test
    public void scaleTransformUpdatesScale() {
        Transform transform = new Transform("1.0 2.0 3 45.0 1.5");
        transform.scale(0.5);
        assertEquals(2.0, transform.scale());
    }

    @Test
    public void toStringReturnsCorrectFormat() {
        Transform transform = new Transform("1.0 2.0 3 45.0 1.5");
        assertEquals("(1,00,2,00) 3 45,00 1,50", transform.toString());
    }
}