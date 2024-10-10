public class Player
{
    private int playerID;
    private String playerName;
    private int age;
    private double score;


    public Player(int playerID, String playerName, int age, double score)
    {
        this.playerID = playerID;
        this.playerName = playerName;
        this.age = age;
        this.score = score;
    }

    public int getPlayerID()
    {
        return playerID;
    }
    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }
    public String getPlayerName()
    {
        return playerName;
    }
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public double getScore()
    {
        return score;
    }
    public void setScore(double score)
    {
        this.score = score;
    }

    public void displayDetails()
    {
        System.out.println("Player ID: " + getPlayerID());
        System.out.println("Player Name: " + getPlayerName());
        System.out.println("Player Age: " + getAge());
        System.out.println("Player Score: " + getScore());
    }

    public void updateScore(double newScore)
    {
        this.score = newScore;
    }
}
