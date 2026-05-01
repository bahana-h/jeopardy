import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank
{
    // so there's gonna be a big bad question bank
    // with a lot of questions
    //https://www.kaggle.com/datasets/tunguz/200000-jeopardy-questions?resource=download
    // tun-tun-tun-tunguz


    // LEARN HOW TO PARSE THROUGH THE EXCEL (CSV FILE) SHEET

    // we're assosciation two values, so a map would be best


    // the one and only
    private Map<String, List<Question>> questionBank = new HashMap<>();

    // methods

    // adding questions to the bank
    public void addQuestion(Question question)
    {
        String category = question.getQuestion();
        if (!questionBank.containsKey(category)) 
        {
            questionBank.put(category, new ArrayList<>());
        }


    }
}