/**
 * Classe GameObject gere no fundo, toda a informação para um tipo Segmento
 * @inv Um GameObject deve ter um nome, um transform associado e um collider
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-10/02/2025
 */

public class GameObject implements IGameObject{
    private String name;
    private ITransform transform;
    private ICollider collider;

    /**
     * @param name o nome do GameObject
     * @param transform a informacao de um transform
     * @param collider a informacao de um collider
     */
    GameObject(String name, String transform, String collider)
    {
        this.name = name;
        this.transform = new Transform(transform);

        String[] pt = collider.split(" ");

        if(pt.length == 3)
        {
            this.collider = new Circulo(collider, this.transform);
        }
        else
        {
            this.collider = new Poligono(collider, this.transform);
            this.collider.scale(this.transform.scale());
        }
    }

    /**
     * @return the name of the GameObject
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * @return the Transform of the GameObject
     */
    @Override
    public ITransform transform() {
        return transform;
    }

    /**
     * @return the Collider of the GameObject with its centroid at this.transform().position()
     */
    @Override
    public ICollider collider() {
        return collider;
    }

    /**
     * @return o GameObject em String
     */
    @Override
    public String toString() {
        return name + "\n" + transform.toString() + "\n" + collider.toString();
    }
}