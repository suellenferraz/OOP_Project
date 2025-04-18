import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GameEngineTest {

    // Teste para adição de GameObject
    @Test
    public void testAddGameObject() {
        GameEngine engine = new GameEngine();
        GameObject obj = new GameObject("Player01", "0 0 0 0 1.0", "0 0 5", "0 0 0 0 0");

        engine.add(obj);
        ArrayList<String> collisions = engine.verificaColis();

        // Verifica se o objeto foi adicionado (nenhuma colisão esperada)
        assertTrue(collisions.isEmpty());
    }

    // Teste para a remoção de GameObject
    @Test
    public void testDestroyGameObject() {
        GameEngine engine = new GameEngine();
        GameObject obj = new GameObject("Enemy", "10 10 0 0 1.0", "10 10 3", "0 0 0 0 0");

        engine.add(obj);
        engine.destroy(obj);
        ArrayList<String> collisions = engine.verificaColis();

        // Verifica se o objeto foi removido (lista de colisões vazia)
        assertTrue(collisions.isEmpty());
    }

    // Teste para detectar de colisões
    @Test
    public void testCollisionDetection() {
        GameEngine engine = new GameEngine();

        // Dois objetos no mesmo layer e posição (devem colidir)
        GameObject obj1 = new GameObject("Asteroid01", "5 5 1 0 1.0", "5 5 2", "0 0 0 0 0");
        GameObject obj2 = new GameObject("Cometa02", "5 5 1 0 1.0", "5 5 2", "0 0 0 0 0");

        engine.add(obj1);
        engine.add(obj2);

        ArrayList<String> collisions = engine.verificaColis();

        // Verifica se a colisão foi detectada
        assertEquals(2, collisions.size());
        assertTrue(collisions.get(0).contains("Asteroid01 Cometa02") || collisions.get(1).contains("Asteroid01 Cometa02"));
    }

    // Teste para objetos em layers diferentes (não devem colidir)
    @Test
    public void testNoCollisionDifferentLayers() {
        GameEngine engine = new GameEngine();

        // Objetos em layers diferentes (não devem colidir)
        GameObject obj1 = new GameObject("FriendlySpacehsip01", "5 5 1 0 1.0", "5 5 2", "0 0 0 0 0");
        GameObject obj2 = new GameObject("FriendlySpaceship02", "5 5 2 0 1.0", "5 5 2", "0 0 0 0 0");

        engine.add(obj1);
        engine.add(obj2);

        ArrayList<String> collisions = engine.verificaColis();

        // Verifica que não há colisões
        assertTrue(collisions.isEmpty());
    }

    // Teste para simulação de movimento (run)
    @Test
    public void testRunSimulation() {
        GameEngine engine = new GameEngine();

        // Objeto com velocidade (1, 0) e rotação de 10 graus por frame
        GameObject obj = new GameObject("Spaceship", "0 0 0 0 1.0", "0 0 5", "1 0 0 10 0");

        engine.add(obj);
        engine.run(2); // Simula 2 frames

        // Verifica a posição após 2 frames (x = 2, y = 0)
        assertEquals(2.0, obj.transform().position().getX(), 0.001);
        assertEquals(0.0, obj.transform().position().getY(), 0.001);

        // Verifica a rotação após 2 frames (20 graus)
        assertEquals(20.0, obj.transform().angle(), 0.001);
    }
}