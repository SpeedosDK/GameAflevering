import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

//        Player player = new Player(1, "bo", 18, 20);

//        Game game = new Game(1, "Cs", "Shooter", 2000);
//        GameSystem gameSystem = new GameSystem(20, 20);
//        gameSystem.addPlayer(player);
//        gameSystem.addPlayer(player2);
//        gameSystem.addGame(game);
//
//        gameSystem.displayAllGames();
//        gameSystem.updatePlayerScore(1, 30);
//
//        System.out.println("Total optjening " + GameSystem.calculateTotalRevenue());
//
//        gameSystem.printTopScoringPlayerName();

          GameSystem.menu(new GameSystem(20, 20));
    }

}