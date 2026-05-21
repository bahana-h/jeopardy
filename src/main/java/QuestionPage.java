
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

        submit.addActionListener(e -> {

            String userAnswer = answerField.getText().trim();

            if (userAnswer.equalsIgnoreCase(q.getAnswer()))
            {
                result.setText("Correct!");
                result.setForeground(Color.GREEN);

                //after stealing and it's correct
                // remove the steal button
                // idk how this is going to work though
            }

            else
            {
                result.setText("Wrong!");
                result.setForeground(Color.RED);
                bottom.add(steal);
            }
        });

        add(panel);
    
    }

    
}
