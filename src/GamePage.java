import java.io.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class GamePage {

    // TODO DO THE CATEGORY GENERATING STUFF

    // stopwatch stuff
    private static int sec = 0;
    private static Timer stopwatch;
    private static JLabel time = new JLabel("00:00:00");

    public static void main(String[] args) {
        Font title = new Font("Cantarell", Font.BOLD, 20);

        JFrame gameboard = new JFrame("jeopardy");
        gameboard.setPreferredSize(new Dimension(1500, 900));

        // tjis stuff is the top column

        // JLabel player1score = 

        // JLabel player2score =


        // stop watch stuff here

        // stopwatch = new Timer(1000, new ActionListener());
        // sec++;
        // int hours = sec / 3600;
        // int minutes = (sec % 3600) / 60;
        // int seconds = sec % 60;
        // time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));


        JPanel grid = new JPanel(new GridLayout(6, 6));
        grid.setPreferredSize(new Dimension(1500, 750));

        
        // add buttons to each grid except for the top row
        for (int i = 0; i < 36; i++) {
            if (i < 6) {
                // Top Row: Add labels for text
                JLabel header = new JLabel("category " + (i + 1), SwingConstants.CENTER);
                header.setFont(title);
                // Optional: add a border so you can see the cell boundaries
                header.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                grid.add(header);
            } else if (i / 6 == 1) {
                grid.add(new JButton("100"));
            } else if (i / 6 == 2) {
                grid.add(new JButton("200"));
            } else if (i / 6 == 3) {
                grid.add(new JButton("300"));
            } else if (i / 6 == 4) {
                grid.add(new JButton("400"));
            } else {
                grid.add(new JButton("500"));
            }
        }
        gameboard.add(grid);
        gameboard.setVisible(true);
    }
}
