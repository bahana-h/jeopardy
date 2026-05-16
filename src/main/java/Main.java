// PLACEHOLDER
// TODO: FIX THIS AND MAKE THIS START EVERYTHING

public class Main 
{
    public static void main(String[] args) {
        System.out.println("Starting Jeopardy");

        
        // testing that the processor class works
        QuestionBank bank = Processor.load("jeopardy.csv");
        System.out.println("Loaded questions!");
    }
}

// confirmed system prints starting jeopardy after running