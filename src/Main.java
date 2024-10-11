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
                        //Her opretter man et spil
                        boolean gameExists;
                        int gameId;
                        //Tjekker om game id allerede findes og hvis det gør looper den tilbage og spørger igen om game id
                        do{
                            gameExists = false;
                        System.out.println("Indtast spil ID");
                            gameId = scanner.nextInt();
                        for (int i = 0; i < GameSystem.gameCount; i++) {
                            if (GameSystem.games[i].getGameId() == gameId) {
                                System.out.println("Det spil id findes allerede");
                                gameExists = true;
                                break;
                            }
                        }
                        }while(gameExists);

                        System.out.println("Indtast titel");
                        String gameTitle = scanner.next();
                        System.out.println("Indtast genren");
                        String gameGenre = scanner.next();
                        System.out.println("Indtast pris");
                        double gamePrice = scanner.nextDouble();
                        Game newGame = new Game(gameId, gameTitle, gameGenre, gamePrice);
                        gameSystem.addGame(newGame);
                        System.out.println("____________________");
                        newGame.displayDetails();
                        System.out.println("____________________");
                        scanner.nextLine();
                        break;

                case "2":
                    //Her opretter man en spiller
                    boolean playerExists;
                    int playerId;
                    //Tjekker om spiller id allerede findes, hvis det gør, så looper den tilbage igen og spørger om spiller id
                    do {
                        System.out.println("Indtast spiller ID");
                        playerId = scanner.nextInt();
                        playerExists = false;
                        for (int i = 0; i < GameSystem.playerCount; i++) {
                            if (GameSystem.players[i].getPlayerID() == playerId) {
                                System.out.println("Det spiller id findes allerede");
                                playerExists = true;
                            }
                        }
                    }while(playerExists);

                    System.out.println("Indtast navn");
                    String playerName = scanner.next();
                    System.out.println("Indtast alder");
                    int playerAge = scanner.nextInt();
                    System.out.println("Indtast score");
                    double playerScore = scanner.nextDouble();
                    Player newPlayer = new Player(playerId, playerName, playerAge, playerScore);
                    gameSystem.addPlayer(newPlayer);
                    System.out.println("____________________");
                    newPlayer.displayDetails();
                    System.out.println("____________________");
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("____________________");
                    gameSystem.displayAllGames();
                    System.out.println("____________________");
                    break;
                case "4":
                    System.out.println("____________________");
                    gameSystem.displayAllPlayers();
                    System.out.println("____________________");
                    break;
                case "5":
                    if (GameSystem.gameCount == 0)
                    {
                        System.out.println("_____________________");
                        System.out.println("Der findes ingen spil");
                        System.out.println("_____________________");
                    }
                    else {
                        System.out.println("Indtast spil ID");
                        int gameId2 = scanner.nextInt();
                        Game foundGame = gameSystem.findGameById(gameId2);
                        System.out.println("Du var valgt spillet" + foundGame.getTitle());
                        System.out.println("____________________");
                        foundGame.displayDetails();
                        System.out.println("____________________");
                        scanner.nextLine();
                    }
                    break;
                case "6":
                    if (GameSystem.playerCount == 0)
                    {
                        System.out.println("____________________");
                        System.out.println("Der findes ingen spillere");
                        System.out.println("____________________");
                    } else {
                        System.out.println("Skriv spiller ID");
                        int playerId2 = scanner.nextInt();
                        Player player = gameSystem.findPlayerById(playerId2);
                        scanner.nextLine();
                        if (player != null)
                        {
                            System.out.println("____________________");
                            System.out.println("Du har valgt spilleren " + player.getPlayerName() + ".");
                            System.out.println("____________________");
                            System.out.println();
                            System.out.println("____________________");
                            System.out.println("1. Vil du se spillerens detaljer?");
                            System.out.println("2. Gå tilbage til hovedmenuen");
                            System.out.println("____________________");
                            boolean repeat2 = true;
                            while(repeat2)
                            {
                                String choice2 = scanner.nextLine();
                                switch (choice2)
                                {
                                    case "1":
                                        System.out.println("____________________");
                                        player.displayDetails();
                                        System.out.println("____________________");
                                        break;
                                    case "2":
                                        System.out.println("____________________");
                                        System.out.println("Går tilbage til hovedmenuen");
                                        System.out.println("____________________");
                                        repeat2 = false;
                                        break;
                                    default:
                                        System.out.println("____________________");
                                        System.out.println("Ugyldigt valg prøv igen");
                                        System.out.println("____________________");
                                }

                            }
                        }
                    }
                    break;
                case "7":
                    if (GameSystem.playerCount == 0)
                    {
                        System.out.println("_________________________________");
                        System.out.println("Ingen spillere til at ændre score");
                        System.out.println("_________________________________");
                    }
                    else {
                        System.out.println("Indtast spiller ID");
                        int playerId3 = scanner.nextInt();
                        System.out.println("Indtast score");
                        double newScore = scanner.nextDouble();
                        System.out.println("____________________");
                        gameSystem.updatePlayerScore(playerId3, newScore);
                        System.out.println("____________________");
                        scanner.nextLine();
                    }
                    break;
                case "8":
                    System.out.println("____________________");
                    System.out.println("Total indtjening: " + GameSystem.calculateTotalRevenue());
                    System.out.println("____________________");
                    break;
                case "9":
                    System.out.println("____________________");
                    GameSystem.findTopScoringPlayer();
                    System.out.println("____________________");
                    break;
                case "10":
                    System.out.println("____________________");
                    System.out.println("Programmet afsluttes");
                    System.out.println("____________________");
                    chosen = true;
                    break;
                default:
                    System.out.println("____________________");
                    System.out.println("Forkert input prøv igen");
                    System.out.println("____________________");


            }

        }
    }

}