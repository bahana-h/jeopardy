import java.io.*;
import javax.swing.*;
import java.awt.*;
// import java.awt.Font;
// import java.awt.GridBagLayout;
// import java.awt.Color;
// import java.awt.GridLayout;
// import java.awt.Dimension;

// source: https://www.geeksforgeeks.org/java/introduction-to-java-swing/, https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

// TODO: - CHOOSE PLAYER VS PLAYR OR PLAYER VS COMPUTER

public class HomePage extends JPanel {
    public HomePage(Jeopardy thing) {

        // i used gridbag layout since it was best for centering things
        setLayout(new GridBagLayout());

        // bit of a navy blue
        setBackground(new Color(10, 10, 50));

        // title
        JLabel welcome = new JLabel("welcome to jeopardy!", SwingConstants.CENTER);
        //welcome.setBounds(400, 200, 700, 200); - didnt need this with gridbaglayout
        welcome.setFont(new Font("Verdana", Font.BOLD, 50));
        welcome.setForeground(Color.WHITE);

        // enter button
        JButton button = new JButton("enter");
        //button.setBounds(650, 600, 200, 50); - didnt need this with gridbaglayout
        button.setFont(new Font("Verdana", Font.PLAIN, 20));
        button.setPreferredSize(new Dimension(200, 80));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);

        // using grid bag layout
        // most of this stuff i started with copying from that website i linked at the top
        GridBagConstraints gr = new GridBagConstraints();
        gr.gridx = 0; // top column
        gr.gridy = 0; // top row
        gr.insets = new Insets(0, 0, 100, 0); // 100 pxs of space below the title
        add(welcome, gr);

        gr.gridy = 1; // this is like teh row below the title
        gr.insets = new Insets(0, 0, 0, 0);
        add(button, gr);

        // moving over to the gamepage
        button.addActionListener(e -> {
            // place holder i had earlier
            // JOptionPane.showMessageDialog(this, "Game Loading...");
            thing.showScreen("gamepg");
        });

        // below was the stuff i did that made a new jframe - i referenced it when writing what is above but i basically rewrote it to work with jeopardy.java
        
        // JFrame frame = new JFrame();
        // frame.setBackground(new Color(10, 10, 50));

        // // adding in the button that enters the game
        // JButton button = new JButton("enter");
        // // x: (1500-width)/2
        // button.setBounds(650, 600, 200, 50);
        // button.setFont(new Font("Verdana", Font.PLAIN, 20));
        // button.setBackground(new Color(255, 200, 0));
        // frame.add(button);

        // // adding in the welcome stuff + CENTERED STUFF
        // JLabel welcome = new JLabel("welcome to jeopardy!", SwingConstants.CENTER);
        // welcome.setBounds(400, 200, 700, 200);
        // welcome.setFont(new Font("Verdana", Font.BOLD, 50));
        // welcome.setForeground(Color.WHITE);
        // frame.add(welcome);

        // // the frame stuff
        // frame.setSize(1500, 900);
        // frame.setLayout(null);

        // // visible now
        // frame.setVisible(true);
        // // go over to game page
    }
}
