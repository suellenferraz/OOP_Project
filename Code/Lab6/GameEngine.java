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
        gameObjects = new ArrayList<IGameObject>();
    }

    /**
     * @param gOb o GameObject a adicionar
     */
    public void add(IGameObject gOb)
    {
        gameObjects.add(gOb);
    }

    /**
     * @param gOb o GameObject a eliminar
     */
    public void destroy(IGameObject gOb)
    {
        gameObjects.remove(gOb);
    }

    /**
     * @return os GameObjects que colidem com outros GameObjects
     */
    public ArrayList<String> verificaColis()
    {
        ArrayList<String> coliArr = new ArrayList<>();
        int n = gameObjects.size();

        for(int i = 0; i < gameObjects.size(); i++)
        {
            StringBuilder colis = new StringBuilder();
            colis.append(gameObjects.get(i).name());
            for(int j = 0; j < n; j++)
            {
                if(i == j) continue;

                if(gameObjects.get(i).transform().layer() == gameObjects.get(j).transform().layer())
                {
                    if(gameObjects.get(i).collider().colide(gameObjects.get(j).collider()))
                    {
                        colis.append(" ").append(gameObjects.get(j).name());
                    }
                }
            }

            if(!colis.toString().equals(gameObjects.get(i).name()))
            {
                coliArr.add(colis.toString().trim());
            }
        }

        return coliArr;
    }

    /**
     * @param frames os frames a implementar
     */
    public void run(int frames)
    {
        for(int f = 0; f < frames; f++)
        {
            for(IGameObject go : gameObjects)
            {
                GameObject gob = (GameObject) go;
                go.transform().move(new Ponto(gob.getVelX(), gob.getVelY()), gob.getdLayer());
                go.transform().rotate(gob.getdTheta());
                go.transform().scale(gob.getdScale());

                go.collider().move(gob.getVelX(), gob.getVelY());
                go.collider().rotate(gob.getdTheta());
                go.collider().scale(go.transform().scale());
            }
        }
    }
}