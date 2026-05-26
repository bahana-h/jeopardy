import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
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
        gr.gridy = 3;
        gr.gridx = 0;
        gr.gridwidth = 2;
        gr.insets = new Insets(40, 0, 0, 0);
        add(start, gr);

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

            Player player1 = new Player(player1name, 0, true);
            Player player2 = new Player(player2name, 0, false);

            // give the players to game page
            gamepg.setPlayers(player1, player2);

            // switch screen
            thing.showScreen("gamepg");
        });
    }
}