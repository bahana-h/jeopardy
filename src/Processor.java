
import com.opencsv.CSVReader;
import java.io.FileReader;

public class Processor
{
    // reads the csv file and turns everything
    // into Question objects stored in a QuestionBank

    public static QuestionBank load(String filename)
    {
        QuestionBank bank = new QuestionBank();

        try
        {
            CSVReader reader =
                new CSVReader(new FileReader(filename));

            String[] row;

            // skips the first line
            // (Category, Value, Question, Answer)
            reader.readNext();

            // keeps reading until there are no more rows
            while ((row = reader.readNext()) != null)
            {
                String category = row[0].trim();
                String valueStr = row[1].trim();
                String question = row[2].trim();
                String answer = row[3].trim();

                // removes the $ sign
                // turns "$400" into 400
                int value =
                    Integer.parseInt(
                        valueStr.replace("$", "").trim()
                    );

                // creates a Question object
                Question q =
                    new Question(
                        category,
                        question,
                        answer,
                        value
                    );

                // adds it to the QuestionBank
                bank.addQuestion(q);
            }

            reader.close();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return bank;
    }
}
