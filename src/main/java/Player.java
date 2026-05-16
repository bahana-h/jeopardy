
public class Player 
{
    
public String playerName;
public int playerScore;
public boolean isTurn;


public Player(String name, int score, boolean turn)
{
    playerName = name;
    playerScore = score;
    isTurn = turn;

}


// methods

public void setScore(int score)
{
    playerScore = score;
}

// can be negative or positive
public void changeScore( int change)
{
    playerScore = playerScore + change;
}

public void setTurn( boolean turn)
{
    isTurn = turn;
}

public void changeTurn()
{
    isTurn = (!isTurn);
}


// getter methods

public String getName()
{
    return playerName;

}

public int getScore()
{
    return playerScore;
}

public boolean isTurn()
{
    return isTurn;
}


    
}
