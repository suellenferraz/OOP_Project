public interface ICollider {
    /**
     * @return o centroide do collider
     */
    Ponto centroid();

    void move(double x, double y);
    void rotate(double v);
    void scale(double scale);
}