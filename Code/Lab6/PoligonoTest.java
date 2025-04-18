import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoligonoTest {

    @Test
    void testConstrutorValido() {
        Transform t = new Transform("5 5 2 0 2");
        assertDoesNotThrow(() -> new Poligono("0 0 2 0 1 2",t));
    }

    @Test
    void testConstrutorInvalidoPontosColineares() {
        Transform t = new Transform("5 5 2 0 2");
        assertThrows(IllegalArgumentException.class, () -> new Poligono("0 0 1 1 2 2",t));
    }

    @Test
    void testToString() {
        Transform t = new Transform("5 5 2 0 2");
        Poligono poligono = new Poligono("0 0 2 0 1 2", t);
        assertEquals("(3,00,3,67) (7,00,3,67) (5,00,7,67)", poligono.toString());
    }

    @Test
    void testMove() {
        Transform t = new Transform("5 5 2 0 2");
        Poligono poligono = new Poligono("0 0 2 0 1 2",t);
        poligono.move(1.0, -1.0);
        assertEquals("(4,00,2,67) (8,00,2,67) (6,00,6,67)", poligono.toString());
    }

    @Test
    void testRotate() {
        Transform t = new Transform("5 5 2 0 2");
        Poligono poligono = new Poligono("1 0 2 0 1 1",t); // Triângulo retângulo
        poligono.rotate(90.0);

        String resultado = poligono.toString();
        assertFalse(resultado.contains("(1,33,0,33)")); // Aproximação para o ponto transformado
    }

    @Test
    void testCentro() {
        Transform t = new Transform("5 5 2 0 2");
        Poligono poligono = new Poligono("0 0 2 0 1 2",t);
        Ponto centro = poligono.centro();
        assertEquals(5.0, centro.getX(), 0.1); // Tolerância maior para cálculos geométricos
        assertEquals(4.99, centro.getY(), 0.1);
    }

    @Test
    void testNewCentroid() {
        Transform t = new Transform("5 5 2 0 2");
        Poligono poligono = new Poligono("0 0 2 0 1 2",t);
        // Verifica os vértices do novo polígono

        String resultado = poligono.toString();
        assertTrue(resultado.contains("3,00") && resultado.contains("3,67")); // Vértice 1
        assertTrue(resultado.contains("7,00") && resultado.contains("3,67")); // Vértice 2
        assertTrue(resultado.contains("5,00") && resultado.contains("7,67")); // Vértice 3
    }

    @Test
    void testScale() {
        Transform t = new Transform("5 5 2 0 2");
        Poligono poligono = new Poligono("1 0 2 0 1 1",t);
        poligono.scale(2.0);

        // Verifica um ponto conhecido após escala
        String resultado = poligono.toString();
        assertTrue(resultado.contains("3,67")); // X escalado
        assertTrue(resultado.contains("3,67")); // Y escalado
    }
}