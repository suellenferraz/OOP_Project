import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    @Test
    public void testConstrutor() {
        GameObject gameObj = new GameObject("Spaceship", "10 20 1 0 1.0", "0 0 5");

        assertEquals("Spaceship", gameObj.name());
        assertEquals(10, gameObj.transform().position().getX());
        assertEquals(20, gameObj.transform().position().getY());
        assertEquals(1, gameObj.transform().layer());
        assertEquals(0.0, gameObj.transform().angle(), 0.001);
        assertEquals(1.0, gameObj.transform().scale(), 0.001);
    }
    
    @Test
    public void testNameMethod() {
        GameObject obj = new GameObject("Player01", "0 0 0 0 1.0", "0 0 1.0"); // Removido "circulo"
        assertEquals("Player01", obj.name());
    }

    @Test
    public void testTransformMethod() {
        GameObject obj = new GameObject("Asteroid", "1.5 2.5 3 90.0 0.5", "1.5 2.5 1.0"); // Removido "circulo"
        ITransform transform = obj.transform();

        assertEquals(1.5, transform.position().getX(), 0.001);
        assertEquals(2.5, transform.position().getY(), 0.001);
        assertEquals(3, transform.layer());
        assertEquals(90.0, transform.angle(), 0.001);
        assertEquals(0.5, transform.scale(), 0.001);
    }

    @Test
    public void testColliderMethod() {
        GameObject obj = new GameObject("Test", "3.0 4.0 0 0 1.0", "3.0 4.0 2.0"); // Removido "circulo"
        ICollider collider = obj.collider();

        assertEquals(3.0, collider.centroid().getX(), 0.001);
        assertEquals(4.0, collider.centroid().getY(), 0.001);
    }

    @Test
    public void testToStringMethod() {
        GameObject obj = new GameObject("Obstacle", "5.0 5.0 1 0 1.0", "5.0 5.0 3.0"); // Removido "circulo"
        String str = obj.toString();

        // Verifica se contém as informações essenciais
        assertTrue(str.contains("Obstacle"));
        assertTrue(str.contains("5,00"));
        // Como removemos "circulo" da string, não podemos mais verificar isso
        // Mas podemos verificar o raio se o toString do collider incluir essa informação
        assertTrue(str.contains("3,00"));

        // Verifica o formato com quebras de linha
        String[] lines = str.split("\n");
        assertEquals(3, lines.length);
        assertEquals("Obstacle", lines[0]);
    }

    @Test
    public void testColliderMatchesTransformPosition() {
        // Testa a invariante de que o collider está centrado na posição do transform
        GameObject obj = new GameObject("Test", "2.0 3.0 0 0 1.0",
                "3 1.0 1.0 3.0 1.0 2.0"); // Removido "poligono"

        Ponto transformPos = obj.transform().position();
        Ponto colliderCentroid = obj.collider().centroid();

        assertEquals(transformPos.getX(), colliderCentroid.getX(), 0.001);
        assertEquals(transformPos.getY(), colliderCentroid.getY(), 0.001);
    }

    @Test
    public void testGameObjectMovement() {
        GameObject obj = new GameObject("Movable", "1.0 2.0 0 0 1.0", "1.0 2.0 1.0"); // Removido "circulo"

        // Posição inicial
        assertEquals(1.0, obj.transform().position().getX(), 0.001);
        assertEquals(2.0, obj.transform().position().getY(), 0.001);

        // Move o objeto através do collider
        obj.collider().move(1.5, -0.5);

        // Verifica nova posição
        assertEquals(2.5, obj.transform().position().getX(), 0.001);
        assertEquals(1.5, obj.transform().position().getY(), 0.001);

        // Verifica que o collider também foi movido
        assertEquals(2.5, obj.collider().centroid().getX(), 0.001);
        assertEquals(1.5, obj.collider().centroid().getY(), 0.001);
    }

}