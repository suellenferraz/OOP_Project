/**
 * Classe Collider gere no fundo, toda a informação para um tipo Collider
 * @inv um colider deve ser estar centrado no centroid dado
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-29/03/2025
 */

public class Collider implements ICollider {
    FiguraGeometrica fg;
    private Ponto centroid;

    /**
     * @param centroid O centroid do GameObjects
     * @param s os pontos do centroid
     */
    public Collider(Ponto centroid, String s) {
        String[] split = s.split(" ");

        this.centroid = centroid;
        if (split.length == 3) {
            String fin = centroid.getX() + " " + centroid.getY() + " " + (Integer.parseInt(split[2]));
            fg = new Circulo(fin);
        } else if (split.length > 6) {
            this.fg = (new Poligono(s)).newCentroid(this.centroid);
        } else {
            throw new IllegalArgumentException("Collider:vi");
        }
    }


    /**
     * @return o centroide do collider
     */
    @Override
    public Ponto centroid() {
        return this.centroid;
    }

    /**
     * @return o collider escrito em String
     */
    @Override
    public String toString() {
        return fg.toString();
    }

    /**
     * @param dPos o ponto dPOS para mover
     */
    public void move(Ponto dPos) {
        fg.move(dPos.getX(), dPos.getY());
    }

    /**
     * @param angle o angulo do transform
     */
    public void rotate(double angle) {
        fg.rotate(angle, centroid);
    }

    /**
     * @param scale a escala do transform
     */
    public void scale(double scale) {
        fg.scale(scale, centroid);
    }
}
