import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        String Trans = sc.nextLine();
        String Col = sc.nextLine();
        GameObjects go = new GameObjects(nome, Trans, Col);
        System.out.println(go);
    }
}
