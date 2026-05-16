
public class PlayerComputer extends Player
{
    public double myPercentageSteal, myPercentageCorrect;
    public PlayerComputer(String name, int score, boolean turn, double percentageSteal, double percentageCorrect)
    {
        super(name, score, turn);
        myPercentageSteal = percentageSteal;
        myPercentageCorrect = percentageCorrect;

    }

    public boolean ifSteal(){
        int stealVal = (int) (Math.random() * myPercentageSteal) + 1;
        return (stealVal <= myPercentageSteal);

    }

    public boolean ifCorrect(){
        int correctVal = (int) (Math.random() * myPercentageCorrect) + 1;
        return (correctVal <= myPercentageSteal);

    }



}
