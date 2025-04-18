public interface ICollider {
    /**
     * @return o centroide do collider
     */
    Ponto centroid();

    /**
     * @param angle o angulo do transform
     */
    void rotate(double angle);

    /**
     * @param scale a escala do transform
     */
    void scale(double scale);

    /**
     * @param ponto o ponto dPOS para mover
     */
    void move(Ponto ponto);

    /**
     * @return o collider escrito em String
     */
    String toString();
}