import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        String Trans = sc.nextLine();
        String Col = sc.nextLine();
        GameObject go = new GameObject(nome, Trans, Col);
        String arg = "";

        while(sc.hasNextLine())
        {
            arg = sc.nextLine();
            if(arg.isEmpty()) break;
            String[] argi = arg.split(" ", 2);

            if(argi[0].equals("move"))
            {
                String[] b = argi[1].split(" ");
                go.transform().move(new Ponto(Double.parseDouble(b[0]), Double.parseDouble(b[1])), Integer.parseInt(b[2]));
                go.collider().move(Double.parseDouble(b[0]), Double.parseDouble(b[1]));
            }
            else if(argi[0].equals("rotate"))
            {
                go.transform().rotate(Double.parseDouble(argi[1]));
                go.collider().rotate(Double.parseDouble(argi[1]));
            }
            else if(argi[0].equals("scale"))
            {
                go.transform().scale(Double.parseDouble(argi[1]));
                go.collider().scale(go.transform().scale());
            }
        }

        System.out.println(go);
    }
}
