import java.util.Scanner;

public class GameSystem
{
    public static Game[] games;
    public static Player[] players;
    private static int gameCount;
    private static int playerCount;
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

            games[gameCount] = game;
            gameCount++;

    }
    public void addPlayer(Player player)
    {
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
    public  static Game findGameById(int gameId)
    {
        for (int i = 0; i < gameCount; i++)
        {
            games[i] = games[gameId];
        }
        return games[0];
    }
    public Player findPlayerById(int playerId)
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
            }
        }
        return topScoringPlayer;

    }
    public static void printTopScoringPlayerName()
    {
        Player topScoringPlayer = findTopScoringPlayer();
        if (topScoringPlayer != null)
        {
            System.out.println("TopScorer er: " + topScoringPlayer.getPlayerName());

        }
        else
        {
            System.out.println("Ingen spillere fundet");
        }
    }

    public static void menu(GameSystem gameSystem)
    {
        boolean chosen = false;

        do {
            System.out.println("Vælg valgmuligheder");
            System.out.println("1. Tilføj et spil");
            System.out.println("2. Tilføj en spiller");
            System.out.println("3. Vis alle spil");
            System.out.println("4. Vis alle spillere");
            System.out.println("5. Find et spil ved at søge på gameID");
            System.out.println("6. Fid en spiller ved at søge på playerID");
            System.out.println("7. Opdater en spiller score");
            System.out.println("8. Udregn den samlede indtjening på spillene");
            System.out.println("9. Find spilleren med den højeste score");
            System.out.println("10. Afslut programmet");

            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    System.out.println("Indtast spil ID");
                    int gameId = scanner.nextInt();
                    System.out.println("Indtast titel");
                    String gameTitle = scanner.next();
                    System.out.println("Indtast genren");
                    String gameGenre = scanner.next();
                    System.out.println("Indtast pris");
                    double gamePrice = scanner.nextDouble();
                    Game newGame = new Game(gameId, gameTitle, gameGenre, gamePrice);
                    gameSystem.addGame(newGame);
                    break;
                case "2":
                    System.out.println("indtast spiller ID");
                    int playerId = scanner.nextInt();
                    System.out.println("Indtast navn");
                    String playerName = scanner.next();
                    System.out.println("Indtast alder");
                    int playerAge = scanner.nextInt();
                    System.out.println("Indtast score");
                    double playerScore = scanner.nextDouble();
                    Player newPlayer = new Player(playerId, playerName, playerAge, playerScore);
                    gameSystem.addPlayer(newPlayer);
                case "3":
                    gameSystem.displayAllGames();
                    break;
                case "4":
                    gameSystem.displayAllPlayers();
                    break;
                case "5":
                    System.out.println("Indtast spil ID");
                    int gameId2 = scanner.nextInt();
                    Game foundGame = gameSystem.findGameById(gameId2);
                    System.out.println("Du var valgt spillet" + foundGame.getTitle());
                    foundGame.displayDetails();
                    break;
                case "6":
                    if (gameSystem.playerCount == 0)
                    {
                        System.out.println("Der findes ingen spillere");
                    } else {
                        System.out.println("Skriv spiller ID");
                        int playerId2 = scanner.nextInt();
                        Player player = gameSystem.findPlayerById(playerId2);
                        System.out.println("Du har valgt spilleren " + player.getPlayerName() + ".");
                        break;
                    }
                case "7":
                    System.out.println("Indtast spiller ID");
                    int playerId3 = scanner.nextInt();
                    System.out.println("Indtast score");
                    double newScore = scanner.nextDouble();
                    gameSystem.updatePlayerScore(playerId3, newScore);
                    break;
                case "8":
                    gameSystem.calculateTotalRevenue();
                    break;
                case "9":
                    gameSystem.printTopScoringPlayerName();
                    break;
                case "10":
                    System.out.println("Programmet afsluttes");
                    chosen = true;
                default:
                    System.out.println("Forkert input prøv igen");


            }
        }while (!chosen);
    }

}

