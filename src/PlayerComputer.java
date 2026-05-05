
public class PlayerComputer extends Player
{
    public double myPercentage;
    public PlayerComputer(String name, int score, boolean turn, double percentage)
    {
        super(name, score, turn);
        myPercentage = percentage;

    }
}
