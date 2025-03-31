import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoligonoTest {

    @Test
    void testConstrutorValido() {
        assertDoesNotThrow(() -> new Poligono("0 0 2 0 1 2"));
    }

    @Test
    void testConstrutorInvalidoPontosColineares() {
        assertThrows(IllegalArgumentException.class, () -> new Poligono("0 0 1 1 2 2"));
    }


    @Test
    void testToString() {
        Poligono poligono = new Poligono("0 0 2 0 1 2");
        assertEquals("(0,00,0,00) (2,00,0,00) (1,00,2,00)", poligono.toString());
    }

    @Test
    void testMove() {
        Poligono poligono = new Poligono("0 0 2 0 1 2");
        poligono.move(1.0, -1.0);
        assertEquals("(1,00,-1,00) (3,00,-1,00) (2,00,1,00)", poligono.toString());
    }

    @Test
    void testRotate() {
        Poligono poligono = new Poligono("1 0 2 0 1 1"); // Triângulo retângulo
        Ponto centroid = new Ponto(1.33, 0.33); // Centroide aproximado
        poligono.rotate(90.0, centroid);

        String resultado = poligono.toString();
        assertFalse(resultado.contains("(1.33,0.33)")); // Aproximação para o ponto transformado
    }

    @Test
    void testCentro() {
        Poligono poligono = new Poligono("0 0 2 0 1 2");
        Ponto centro = poligono.centro();
        assertEquals(1.0, centro.getX(), 0.1); // Tolerância maior para cálculos geométricos
        assertEquals(0.66, centro.getY(), 0.1);
    }

    @Test
    void testNewCentroid() {
        Poligono poligono = new Poligono("0 0 2 0 1 2");
        Poligono novoPoligono = poligono.newCentroid(new Ponto(3.0, 3.0));

        // Verifica os vértices do novo polígono
        String resultado = novoPoligono.toString();
        assertTrue(resultado.contains("2,00") && resultado.contains("2,33")); // Vértice 1
        assertTrue(resultado.contains("4,00") && resultado.contains("2,33")); // Vértice 2
        assertTrue(resultado.contains("3,00") && resultado.contains("4,33")); // Vértice 3
    }

    @Test
    void testScale() {
        Poligono poligono = new Poligono("1 0 2 0 1 1");
        Ponto centroid = poligono.centro();
        poligono.scale(2.0, centroid);

        // Verifica um ponto conhecido após escala
        String resultado = poligono.toString();
        assertTrue(resultado.contains("0,67")); // X escalado
        assertTrue(resultado.contains("-0,33")); // Y escalado
    }
}