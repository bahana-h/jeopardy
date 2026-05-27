import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndPage extends JPanel {

    public EndPage(Jeopardy frame, GamePage game) {

        setBackground(new Color(10, 10, 50));
        setLayout(new BorderLayout());

        Player p1 = game.getPlayer1();
        Player p2 = game.getPlayer2();

        if (p1 == null || p2 == null) {
            return;
        }

        String winnerText;

        if (p1.getScore() > p2.getScore()) {
            winnerText = p1.getName() + " wins!";
        } else if (p2.getScore() > p1.getScore()) {
            winnerText = p2.getName() + " wins!";
        } else {
            winnerText = "It's a tie!";
        }

        // Title
        JLabel title = new JLabel(winnerText, JLabel.CENTER);
        title.setForeground(Color.GREEN);
        title.setFont(new Font("Verdana", Font.BOLD, 48));

        // Scores
        JLabel scores = new JLabel(
                p1.getName() + ": " + p1.getScore() +
                "   |   " +
                p2.getName() + ": " + p2.getScore(),
                JLabel.CENTER
        );
        scores.setForeground(Color.WHITE);
        scores.setFont(new Font("Verdana", Font.PLAIN, 28));

        // Container panel to center vertically
        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(new Color(10, 10, 50));
        center.add(title, BorderLayout.NORTH);
        center.add(scores, BorderLayout.CENTER);

        add(center, BorderLayout.CENTER);
    }
}
