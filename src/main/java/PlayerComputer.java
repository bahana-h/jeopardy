
public class PlayerComputer extends Player
{
    public double myPercentageSteal, myPercentageCorrect;
    public PlayerComputer(String name, int score, boolean turn, double percentageSteal, double percentageCorrect)
    {
        super(name, score, turn);
        myPercentageSteal = percentageSteal;
        myPercentageCorrect = percentageCorrect;

    }

    // overriding it
    @Override
    public boolean ifSteal()
    {
        double stealVal = Math.random();
        return (stealVal < myPercentageSteal);

    }

    @Override
    public boolean ifCorrect()
    {
        double correctVal = (Math.random());
        return (correctVal < myPercentageCorrect);

    }

    // if it's a computer player
    // it returns true if it's a computer player
    // because it ovverrode the acc player false return method
    @Override
    public boolean isComputer()
    {
        return true;
    }





}
