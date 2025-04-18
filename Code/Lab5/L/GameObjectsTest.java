import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameObjectsTest {

    @Test
    public void testConstrutor() {
        // Teste de criação básica com colisor circular
        GameObjects gameObj = new GameObjects("Spaceship", "10 20 1 0 1.0", "0 0 5");

        assertEquals("Spaceship", gameObj.name());
        assertEquals(10, gameObj.transform().position().getX());
        assertEquals(20, gameObj.transform().position().getY());
        assertEquals(1, gameObj.transform().layer());
        assertEquals(0.0, gameObj.transform().angle(), 0.001);
        assertEquals(1.0, gameObj.transform().scale(), 0.001);
    }

    @Test
    void nomeDoObjeto() {
        GameObjects gameObj = new GameObjects("PlayerNoob", "0 0 0 0 1", "0 0 5");

        // Verifica nome + outros atributos básicos
        assertEquals("PlayerNoob", gameObj.name());
        assertNotNull(gameObj.transform());
        assertNotNull(gameObj.collider());
    }

    @Test
    void transformDoObjeto() {
        GameObjects gameObj = new GameObjects("Player04", "0 0 0 1 1.0", "0 0 5");
        assertNotNull(gameObj.transform());
    }

    @Test
    void colliderDoObjeto() {
        GameObjects gameObj = new GameObjects("Player", "0 0 0 0 1", "0 0 5");
        assertNotNull(gameObj.collider());
    }

    @Test
    void toStringDoObjeto() {
        GameObjects gameObj = new GameObjects("Player", "0 0 0 1 1", "0 0 5");
        String expected = "Player\n(0,00,0,00) 0 1,00 1,00\n(0,00,0,00) 5,00";
        assertEquals(expected, gameObj.toString());
    }
}