import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        String Trans = sc.nextLine();
        String Col = sc.nextLine();
        String arg = "";

        GameObjects go = new GameObjects(nome, Trans, Col);

        while(sc.hasNextLine())
        {
            arg = sc.nextLine();
            if(arg.isEmpty()) break;
            go.update(arg);
        }

        System.out.println(go);
    }
}
