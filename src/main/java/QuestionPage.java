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
    
        public QuestionPage(JFrame parent, Question q)
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

        panel.add(bottom, BorderLayout.SOUTH);

        // 
        // ANSWER CHECKING
        // we'll probably change this
        // it is too unforgiving now


        Timer countdown = new Timer(1000, null);
        countdown.addActionListener(e -> {
            secondsLeft[0]--;
            timerLabel.setText(secondsLeft[0] + "s");

            
            if (secondsLeft[0] <= 10) {
                timerLabel.setForeground(Color.ORANGE);
            }
            
            if (secondsLeft[0] <= 5) {
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

        
        submit.addActionListener(e -> {
            countdown.stop();
            answerField.setEnabled(false);
            submit.setEnabled(false);

            String userAnswer = answerField.getText().trim();

            if (userAnswer.equalsIgnoreCase(q.getAnswer()))
            {
                result.setText("Correct!");
                result.setForeground(Color.GREEN);
            }
            else
            {
                result.setText("Wrong!");
                result.setForeground(Color.RED);
                bottom.add(steal);
                bottom.revalidate();
                bottom.repaint();
            }
        });

        add(panel);
    
    }

    
}