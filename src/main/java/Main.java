// PLACEHOLDER
// TODO: FIX THIS AND MAKE THIS START EVERYTHING
// it's gonna be moved to jeopardy
// this is just Sasha's personal playground

import java.util.List;
import java.util.Scanner;

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
        // int printed = 0;

        // for (String category : bank.getAllCategories())
        // {
        //     List<Question> questions = bank.getCategoryQuestions(category);

        //     for (Question q : questions)
        //     {
        //         System.out.println(q);

        //         printed++;

        //         if (printed >= 10)
        //         {
        //             return;
        //         }
        //     }
        // }

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


        // ALR
        // NOW FOR THE BIG KAHUNA
        // let's choose a random category
        // and print all the questions (whole objects? sure)
        // from that category
        // i'll go make a method for this in Question bank
        // then come back here and test it

        System.out.println("printing a random category's questions");

        List<Question> testList = bank.getRandomCategoryQuestions();

        for (Question q : testList)
        {
            System.out.println(q);
        }


        // alright that all works
        // now
        // next test is print a question
        // get the answer
        // check it
        // award earned points

        System.out.println("printing a random question for you to answer");

        List<Question> testList2 = bank.getRandomCategoryQuestions();

        // the 100 dolla question
        System.out.println(testList2.get(0));

        System.out.println(testList.get(0).getAcceptableAnswers());

        System.out.println("answer: ");

        Scanner scanner = new Scanner(System.in);
        
        String answer = scanner.nextLine();

        

        if (answer.equalsIgnoreCase(testList2.get(0).getAcceptableAnswers()))
        {
            System.out.println("correct");
        }

        else
        {
            System.out.println("the answer's literally printed for you rn");
        }

        scanner.close();

        

    }
}

// confirmed system prints starting jeopardy after running
// procesor call works
// all data works fine