/**
 * Classe Circulo gere no fundo toda a informacao para um tipo Circulo
 * @inv Um circulo deve pertencer ao 1ºquadrante
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 3-29/03/2025
*/

public class Circulo extends FiguraGeometrica{
    private Ponto p;
    private double raio;

    /**
     * @param s toda a informacao do circulo
     */
    public Circulo(String s)
    {
        String[] all = s.split(" ");
        Ponto p = new Ponto(Double.parseDouble(all[0]), Double.parseDouble(all[1]));
        double raio = Double.parseDouble(all[2]);

        this.p = p;
        this.raio = raio;
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
        this.p.move(x,y);
    }

    /**
     * @param angle o angulo a rodar
     * @param centroid o centroid dado no Collider
     */
    public void rotate(double angle, Ponto centroid) {
        return;
    }

    /**
     * @param scale a escala dada no transform
     * @param centroid o centroid dado no collider
     */
    public void scale(double scale, Ponto centroid) {
        raio = raio * scale;
    }
}
