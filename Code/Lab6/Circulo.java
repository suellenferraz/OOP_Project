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

    /**
     * @return o centroid do Circulo
     */
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
        if(scale == 0) return;
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

    /**
     * @param other Collider a verificar a colisão
     * @return true se colide, false caso contrário
     */
    @Override
    public boolean colide(ICollider other) {
        return other.colideComCirculo(this);
    }

    /**
     * @param p Poligono a verificar a colisão
     * @return true se colide, false caso contrário
     */
    @Override
    public boolean colideComPoligono(Poligono p) {
        return p.colideComCirculo(this); // delega para o Poligono, ou implemente diretamente se preferir
    }

    /**
     * @param c Circulo a verificar a colisão
     * @return true se colide, false caso contrário
     */
    @Override
    public boolean colideComCirculo(Circulo c) {
        return this.intersetaCIR(c); // usa a lógica já existente
    }

    /**
     * @param c2 o circulo a verificar
     */
    public boolean intersetaCIR(Circulo c2)
    {
        double dx = this.p.getX() - c2.p.getX();
        double dy = this.p.getY() - c2.p.getY();
        double dist = Math.sqrt((dx*dx) + (dy*dy));
        return dist <= (this.raio + c2.raio);
    }

}
