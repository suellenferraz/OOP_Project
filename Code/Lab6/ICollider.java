public interface ICollider {
    /**
     * @return o centroide do collider
     */
    Ponto centroid();

    /**
     * @param x coodernada x a mover
     * @param y coodernada y a mover
     */
    void move(double x, double y);

    /**
     * @param v angulo a rodar
     */
    void rotate(double v);

    /**
     * @param scale escala a multiplicar
     */
    void scale(double scale);

    /**
     * @param collider Collider a verificar colisão
     * @return true se colide, false caso contrário
     */
    boolean colide(ICollider collider);

    /**
     * @param circulo Circulo a verificar colisão
     * @return true se colide, false caso contrário
     */
    boolean colideComCirculo(Circulo circulo);

    /**
     * @param poligono Poligono a verificar colisão
     * @return true se colide, false caso contrário
     */
    boolean colideComPoligono(Poligono poligono);
}