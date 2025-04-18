/**
 * Classe Ponto gere no fundo, toda a informação para um tipo Ponto
 * @inv Um ponto deve pertencer ao 1 quadrante
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 6-29/03/2025
 */
public class Ponto
{
    private double x, y;
    /**
     * @param x numero inteiro positivo
     * @param y numero inteiro positivo
     */
    public Ponto(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return a coordenada X no ponto
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * @return a coordenada Y no ponto
     */
    public double getY()
    {
        return this.y;
    }


    /**
     * @return o ponto escrito para string.
     */
    @Override
    public String toString()
    {
        return String.format("(%.2f,%.2f)", this.x, this.y);
    }

    /**
     * @param  Q ponto q
     * @param R ponto r
     * @return true se o ponto e colinear, false caso contrario.
     */
    public boolean isCollinear(Ponto Q, Ponto R) {
        return (Q.getX() - x) * (R.getY() - y) == (R.getX() - x) * (Q.getY() - y);
    }

    /**
     * @param x coordenada de transformaçao x
     * @param y coordenada de transformaçao y
     */
    public void move(double x, double y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
}