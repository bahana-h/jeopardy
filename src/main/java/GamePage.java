import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// sources: https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html, https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html

public class GamePage extends JPanel{

    private Player player1;
    private Player player2;

    private JLabel player1score;
    private JLabel player2score;

    // for knowing when game ends
    private int questionsLeft = 30; // 5 rows × 6 cols

    // array type data for the board
    private Question[][] boardQuestions;
    private QuestionBank bank;

    // bot board
    private JButton[][] boardButtons;

    // TODO DO THE CATEGORY GENERATING STUFF

    // js putting it here but rgb for answered questions: 147 149 185 - nvm not being used

    // stopwatch stuff
    // private static int sec = 0;
    // private static Timer stopwatch;
    // private static JLabel time = new JLabel("00:00");

    public GamePage() {

        // ok now we gotta make the bot pick the next question randomly itself
        // so let's just make the exact same thing
        // but for the bot
        // so it can play an dhave fun too
        boardButtons = new JButton[5][6];


        
        
        // making the bank and the 2d array that represents the board
        this.bank = Processor.load("jeopardy.csv");

        // the dimensions
        boardQuestions = new Question[5][6];

        // what to put at the top 
        // cuz rn we just have 1,2,3,4,5,6
        String[] categories = new String[6];

        // adding random categories to the string name
        // need just 6 random categories and add them to the array

        // edits on how to not pick categories with elss than 5 questions
        int countVALIDS = 0;
        while (countVALIDS < 6) {
            String randomCategory = bank.getRandomCategory();
            List<Question> l = bank.getCategoryQuestions(randomCategory);
            // checks if the category has at least 5 questions
            if ((l != null) && (l.size() >= 5)) {
                categories[countVALIDS] = randomCategory;
                for (int r = 0; r < 5; r++) {
                    boardQuestions[r][countVALIDS] = l.get(r);
                }
                countVALIDS++;
            }
        }

        // alr categories done

        // NOW LET'S PUT THE QUESTIONS ON THE BOOOOAAAAAAAAAARD

        // hannah edit : i combined this one with the other loop above this

        // for every column, just add the list by column
        // for (int c = 0; c < 6; c++) 
        // {
        //     String category = categories[c];

        //     java.util.List<Question> list = bank.getCategoryQuestions(category);

        //     for (int r = 0; r < 5; r++) 
        //     {
        //         boardQuestions[r][c] = list.get(r);
        //     }
        // }



        // stuff to fix ugly looking buttons after being clicked - ok burh it still doestn work its fine
        UIManager.put("Button.disabledText", Color.BLACK);

        // using borderlayout - divides the page into top, left, center, right, and bottom (which is perfect for what i wanna do here)
        setLayout(new BorderLayout(10, 10));

        // same as homepage
        setBackground(new Color(10, 10, 50));

        // this is for the player scores and stop watch at the VERY TOP
        JPanel top = new JPanel(new GridLayout(1, 3));
        top.setBackground(Color.BLACK);
        top.setPreferredSize(new Dimension(1500, 100));
        // stuff thats at the top
        Font text = new Font("Verdana", Font.BOLD, 20);
        // TODO MAKE THE POINT VALUE UPDATE
        player1score = new JLabel("Player one: 0", SwingConstants.CENTER);        player1score.setForeground(Color.WHITE);
        player1score.setFont(text);
        top.add(player1score);
        // TODO MAKE THE STOP WATCH
        JLabel stopwatch = new JLabel("Jeopardy", SwingConstants.CENTER);
        stopwatch.setForeground(Color.WHITE);
        stopwatch.setFont(text);
        top.add(stopwatch);
        // TODO MAKE THE POINT VALUE UPDATE
        player2score = new JLabel("Player two: 0", SwingConstants.CENTER);        player2score.setForeground(Color.WHITE);
        player2score.setFont(text);
        top.add(player2score);
        // adding top stuff to the TOP (NORTH) of the game page
        add(top, BorderLayout.NORTH);

        // next im making the 6x5 for the game
        JPanel grid = new JPanel(new GridLayout(6, 6));
        grid.setBackground(new Color(10, 10, 50)); // same navy blue

        // top row w categories
        // TODO SOMEHOW GENERATE CATEGORIES AND LINK IT WHEN LIKE MAKING PROBLEMS AND SEEING IF ANSWERS ARE CORRECT
        
        // replaced the stuff below
        //String[] categories = {"1", "2", "3", "4", "5", "6"};


        for (String category : categories) {
            // i searched this up so this can help with text wrapping -> maintain centering
            String htmlCat = "<html><body style='text-align: center;'>" + category + "</body></html>";
            JLabel categor = new JLabel(htmlCat, SwingConstants.CENTER);
            // need this cuz i wana set a color in the back
            categor.setOpaque(true);
            categor.setBackground(new Color(0, 0, 150));
            categor.setForeground(Color.WHITE);
            categor.setFont(new Font("Verdana", Font.BOLD, 18));
            categor.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            grid.add(categor);
        }

        // the buttons w point values
        for (int r = 0; r <= 4; r++) {
            for (int c = 0; c < 6; c++) 
            {
                // the point values
                JButton bu = new JButton("" + ((r + 1) * 100)); // aprently it can only be string and i cant cast for some reason so i js did this
                bu.setFont(new Font("Verdana", Font.BOLD, 18));
                //bu.setBackground(new Color(10, 10, 50));
                bu.setForeground(new Color(10, 10, 50));
                // shows a dashed line there
                // update: okay appretnly it js doesnt work
                // bu.setFocusPainted(false);
                // thhe action listener stuff


                // made question page, replacing hannah's code
                // it must be done

                // making the actual questions appear from the random categories

                // OK OK OK
                // the computer player selection
                // put all the buttons in an array
                boardButtons[r][c] = bu;
                // now ...it... knows everything

                final int row = r;
                final int col = c;

                bu.addActionListener
                (e -> 
                {

                    bu.setEnabled(false);
                    bu.setBackground(Color.GRAY);

                    // TEST QUESTION
                    // alr replacing it this time
                    Question q = boardQuestions[row][col];

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GamePage.this);
                    System.out.println("CLICKED QUESTION!!");
                    
                    QuestionPage popup = new QuestionPage(frame, q, this);

                    popup.setVisible(true);

                    // decrement
                    questionFinished();
                }

                );
                
                grid.add(bu);
                
                
            }
    
    }

        // Add the 6x6 grid to the CENTER of the GamePage
        add(grid, BorderLayout.CENTER);


        // stuff i wrote before with a frame i js didnt want to break smth js incase the above didnt work and i needed to swtich back so i js left it here

        // Font title = new Font("Verdana", Font.BOLD, 20);

        // JFrame gameboard = new JFrame("jeopardy");
        // gameboard.setPreferredSize(new Dimension(1500, 900));

        // // tjis stuff is the top column

        // // JLabel player1score = 

        // // JLabel player2score =


        // // stop watch stuff here

        // // stopwatch = new Timer(1000, new ActionListener());
        // // sec++;
        // // int hours = sec / 3600;
        // // int minutes = (sec % 3600) / 60;
        // // int seconds = sec % 60;
        // // time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));


        // JPanel grid = new JPanel(new GridLayout(6, 6));
        // grid.setPreferredSize(new Dimension(1500, 750));

        
        // // add buttons to each grid except for the top row
        // for (int i = 0; i < 36; i++) {
        //     if (i < 6) {
        //         // Top Row: Add labels for text
        //         JLabel header = new JLabel("category " + (i + 1), SwingConstants.CENTER);
        //         header.setFont(title);
        //         // Optional: add a border so you can see the cell boundaries
        //         header.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        //         grid.add(header);
        //     } else if (i / 6 == 1) {
        //         grid.add(new JButton("100"));
        //     } else if (i / 6 == 2) {
        //         grid.add(new JButton("200"));
        //     } else if (i / 6 == 3) {
        //         grid.add(new JButton("300"));
        //     } else if (i / 6 == 4) {
        //         grid.add(new JButton("400"));
        //     } else {
        //         grid.add(new JButton("500"));
        //     }
        // }
        // gameboard.add(grid);
        // gameboard.setVisible(true);



    }

    // need new methods

    public void setPlayers(Player p1, Player p2)
    {
        player1 = p1;
        player2 = p2;

        player1score.setText(player1.getName() + ": " + player1.getScore());
        player2score.setText(player2.getName() + ": " + player2.getScore());
    }

    public void updateScoreLabels()
    {
        player1score.setText(player1.getName() + ": " + player1.getScore());
        player2score.setText(player2.getName() + ": " + player2.getScore());
    }

    public Player getCurrentPlayer()
    {
        if (player1.isTurn())
        {
            return player1;
        }

        return player2;
    }

    public void switchTurns()
    {
        player1.changeTurn();
        player2.changeTurn();
    }

    // method for the computer player to click a question
    public void computerChooseQuestion()
    {
        // keep choosing random questions
        while(true)
        {

            int randomRow = (int)(Math.random() * 5);
            int randomCol = (int)(Math.random() * 6);
            JButton chosen = boardButtons[randomRow][randomCol];

            // until you find an unanswered one
            if (chosen.isEnabled())
            {
                // acc clicks for the computer
                chosen.doClick();

                return;
            }
        }
    }


    // method for checkinf if the game is over
    public void checkGameOver() 
    {
        if (questionsLeft <= 0) {

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            if (frame instanceof Jeopardy j) 
            {
                j.goToEndPage(this);
            }
        }
    }

    public void questionFinished() 
    {
        questionsLeft--;
        checkGameOver();
    }

    // getters for players

    public Player getPlayer1() 
    {
        return player1;
    }

    public Player getPlayer2() 
    {
        return player2;
    }


}
