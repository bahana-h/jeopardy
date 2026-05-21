
public class PlayerComputer extends Player
{
    public double myPercentageSteal, myPercentageCorrect;
    public PlayerComputer(String name, int score, boolean turn, double percentageSteal, double percentageCorrect)
    {
        super(name, score, turn);
        myPercentageSteal = percentageSteal;
        myPercentageCorrect = percentageCorrect;

    }

    public boolean ifSteal()
    {
        double stealVal = Math.random();
        return (stealVal < myPercentageSteal);

    }

    public boolean ifCorrect()
    {
        double correctVal = (Math.random());
        return (correctVal < myPercentageCorrect);

    }



}
