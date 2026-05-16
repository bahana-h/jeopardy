import java.io.InputStream;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

// csv reader works much like the scanner class

public class Processor {

    public static QuestionBank load(String filename) {
        QuestionBank bank = new QuestionBank();

        try 
        {
            // load file from src/main/resources
            // uses stream methods
            InputStream is = Processor.class.getClassLoader().getResourceAsStream(filename);

            // safeguard
            if (is == null) 
            {
                throw new RuntimeException("File not found in resources: " + filename);
            }

            CSVReader reader = new CSVReader(new InputStreamReader(is));

            String[] row;

            // skip header
            reader.readNext();

            while ((row = reader.readNext()) != null) {

                String category = row[0].trim();
                String valueStr = row[1].trim();
                String question = row[2].trim();
                String answer = row[3].trim();
            
                // remove dollar signs 
                // to get integer points that can be used

                // was causing issues as x,xxx format with the comma
                // could not be parced
                // so commas inside numbers must also be removed


                int value = 
                Integer.parseInt
                (valueStr.replace("$", "")
                .replace(",", "").trim());

                // alright alright alright
                // after running this 5/15 10:09 PM
                // some of the questoin values 
                // are literally "None"
                // T-T
                // so we need to work around that

                Question q = new Question(category, question, answer, value);
                bank.addQuestion(q);
            }

            // jst like the scanner class in java
            reader.close();

        } 
        

        // req'd exception catch
        // the throw command gives better and clearer feedback
        catch (Exception e) 
        {
            throw new RuntimeException("error on CSV", e);

        }


        return bank;
    }
}