import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    // sort by category, so each key is a category
    // that points to a list of quesitons in that category
    // if teh category already exists, don't make a new list


    public void addQuestion(Question question)
    {
        // get the category
        String category = question.getCategory();

        // now make the list that the questions go into
        // only make a new one if there's a new cateogyr
        if (!questionBank.containsKey(category)) 
        {
            questionBank.put(category, new ArrayList<>());

        }


        // if it's already there, put it in the array list assosciated iwth the category
        questionBank.get(category).add(question);


    }


    // alr method time

    // acessor methods

    // get the bank
    // idk how this might be used but it's ok
    public Map< String, List<Question>> getBank()
    {
        return questionBank;
    }

    // get all the questions for a category
    public List<Question> getCategoryQuestions(String category)
    {
        return questionBank.get(category);
    }

    // get all the categories
    public Set<String> getAllCategories()
    {
        return questionBank.keySet();
    }
    

}