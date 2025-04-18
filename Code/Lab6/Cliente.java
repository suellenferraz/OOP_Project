import java.util.ArrayList;
import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int frames = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        GameEngine game = new GameEngine();


        for(int i = 0; i < n; i++)
        {
            String name = sc.nextLine();
            String Trans = sc.nextLine();
            String Col = sc.nextLine();
            String motion = sc.nextLine();
            IGameObject go = new GameObject(name, Trans, Col, motion);
            game.add(go);
        }

        game.run(frames);

        ArrayList<String> colisoes = game.verificaColis();
        for(String s : colisoes)
        {
            System.out.println(s);
        }

        sc.close();
    }
}
