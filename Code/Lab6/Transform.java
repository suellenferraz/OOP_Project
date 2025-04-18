/**
 * Classe Transform gere no fundo, toda a informação para um tipo Transform
 * @inv nao tem.
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 1-29/03/2025
 */

 public class Transform implements ITransform {
    private Ponto p1;
    private int layer;
    private double angle, scale;

    /**
     * @param s a informacao de um transform
     */
    public Transform(String s)
    {
        String[] split = s.split(" ");
        p1 = new Ponto(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        layer = Integer.parseInt(split[2]);
        angle = Double.parseDouble(split[3]);
        scale = Double.parseDouble(split[4]);
    }

    /**
     * Move this ITransform by dPos.x(), dPos.y() and dlayer
     * @param dPos     the 2D differential to move
     * @param dlayer  the layer differential
     */
    @Override
    public void move(Ponto dPos, int dlayer) {
        p1.move(dPos.getX(), dPos.getY());
        this.layer += dlayer;
    }

    /**
     * Rotate this ITransform from current orientation by dTheta
     * @param dTheta
     * pos: 0 <= this.angle() < 360
     */
    @Override
    public void rotate(double dTheta) {
        this.angle += dTheta;
    }

    /**
     * increment the ITransform scale by dscale
     * @param dScale the scale increment
     */
    @Override
    public void scale(double dScale) {
        this.scale += dScale;
    }

    /**
     * @return the (x,y) coordinates
     */
    @Override
    public Ponto position() {
        return this.p1;
    }

    /**
     * @return the layer
     */
    @Override
    public int layer() {
        return this.layer;
    }

    /**
     * @return the angle in degrees
     */
    @Override
    public double angle() {
        return this.angle;
    }

    /**
     * @return the current scale factor
     */
    @Override
    public double scale() {
        return this.scale;
    }

    /**
     * @return o transform em string
     */
    public String toString()
    {
        return String.format("%s %d %.2f %.2f", p1.toString(), layer, angle, scale);
    }
}
