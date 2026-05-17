// PLACEHOLDER
// TODO: FIX THIS AND MAKE THIS START EVERYTHING

import java.util.List;

public class Main 
{
    public static void main(String[] args) {
        System.out.println("Starting Jeopardy");


        // testing that the processor class works
        QuestionBank bank = Processor.load("jeopardy.csv");
        System.out.println("questions are loaded");

        // now
        // let's test to see if question bank works

        // let's say 10 categories?

        // 
        int printed = 0;

        for (String category : bank.getAllCategories())
        {
            List<Question> questions = bank.getCategoryQuestions(category);

            for (Question q : questions)
            {
                System.out.println(q);

                printed++;

                if (printed >= 10)
                {
                    return;
                }
            }
        }

        // output looks like
        // Question@5305068a
        // Question@1f32e575
        // Question@279f2327

        // this is because
        // printing the println(q) quesiton
        // uses the default object toString metohd
        // which is funky
        // so it needs to be overriden

        // overriden and works
        // test good
    }
}

// confirmed system prints starting jeopardy after running
// procesor call works
// all data works fine