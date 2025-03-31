import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColliderTest {

    @Test
    void constructorComPoligonoInvalido() {
        Ponto centroid = new Ponto(0, 0);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,() -> new Collider(centroid, "0 0 1 1 2 2 3 3 4 4 5 5 6 6")
        );
        assertEquals("Poligono:vi", exception.getMessage());
    }

    @Test
    void construtorComInputValido() {
        Ponto centroid = new Ponto(0, 0);
        assertThrows(IllegalArgumentException.class, () -> new Collider(centroid, "0 0"));
    }

    @Test
    void valorDoCentroid() {
        Ponto centroid = new Ponto(0, 0);
        Collider collider = new Collider(centroid, "0 0 5");
        assertEquals(centroid, collider.centroid());
    }


    @Test
    void rotatePoligono() {
        // 1. Define um polígono válido (triângulo)
        Ponto centroid = new Ponto(0, 0);
        Collider collider = new Collider(centroid, "0 0 2 0 1 1");
        String estadoInicial = collider.toString();
        collider.rotate(90);
        assertNotEquals(estadoInicial, collider.toString());
        assertTrue(collider.toString().contains("-1,00,1,00")); // Ponto (1,1) rotacionado
    }

    @Test
    void scaleCirculo() {
        Ponto centroid = new Ponto(0, 0);
        Collider collider = new Collider(centroid, "0 0 5");
        collider.scale(2);
        assertTrue(collider.toString().contains("10"));
    }

    @Test
    void scalePoligonoValido() {
        Ponto centroid = new Ponto(0, 0);
        // Usando um quadrado válido (não-colinear)
        Collider collider = new Collider(centroid, "0 0 2 0 2 2 0 2");
        String antes = collider.toString();
        collider.scale(2);
        assertNotEquals(antes, collider.toString());
        assertFalse(collider.toString().contains("4,00,400")); // Ponto (2,2) escalado 2x
    }

    @Test
    void centroidValue() {
        Ponto centroid = new Ponto(0, 0);
        Collider collider = new Collider(centroid, "0 0 5");
        assertEquals(centroid, collider.centroid());
    }
}