import java.util.Scanner;

public class GameSystem
{
    public static Game[] games;
    public static Player[] players;
    public static int gameCount;
    public static int playerCount;
    public static double totalRevenue;
    public static double topScore =Double.MIN_VALUE;
    public static final Scanner scanner = new Scanner(System.in);

    public GameSystem(int maxGames, int maxPlayers)
    {
        games = new Game[maxGames];
        players = new Player[maxPlayers];

    }

    public void addGame(Game game)
    {
        //Tilføjer spil til array
        games[gameCount] = game;
        gameCount++;

    }
    public void addPlayer(Player player)
    {
        //Tilføjer spiller til array
        players[playerCount] = player;
        playerCount++;

    }
    public void displayAllGames()
    {
        for (int i = 0; i < gameCount; i++)
        {
            games[i].displayDetails();
        }
    }
    public void displayAllPlayers()
    {
        for (int i = 0; i < playerCount; i++)
        {
            players[i].displayDetails();
        }
    }

    public void updatePlayerScore(int playerId, double newScore)
    {
        for (int i = 0; i < playerCount; i++)
        {
            if (playerId == players[i].getPlayerID())
            {
                players[i].updateScore(newScore);
                System.out.println("Spiller id " + playerId + " nye score er: " + players[i].getScore());
            }
        }
    }
    public static Game findGameById(int gameId)
    {
        for (int i = 0; i < gameCount; i++)
        {
           if (games[i].getGameId() == gameId) {
               return games[i];
           }
        }
        return null;
    }
    public static Player findPlayerById(int playerId)
    {


            for (int i = 0; i < playerCount; i++) {
                if (players[i].getPlayerID() == playerId) {
                    return players[i];
                } else {
                    System.out.println("Der findes ikke en spiller med det ID");
                }
            }
        return null;

    }

    public static double calculateTotalRevenue()
    {
        for (int i = 0; i < gameCount; i++)
        {
            totalRevenue +=(games[i].getPrice() * playerCount);
        }
        return totalRevenue;
    }
    public static Player findTopScoringPlayer()
    {
        Player topScoringPlayer = null;
        for (int i = 0; i < playerCount; i++)
        {
            if (players[i].getScore() > topScore)
            {
                topScore = players[i].getScore();
                topScoringPlayer = players[i];
                System.out.println("Spiller med højeste score: " + topScoringPlayer.getPlayerName());
            }
        }
        return topScoringPlayer;
    }

}

