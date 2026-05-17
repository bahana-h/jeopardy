

// probably done!
// a question itself
public class Question
{
    // each question has 
    //Category
    // Score
    // Question
    // Acceptable answers
    // Multipliers and special conditions

    public String myCategory;
    public String myQuestion;
    public String myAcceptableAnswers;
    public int myScore;

    public Question(String category, String question, String acceptableAnswers, int score)
    {
        myCategory = category;
        myQuestion = question;
        myAcceptableAnswers = acceptableAnswers;
        myScore = score;

    }

    public String getCategory()
    {
        return myCategory;
    }

    public int getScore()
    {
        return myScore;
    }

    public String getQuestion()
    {
        return myQuestion;
    }

    public String getAcceptableAnswers()
    {
        return myAcceptableAnswers;
    }



    // overriding the object ToString
    // so we don't use the default object one

    // yellow line under toString says add an override annotation
    @Override
    public String toString()
    {
         return (myCategory + " | $" 
         + myScore + " | " 
         + myQuestion + " | " 
         + myAcceptableAnswers);
    }
}
