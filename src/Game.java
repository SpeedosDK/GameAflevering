public class Game
{
    private int gameId;
    private String gameName;
    private String gameGenre;
    private double price;


    public Game()
    {

    }
    public Game(int gameId, String gameName, String gameGenre, double price)
    {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.price = price;
    }

    public int getGameId()
    {
        return gameId;
    }
    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }
    public String getTitle()
    {
        return gameName;
    }
    public void setGameTitle(String gameName)
    {
        this.gameName = gameName;
    }
    public String getGameGenre()
    {
        return gameGenre;
    }
    public void setGameGenre(String gameGenre)
    {
        this.gameGenre = gameGenre;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public void displayDetails()
    {
        System.out.println("Game ID: " + gameId);
        System.out.println("Game Name: " + gameName);
        System.out.println("Game Genre: " + gameGenre);
        System.out.println("Game Price: " + price);
    }
}
