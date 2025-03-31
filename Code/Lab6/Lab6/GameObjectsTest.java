import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameObjectsTest {

    @Test
    public void testConstrutor() {
        GameObjects gameObj = new GameObjects("Spaceship", "10 20 1 0 1.0", "0 0 5");

        assertEquals("Spaceship", gameObj.name());
        assertEquals(10, gameObj.transform().position().getX());
        assertEquals(20, gameObj.transform().position().getY());
        assertEquals(1, gameObj.transform().layer());
        assertEquals(0.0, gameObj.transform().angle(), 0.001);
        assertEquals(1.0, gameObj.transform().scale(), 0.001);
    }
    @Test
    void updateMove() {
        // Input completo (x, y, layer, angle, scale)
        GameObjects gameObj = new GameObjects("Player", "0 0 0 0 1.0", "0 0 5");
        gameObj.update("move 10 10 5");

        // Verifica posição
        assertEquals(10, gameObj.transform().position().getX());
        assertEquals(10, gameObj.transform().position().getY());

        // Verifica layer
        assertEquals(5, gameObj.transform().layer());

        // Verifica se o collider também foi movido
        assertEquals(10, gameObj.collider().centroid().getX());
        assertEquals(10, gameObj.collider().centroid().getY());
    }

    @Test
    void updateRotate() {
        GameObjects gameObj = new GameObjects("Alien02", "10 10 2 0 1.0", "0 0 2 4 4 4 4 2");
        gameObj.update("rotate 45");

        assertEquals("Alien02", gameObj.name());
        assertEquals(45, gameObj.transform().angle(), 0.001);
        assertNotEquals("0 0 2 4 4 4 4 2", gameObj.collider().toString());
    }

    @Test
    void updateScale() {
        GameObjects gameObj = new GameObjects("ScaledAlien", "5 5 1 0 1.0", "0 0 2 4 4 4 4 2");
        gameObj.update("scale 2.0");
        assertEquals("ScaledAlien", gameObj.name());
        assertEquals(3.0, gameObj.transform().scale(), 0.001);
        assertEquals("(-2,00,-2,00) (4,00,10,00) (10,00,10,00) (10,00,4,00)", gameObj.collider().toString());
    }

    @Test
    void nomeDoObjeto() {
        GameObjects gameObj = new GameObjects("PlayerNoob", "0 0 0 0 1.0", "0 0 5");

        // Verifica nome + outros atributos básicos
        assertEquals("PlayerNoob", gameObj.name());
        assertNotNull(gameObj.transform());
        assertNotNull(gameObj.collider());
    }

    @Test
    void transformDoObjeto() {
        // Adicione o valor da escala (último número). Exemplo: "0 0 0 1 1.0"
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