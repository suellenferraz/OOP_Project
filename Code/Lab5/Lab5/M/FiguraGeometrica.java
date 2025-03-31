/**
 * Classe FiguraGeometrica gere no fundo toda a informacao para um tipo FiguraGeometrica, ela e a mais 'alta' classe de uma hierarquia
 * @inv uma figura geometrica so pode se identificar com círculo ou poligono.
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-20/03/2025
 */

abstract class FiguraGeometrica {
    public abstract String toString();
    public abstract void move(double dx, double dy);
    public abstract void rotate(double angle, Ponto centroid);
    public abstract void scale(double scale, Ponto centroid);
}