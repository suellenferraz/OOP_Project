/**
 * Classe Segmento gere no fundo, toda a informação para um tipo Segmento
 * @inv Um segmento de reta nao pode ter ponto iguais (o que faz com que nao sejam segmentos de reta)
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-10/02/2025
 */
public class Segmento {
    private Ponto p1, p2;

    /**
     * @param p1 Objeto do tipo Ponto
     * @param p2 Objeto do tipo Ponto
     */
    Segmento(Ponto p1, Ponto p2)
    {
        if(p1.getX() == p2.getX() && p1.getY() == p2.getY())
        {
            throw new IllegalArgumentException("Segmento:vi");
        }

        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * @return O ponto numero 1
     */
    public Ponto getP1()
    {
        return p1;
    }

    /**
     * @return O ponto numero 2
     */
    public Ponto getP2()
    {
        return p2;
    }

    /**
     * @param s2 - objeto do tipo Segmento
     * @return 1 se o segmento intersetar s2, 0 - caso contrário
     */
    public int intersecao(Segmento s2)
    {
        double x1 = this.getP1().getX(), y1 = this.getP1().getY();
        double x2 = this.getP2().getX(), y2 = this.getP2().getY();
        double x3 = s2.getP1().getX(), y3 = s2.getP1().getY();
        double x4 = s2.getP2().getX(), y4 = s2.getP2().getY();

        double denominador = (y4-y3) * (x2-x1) - (x4-x3) * (y2-y1);

        if(denominador < 0)
        {
            return 0;
        }

        double t = ((x4-x3) * (y1-y3) - (y4-y3) * (x1-x3)) / denominador;
        double u = ((x2-x1) * (y1-y3) - (y2-y1) * (x1-x3)) / denominador;

        if (t >= 0 && t <= 1 && u >= 0 && u <= 1)
        {
            return 1;
        }

        return 0;
    }
}
