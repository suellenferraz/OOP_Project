import java.util.ArrayList;

/**
 * Classe GameEngine toda a informação de um GameEngine
 * @inv Um GameObject deve conter uma lista de GameObjects
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-30/03/2025
 */

public class GameEngine {
    private ArrayList<IGameObject> gameObjects;

    public GameEngine()
    {
        gameObjects = new ArrayList<>();
    }

    public void add(GameObjects gOb)
    {
        gameObjects.add(gOb);
    }

    public void destroy(GameObjects gOb)
    {
        gameObjects.remove(gOb);
    }
}