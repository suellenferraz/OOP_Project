import java.util.ArrayList;

/**
 * Classe Poligono gere no fundo, toda a informacao para um tipo Poligono (herda toda a informacao de uma figura geometrica
 * @inv Um poligono nao pode ter menos de 3 vertices, nenhum dos lados pode interseta com outro e ainda 3 pontos nao podem ser colineares
 * @author LUIS MOREIRA-81432, RODRIGO DAMÁSIO-85500, SUELLEN FERRAZ-90981
 * @version 2-29/03/2025
 */

class Poligono extends Collider{
    /**
     * @param s a informacao de um Poligono
     */

    public Poligono(String s, ITransform t)
    {
        this.centroid = t.position();
        String[] all = s.split(" ");
        ArrayList<Ponto> al = new ArrayList<Ponto>();
        if(all.length < 6) throw new IllegalArgumentException("Poligono:vi");

        for(int i = 0; i < all.length; i+=2)
            al.add(new Ponto(Double.parseDouble(all[i]), Double.parseDouble(all[i+1])));


        for(int i = 0; i < al.size(); i++)
        {
            Segmento s1 = new Segmento(al.get(i), al.get((i+1)%al.size()));
            for(int j = i + 1; j < al.size(); j++)
            {
                if(j == i || j == ((i+1)%al.size())) continue;
                if(((j+1)%al.size()) == i) continue;

                Segmento s2 = new Segmento(al.get(j), al.get((j+1)%al.size()));

                if(s1.intersecao(s2) == 1)
                {
                    throw new IllegalArgumentException("Poligono:vi");
                }
            }
        }

        Ponto a = al.getFirst();
        Ponto b = al.get((1)%all.length);
        Ponto c = al.get((2)%all.length);

        if(a.isCollinear(b, c))
        {
            throw new IllegalArgumentException("Poligono:vi");
        }

        this.pontos = al;
        this.newCentroid(this.centroid);
        this.rotate(t.angle());
        this.scale(t.scale());
    }

    @Override
    public Ponto centroid() {
        return centroid;
    }

    /**
     * @return O poligono e os seus pontos
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (Ponto p : pontos)
        {
            s.append(p.toString()).append(" ");
        }

        return s.toString().trim();
    }

    /**
     * @param x coordenada x a transladar
     * @param y coordenada y a transladar
     */
    public void move(double x, double y)
    {
        for(Ponto pt : pontos) pt.move(x,y);
    }

    /**
     * @param angle o angulo a rodar
     */
    public void rotate(double angle)
    {
        for(Ponto p : pontos)
        {
            p.rotate(centroid, angle);
        }
    }

    /**
     * @return o centro do poligono inicial
     */
    public Ponto centro()
    {
        double soma = 0;
        double somaX = 0;
        double somaY = 0;
        int n = this.pontos.size();

        for (int i = 0; i < n-1; i++) {
            double xi = this.pontos.get(i).getX();
            double yi = this.pontos.get(i).getY();
            double xj = this.pontos.get(i+1).getX();
            double yj = this.pontos.get(i+1).getY();

            double cross = xi * yj - xj * yi;
            soma += cross;
            somaX += (xi + xj) * cross;
            somaY += (yi + yj) * cross;
        }

        double xLast = this.pontos.get(n-1).getX();
        double yLast = this.pontos.get(n-1).getY();
        double x0 = this.pontos.get(0).getX();
        double y0 = this.pontos.get(0).getY();

        double crossLast = xLast * y0 - x0 * yLast;
        soma += crossLast;
        somaX += (x0 + xLast) * crossLast;
        somaY += (y0 + yLast) * crossLast;

        double A = soma / 2.0;
        double fator = 1.0 / (6.0 * A);

        double cx = fator * somaX;
        double cy = fator * somaY;

        return new Ponto(cx, cy);
    }

    /**
     * @param novoCentro o centroid dado em collider
     * @return o poligono centrado no novocentroid
     */
    public void newCentroid(Ponto novoCentro)
    {
        Ponto centroAtual = this.centro();
        double deltaX = novoCentro.getX() - centroAtual.getX();
        double deltaY = novoCentro.getY() - centroAtual.getY();

        for(Ponto p : pontos)
        {
            p.move(deltaX, deltaY);
        }

        this.centroid = novoCentro;
    }


    /**
     * @param scale o valor de escala atual do transform
     */
    public void scale(double scale) {

        for (Ponto p : pontos)
        {
            p.scale(centroid, scale);
        }
    }
}
