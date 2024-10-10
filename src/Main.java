import java.util.Scanner;

public class Main
{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
          GameSystem gameSystem = new GameSystem(20, 20);
          menu(gameSystem);
    }
    public static void menu(GameSystem gameSystem)
    {
        boolean chosen = false;

        while (!chosen) {
            System.out.println("Vælg valgmuligheder");
            System.out.println("1. Tilføj et spil");
            System.out.println("2. Tilføj en spiller");
            System.out.println("3. Vis alle spil");
            System.out.println("4. Vis alle spillere");
            System.out.println("5. Find et spil ved at søge på gameID");
            System.out.println("6. Find en spiller ved at søge på playerID");
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
                    scanner.nextLine();
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
                    scanner.nextLine();
                    break;
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
                    scanner.nextLine();
                    break;
                case "6":
                    if (GameSystem.playerCount == 0)
                    {
                        System.out.println("Der findes ingen spillere");
                    } else {
                        System.out.println("Skriv spiller ID");
                        int playerId2 = scanner.nextInt();
                        Player player = gameSystem.findPlayerById(playerId2);
                        scanner.nextLine();
                        if (player != null)
                        {
                            System.out.println("Du har valgt spilleren " + player.getPlayerName() + ".");
                            System.out.println("1. Vil du se spillerens detaljer?");
                            System.out.println("2. Gå tilbage til hovedmenuen");
                            boolean repeat2 = true;
                            while(repeat2)
                            {
                                String choice2 = scanner.nextLine();
                                switch (choice2)
                                {
                                    case "1":
                                        player.displayDetails();
                                        break;
                                    case "2":
                                        System.out.println("Gå tilbage til hovedmenuen");
                                        repeat2 = false;
                                        break;
                                    default:
                                        System.out.println("Ugyldigt valg prøv igen");
                                }

                            }
                        }
                    }
                    break;
                case "7":
                    System.out.println("Indtast spiller ID");
                    int playerId3 = scanner.nextInt();
                    System.out.println("Indtast score");
                    double newScore = scanner.nextDouble();
                    gameSystem.updatePlayerScore(playerId3, newScore);
                    scanner.nextLine();
                    break;
                case "8":
                    System.out.println("Total indtjening: " + GameSystem.calculateTotalRevenue());
                    break;
                case "9":
                    GameSystem.findTopScoringPlayer();
                    break;
                case "10":
                    System.out.println("Programmet afsluttes");
                    chosen = true;
                    break;
                default:
                    System.out.println("Forkert input prøv igen");


            }

        }
    }

}