/**
 * Classe Circulo gere no fundo toda a informacao para um tipo Circulo
 * @inv Um circulo deve pertencer ao 1ºquadrante
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 3-29/03/2025
*/

public class Circulo extends Collider{
    private Ponto p;
    private double raio;

    /**
     * @param s toda a informacao do circulo
     */
    public Circulo(String s, ITransform t)
    {
        String[] all = s.split(" ");
        Ponto p = t.position();
        double raio = Double.parseDouble(all[2]);

        this.p = p;
        this.raio = raio;
        this.centroid = t.position();
    }

    @Override
    public Ponto centroid() {
        return centroid;
    }

    /**
     * @return String de um circulo
     */
    @Override
    public String toString() {
        return String.format("%s %.2f", p.toString(), this.raio);
    }

    /**
     * @param x valor x a mover
     * @param y valor y a mover
     */
    public void move(double x, double y)
    {
        return;
    }

    /**
     * @param angle o angulo a rodar
     */
    public void rotate(double angle) {
        return;
    }

    /**
     * @param scale a escala dada no transform
     */
    public void scale(double scale) {
        raio = raio * scale;
    }

    /**
     * @return centro do circulo
     */
    public Ponto getP()
    {
        return this.p;
    }

    /**
     * @return raio do circulo
     */
    public double raio()
    {
        return this.raio;
    }
}
