import java.util.ArrayList;

/**
 * Classe Collider gere no fundo, toda a informação para um tipo Collider
 * @inv um colider deve ser estar centrado no centroid dado
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-29/03/2025
 */

abstract class Collider implements ICollider {
    Ponto centroid;
    ArrayList<Ponto> pontos;

    /**
     * @return o centroide do collider
     */
    public abstract Ponto centroid();

    /**
     * @return o collider escrito em String
     */
    public abstract String toString();

    /**
     * @param x ponto x a mover
     * @param y ponto y a mover
     */
    public abstract void move(double x, double y);

    /**
     * @param angle o angulo do transform
     */
    public abstract void rotate(double angle);

    /**
     * @param scale a escala do transform
     */
    public abstract void scale(double scale);

    /**
     * @param p Poligono a verificar a colisão
     * @return true se colide, false caso contrário
     */
    public abstract boolean colideComPoligono(Poligono p);

    /**
     * @param c Circulo a verificar a colisão
     * @return true se colide, false caso contrário
     */
    public abstract boolean colideComCirculo(Circulo c);
}
