import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SegmentoTest {

    // Testes para o construtor
    @Test
    void testConstrutorValido() {
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(1, 1);
        assertDoesNotThrow(() -> new Segmento(p1, p2));
    }

    @Test
    void testConstrutorInvalido() {
        Ponto p1 = new Ponto(1, 1);
        assertThrows(IllegalArgumentException.class, () -> new Segmento(p1, p1));
    }

    // Testes para getP1() e getP2()
    @Test
    void testGetP1() {
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(1, 1);
        Segmento segmento = new Segmento(p1, p2);
        assertEquals(p1, segmento.getP1());
    }

    @Test
    void testGetP2() {
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(1, 1);
        Segmento segmento = new Segmento(p1, p2);
        assertEquals(p2, segmento.getP2());
    }

    @Test
    void testSegmentosQueIntersectam() {
        // Segmento AB: (8,5) -> (8,1)
        // Segmento CD: (3,3) -> (9,3)

        Segmento s1 = new Segmento(new Ponto(8, 5), new Ponto(8, 1));
        Segmento s2 = new Segmento(new Ponto(3, 3), new Ponto(9, 3));

        assertEquals(1, s1.intersecao(s2));
    }

    @Test
    void testSegmentosQueNaoIntersectam() {
        // Segmento AB: (0,0) -> (2,2)
        // Segmento CD: (2,0) -> (3,2)

        Segmento s1 = new Segmento(new Ponto(0, 0), new Ponto(2, 2));
        Segmento s2 = new Segmento(new Ponto(2, 0), new Ponto(3, 2));

        assertEquals(0, s1.intersecao(s2));
    }


}