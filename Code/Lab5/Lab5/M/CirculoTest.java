import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    @Test
    public void testtoString0()
    {
        //devido a nossa implementacao, so podemos escrever os pontos da solucao
        String s;
        String finalS;
        Circulo f;

        s = "2 2 1";
        f = new Circulo(s);
        assertEquals("(2,00,2,00) 1,00", f.toString());

        s = "3 4 2";
        f = new Circulo(s);
        assertEquals("(3,00,4,00) 2,00", f.toString());

        s = "5 5 2";
        f = new Circulo(s);
        assertEquals("(5,00,5,00) 2,00", f.toString());
    }

    @Test
    public void TransTEST()
    {
        String s;
        FiguraGeometrica f;

        s = "2 2 1";
        f = new Circulo(s);
        f.move(4,5);
        assertEquals("(6,00,7,00) 1,00", f.toString());

        s = "3 4 2";
        f = new Circulo(s);
        f.move(-1,4);
        assertEquals("(2,00,8,00) 2,00", f.toString());

        s = "5 5 2";
        f = new Circulo(s);
        f.move(-2,-2);
        assertEquals("(3,00,3,00) 2,00", f.toString());
    }
}