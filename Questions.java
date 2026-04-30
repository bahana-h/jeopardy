import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

public class Questions
{
    // so there's gonna be a big bad question bank
    // with a lot of questions
    // you can lwk sort them by category in the array?
    // each category is a row in the array

    // so... we need something to scrape the questions from here
    //https://www.kaggle.com/datasets/tunguz/200000-jeopardy-questions?resource=download






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

    public Questions(String category, String question, String acceptableAnswers, int score)
    {
        myCategory = category;
        myQuestion = question;
        myAcceptableAnswers = acceptableAnswers;
        myScore = score;

    }

    public String getCategory()
    {
        return "adsk";
    }

    public int getScore()
    {
        return 1;
    }

    public String getQuestion()
    {
        return "aldfjdl";
    }

    public String getAcceptableAnswers()
    {
        return "aldfjkad";
    }


    // alright, when we have the entire question bank downloaded, we need to make all the questions T-T
    // put them in a 2d array list? where each row is a category


    List<List<Questions>> bank = new ArrayList<>();

    // Adding a new "row"
    bank.add(new ArrayList<>());

    // Adding an element to the first row (position [0][0])
    bank.get(0).add(10);
}

