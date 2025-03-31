/**
 * Classe GameObject gere no fundo, toda a informação para um tipo Segmento
 * @inv Um GameObject deve ter um nome, um transform associado e um collider
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-10/02/2025
 */

public class GameObjects implements IGameObject{
    private String name;
    private ITransform transformer;
    private ICollider collideer;

    /**
     * @param name o nome do GameObject
     * @param transform a informacao de um transform
     * @param collider a informacao de um collider
     */
    GameObjects(String name, String transform, String collider)
    {
        this.name = name;
        this.transformer = new Transform(transform);
        this.collideer = new Collider(this.transformer.position(), collider);
        this.collideer.rotate(this.transformer.angle());
        this.collideer.scale(this.transformer.scale());
    }

    /**
     * @param args os argumentos para as operacoes de update.
     */
    public void update(String args)
    {
        String[] a = args.split(" ", 2);
        if(a[0].equals("move"))
        {
            String[] b = a[1].split(" ");
            this.transformer.move(new Ponto(Double.parseDouble(b[0]), Double.parseDouble(b[1])), Integer.parseInt(b[2]));
            this.collideer.move(new Ponto(Double.parseDouble(b[0]), Double.parseDouble(b[1])));
        }
        else if(a[0].equals("rotate"))
        {
            transformer.rotate(Double.parseDouble(a[1]));
            this.collideer.rotate(Double.parseDouble(a[1]));
        }
        else if(a[0].equals("scale"))
        {
            transformer.scale(Double.parseDouble(a[1]));
            this.collideer.scale(this.transformer.scale());
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
        return transformer;
    }

    /**
     * @return the Collider of the GameObject with its centroid at this.transform().position()
     */
    @Override
    public ICollider collider() {
        return collideer;
    }

    /**
     * @return o GameObject em String
     */
    @Override
    public String toString() {
        return name + "\n" + transformer.toString() + "\n" + collideer.toString();
    }
}