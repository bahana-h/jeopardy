import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlayerCreationPage extends JPanel
{
    public PlayerCreationPage(Jeopardy thing, GamePage gamepg)
    {
        setLayout(new GridBagLayout());

        setBackground(new Color(10, 10, 50));

        GridBagConstraints gr = new GridBagConstraints();

        Font titleFont = new Font("Verdana", Font.BOLD, 40);
        Font textFont = new Font("Verdana", Font.PLAIN, 20);

        // title
        JLabel title = new JLabel("create your players", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(titleFont);

        // player 1 label
        JLabel p1 = new JLabel("player one:");
        p1.setForeground(Color.WHITE);
        p1.setFont(textFont);

        // player 1 text field
        JTextField p1field = new JTextField(15);
        p1field.setFont(textFont);

        // player 2 label
        JLabel p2 = new JLabel("player two:");
        p2.setForeground(Color.WHITE);
        p2.setFont(textFont);

        // player 2 text field
        JTextField p2field = new JTextField(15);
        p2field.setFont(textFont);

        // button
        JButton start = new JButton("start game");
        start.setFont(textFont);
        start.setPreferredSize(new Dimension(220, 60));

        // TITLE
        gr.gridx = 0;
        gr.gridy = 0;
        gr.gridwidth = 2;
        gr.insets = new Insets(0, 0, 60, 0);
        add(title, gr);

        // PLAYER 1 LABEL
        gr.gridy = 1;
        gr.gridx = 0;
        gr.gridwidth = 1;
        gr.insets = new Insets(10, 10, 10, 10);
        add(p1, gr);

        // PLAYER 1 FIELD
        gr.gridx = 1;
        add(p1field, gr);

        // PLAYER 2 LABEL
        gr.gridy = 2;
        gr.gridx = 0;
        add(p2, gr);

        // PLAYER 2 FIELD
        gr.gridx = 1;
        add(p2field, gr);

        // BUTTON
        // moving this down so we can add the comp. player seletion
        //3 to 5
        gr.gridy = 5;
        gr.gridx = 0;
        gr.gridwidth = 2;
        gr.insets = new Insets(40, 0, 0, 0);
        add(start, gr);

        // have to put this before the action listener


        // OK
        // more features
        // computer player now!!!! wowza
        // just make a tickbox that they can select
        // to play against one
        // and choose the difficulty
        // i'll  let them name the bot whatever they want

        // ask
        JCheckBox computerBox = new JCheckBox("Play against a Bot as Player 2?");

        computerBox.setBackground(new Color(10, 10, 50));
        computerBox.setForeground(Color.WHITE);
        computerBox.setFont(textFont);

        // difficulty dropdown
        String[] difficulties = {"Easy", "Medium", "Hard"};
        JComboBox<String> difficultyBox = new JComboBox<>(difficulties);

        difficultyBox.setFont(textFont);



        // now let's put them whre we need them
        // select
        gr.gridy = 3;
        gr.gridx = 0;
        gr.gridwidth = 2;
        add(computerBox, gr);

        // hardness
        gr.gridy = 4;
        add(difficultyBox, gr);



        // button logic
        start.addActionListener(e ->
        {
            String player1name = p1field.getText().trim();
            String player2name = p2field.getText().trim();

            // default names if blank
            if (player1name.equals(""))
            {
                player1name = "Player One";
            }

            if (player2name.equals(""))
            {
                player2name = "Player Two";
            }

            // OK
            // have to redo this
            // because player 2 can be a little wall-e now
            // or maybe the guy from short circuit he's cute too
            
            Player player1 = new Player(player1name, 0, true);


           // Player player2 = new Player(player2name, 0, false);

           Player player2;
           // atts
           double stealChance = 0.00;
           double correctChance = 0.00;

           if (computerBox.isSelected())
            {
                String difficulty = (String) difficultyBox.getSelectedItem();

                // settings

                if (difficulty.equals("Easy"))
                {
                    stealChance = 0.75;
                    correctChance = 0.60;
                }

                
                if (difficulty.equals("Medium"))
                {
                    stealChance = 0.85;
                    correctChance = 0.70;
                }

                if (difficulty.equals("Hard"))
                {
                    stealChance = 0.95;
                    correctChance = 0.85;
                }

                player2 = 
                new PlayerComputer
                (player2name,0,false,stealChance, correctChance);
            }

            else
            {
                player2 = new Player(player2name, 0, false);
            }

            // give the players to game page
            gamepg.setPlayers(player1, player2);

            // switch screen
            thing.showScreen("gamepg");
        });




    
    }
}
