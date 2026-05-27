// this will be shown once the player clicks on a question to answer it
// following the design of GUI pages hannah already made

// all the imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class QuestionPage extends JDialog
{
    
    public QuestionPage(JFrame parent, Question q, GamePage gamePage)
    {
        super(parent, "Question", true);

        setSize(600, 400);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBackground(new Color(10, 10, 50));

        final int TIME_LIMIT = 30;
        int[] secondsLeft = {TIME_LIMIT};

        
        JLabel timerLabel = new JLabel(secondsLeft[0] + "s", SwingConstants.CENTER);
        timerLabel.setForeground(Color.YELLOW);
        timerLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(10, 10, 50));
        topPanel.add(timerLabel, BorderLayout.EAST);
        panel.add(topPanel, BorderLayout.NORTH);

        // question text
        JLabel questionLabel = new JLabel(
            "<html><div style='text-align:center;'>" 
            + q.getQuestion() 
            + "</div></html>",
            SwingConstants.CENTER
        );

        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Verdana", Font.BOLD, 24));

        panel.add(questionLabel, BorderLayout.CENTER);

        


        // bottom section
        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(10, 10, 50));

        JTextField answerField = new JTextField(20);

        JButton submit = new JButton("Submit");

        JLabel result = new JLabel("");

        bottom.add(answerField);
        bottom.add(submit);
        bottom.add(result);



        

        // future stealing implementation?
        JButton steal = new JButton("steal?");
        //bottom.add(steal);


        // keeping track
        boolean[] stolen = {false};

        // MAKING A WORKING STEAL
        steal.addActionListener(e ->
        {
            // gotta remove this because it switches twice with the wrong check
            //gamePage.switchTurns();

            stolen[0] = true;

            answerField.setEnabled(true);
            submit.setEnabled(true);

            answerField.setText("");

            steal.setEnabled(false);

            result.setText("Stolen!");
            result.setForeground(Color.YELLOW);
        });

        panel.add(bottom, BorderLayout.SOUTH);

        // 
        // ANSWER CHECKING
        // we'll probably change this
        // it is too unforgiving now


        Timer countdown = new Timer(1000, null);
        countdown.addActionListener(e -> {
            secondsLeft[0]--;
            timerLabel.setText(secondsLeft[0] + "s");

            
            if (secondsLeft[0] <= 20) {
                timerLabel.setForeground(Color.ORANGE);
            }
            
            if (secondsLeft[0] <= 10) {
                timerLabel.setForeground(Color.RED);
            }

            
            if (secondsLeft[0] <= 0) {
                countdown.stop();
                answerField.setEnabled(false);
                submit.setEnabled(false);
                result.setText("Time's up!");
                result.setForeground(Color.RED);
                bottom.add(steal);
                bottom.revalidate();
                bottom.repaint();
            }
        });
        countdown.start();




        // ALRIGHT ALRIGHT
        // the bot gotta be able to answer questions on it's own
        // doing this after the steal methods so 
        // it's basically the same sturcutre as taht

        Player currentPlayer = gamePage.getCurrentPlayer();

        // check 
        if (currentPlayer.isComputer())
        {
            // disable the answer fields
            // or you could put a jumbled answer in there
            // but idk 

            answerField.setEnabled(false);
            submit.setEnabled(false);

            // give some naturality and time
            result.setText(currentPlayer.getName() + " is thinking...");

            // eh let's keep ti orange
            result.setForeground(Color.ORANGE);

            // time delay for thinking seems unnatural
            //TODO: maybe randomize it?
            // rn 10 seconds
            Timer botAnswerTimer = new Timer(10000, 
                
            // what to do

            // alright now i have to add the computer chooses next question code
            /// in two places
            /// if it gets it right normally
            /// or if it steals and gets it right
            

            e ->
            {
                countdown.stop();

                // right or wrong


                if (currentPlayer.ifCorrect())
                {
                    result.setText(currentPlayer.getName() + " got it right!");
                    result.setForeground(Color.GREEN);

                    currentPlayer.changeScore(q.getScore());

                    // chooses next question
                    Timer nextQuestion = new Timer(1500,
                    e2 ->
                    {
                        //gotta close the prvious question or it gets messy
                        dispose();

                        gamePage.computerChooseQuestion();
                    });

                    nextQuestion.setRepeats(false);
                    nextQuestion.start();
                }


                else
                {
                    result.setText(currentPlayer.getName() + " got it wrong!");
                    result.setForeground(Color.RED);

                    currentPlayer.changeScore(-q.getScore());

                    gamePage.switchTurns();

                    // bug where at the end of a pick by the bot
                    // the steal button doesn't show up for the human player

                    bottom.add(steal);
                    bottom.revalidate();
                    bottom.repaint();

                    //so jst add it
                    // same for the other scenario
                    //i'll copy paste it over there
                }


                // change everything
                gamePage.updateScoreLabels();
            });


            botAnswerTimer.setRepeats(false);
            botAnswerTimer.start();
        }



        
        // AFTER the answer's been submitted by the player who's turn it is
        submit.addActionListener(e -> {
            countdown.stop();
            answerField.setEnabled(false);
            submit.setEnabled(false);

            String userAnswer = answerField.getText().trim();

            if (userAnswer.equalsIgnoreCase(q.getAnswer()))
            {
                result.setText("Correcto!");
                result.setForeground(Color.GREEN);

                // gets whose turn it is
                Player current = gamePage.getCurrentPlayer();

                // award points
                current.changeScore(q.getScore());

                // refresh labels at top
                gamePage.updateScoreLabels();
            }
            else
            {
                result.setText("Nuh-uh!");
                result.setForeground(Color.RED);

                // gets whose turn it is
                Player current = gamePage.getCurrentPlayer();

                // subtract points
                current.changeScore(-q.getScore());

                // refresh labels
                gamePage.updateScoreLabels();

                // switch whose turn it is

                // OKay ookay
                // now we have to also consider the steal


                // OK OK
                // NOW THIS GOTTA BE CHANGED FOR THE COMPUTER PLAYER TO WORK

                // check if it's a computer taking a turn
                // then do the whole steal and correct managing

                if (!stolen[0])
                {
                    gamePage.switchTurns();

                    // check
                    Player nextPlayer = gamePage.getCurrentPlayer();

                    // if computer
                    if (nextPlayer.isComputer())
                    {

                        // now if it happens instantly
                        // it might be confusing
                        // so let's make a timer

                        result.setText(nextPlayer.getName() + " is thinking...");
                        result.setForeground(Color.ORANGE);

                        //
                        Timer botTimer = new Timer(10000, 
                    
                        ev ->
                        {
                            // managing all the stealing

                            // if steal, right wrong
                            // doesn't steal, well , that's it

                            if (nextPlayer.ifSteal())
                            {


                                if (nextPlayer.ifCorrect())
                                {
                                    result.setText(nextPlayer.getName() + " got it right!");
                                    result.setForeground(Color.GREEN);

                                    nextPlayer.changeScore(q.getScore());

                                    // now the bot chooses a new one
                                    // if it steals and gets it right
                                    Timer nextQuestion = new Timer(1500,
                                    e2 ->
                                    {
                                        // same thing
                                        dispose();
                                        gamePage.computerChooseQuestion();
                                    });

                                    nextQuestion.setRepeats(false);
                                    nextQuestion.start();
                                }


                                else
                                {
                                    result.setText(nextPlayer.getName() + " got it wrong!");
                                    result.setForeground(Color.RED);

                                    nextPlayer.changeScore(-q.getScore());

                                    gamePage.switchTurns();

                                    // bug where at the end of a pick by the bot
                                    // the steal button doesn't show up for the human player

                                    bottom.add(steal);
                                    bottom.revalidate();
                                    bottom.repaint();

                                    //so jst add it
                                    // same for the other scenario
                                    //i'll copy paste it over there
                                }

                                gamePage.updateScoreLabels();

                            }


                            else
                            {
                                result.setText(nextPlayer.getName() + " didn't steal.");

                                gamePage.switchTurns();
                            }
                        });

                        botTimer.setRepeats(false);
                        botTimer.start();
                    }



                    // if it's not a computer
                    // it's jst regular old joe
                    // so the regular block from before
                    else
                    {
                        bottom.add(steal);
                        bottom.revalidate();
                        bottom.repaint();
                    }


                }

                // gamePage.switchTurns();

                // bottom.add(steal);
                // bottom.revalidate();
                // bottom.repaint();


            }
        });

        add(panel);
    
    }

    
}