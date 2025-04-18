import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    @Test
    public void testtoString0()
    {
        //devido a nossa implementacao, so podemos escrever os pontos da solucao
        String s;
        Circulo f;
        Transform t = new Transform("2 3 2 0 1");

        s = "2 2 1";
        f = new Circulo(s,t);
        assertEquals("(2,00,3,00) 1,00", f.toString());

        s = "3 4 2";
        f = new Circulo(s,t);
        assertEquals("(2,00,3,00) 2,00", f.toString());

        s = "5 5 2";
        f = new Circulo(s,t);
        assertEquals("(2,00,3,00) 2,00", f.toString());
    }

    @Test
    public void TransTEST()
    {
        String s;
        Collider f;
        Transform t = new Transform("5 5 2 0 2");

        s = "2 2 1";
        f = new Circulo(s,t);
        f.move(4,5);
        assertEquals("(5,00,5,00) 1,00", f.toString());

        s = "3 4 2";
        f = new Circulo(s,t);
        f.move(-1,4);
        assertEquals("(5,00,5,00) 2,00", f.toString());

        s = "7 7 2";
        f = new Circulo(s,t);
        f.move(-2,-2);
        assertEquals("(5,00,5,00) 2,00", f.toString());
    }
}