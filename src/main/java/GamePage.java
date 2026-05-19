import java.io.*;
import javax.swing.*;
import java.awt.*;
// import java.awt.Font;
// import java.awt.GridLayout;
// import java.awt.Color;
// import java.awt.Dimension;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.time.*;

// sources: https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html, https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html

public class GamePage extends JPanel{

    // TODO DO THE CATEGORY GENERATING STUFF

    // js putting it here but rgb for answered questions: 147 149 185 - nvm not being used

    // stopwatch stuff
    // private static int sec = 0;
    // private static Timer stopwatch;
    // private static JLabel time = new JLabel("00:00");

    public GamePage() {
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
        JLabel player1score = new JLabel("Player 1: 0", SwingConstants.CENTER);
        player1score.setForeground(Color.WHITE);
        player1score.setFont(text);
        top.add(player1score);
        // TODO MAKE THE STOP WATCH
        JLabel stopwatch = new JLabel("00:00", SwingConstants.CENTER);
        stopwatch.setForeground(Color.WHITE);
        stopwatch.setFont(text);
        top.add(stopwatch);
        // TODO MAKE THE POINT VALUE UPDATE
        JLabel player2score = new JLabel("Player 2: 0", SwingConstants.CENTER);
        player2score.setForeground(Color.WHITE);
        player2score.setFont(text);
        top.add(player2score);
        // adding top stuff to the TOP (NORTH) of the game page
        add(top, BorderLayout.NORTH);

        // next im making the 6x5 for the game
        JPanel grid = new JPanel(new GridLayout(6, 6));
        grid.setBackground(new Color(10, 10, 50)); // same navy blue

        // top row w categories
        // TODO SOMEHOW GENERATE CATEGORIES AND LINK IT WHEN LIKE MAKING PROBLEMS AND SEEING IF ANSWERS ARE CORRECT
        String[] categories = {"1", "2", "3", "4", "5", "6"};
        for (String category : categories) {
            JLabel categor = new JLabel(category, SwingConstants.CENTER);
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
            for (int c = 0; c < 6; c++) {
                // the point values
                JButton bu = new JButton("" + ((r + 1) * 100)); // aprently it can only be string and i cant cast for some reason so i js did this
                bu.setFont(new Font("Verdana", Font.BOLD, 18));
                //bu.setBackground(new Color(10, 10, 50));
                bu.setForeground(new Color(10, 10, 50));
                // shows a dashed line there
                // update: okay appretnly it js doesnt work
                // bu.setFocusPainted(false);
                // thhe action listener stuff
                bu.addActionListener(e -> {
                    // this means taht it cant be clicked again after it is clicked once
                    // ok but also it made the formatting ugly so i tried changing it ok so it still doesnt work
                    // apparently i need to do it before ok so i moved it
                    bu.setEnabled(false);
                    //bu.setForeground(Color.BLACK);
                    bu.setBackground(Color.GRAY);
                });
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
}
