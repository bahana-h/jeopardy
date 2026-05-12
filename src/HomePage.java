import java.io.*;
import javax.swing.*;
import java.awt.Font;

// source: https://www.geeksforgeeks.org/java/introduction-to-java-swing/

// TODO: - CHOOSE PLAYER VS PLAYR OR PLAYER VS COMPUTER

public class HomePage {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // changing font
        Font title = new Font("Cantarell", Font.BOLD, 50);

        // adding in the button that enters the game
        JButton button = new JButton("enter");
        // x: (1500-width)/2
        button.setBounds(650, 600, 200, 50);
        frame.add(button);

        // adding in the welcome stuff + CENTERED STUFF
        JLabel welcome = new JLabel("welcome to jeopardy!", SwingConstants.CENTER);
        welcome.setBounds(400, 200, 700, 200);
        welcome.setFont(title);
        frame.add(welcome);

        // the frame stuff
        frame.setSize(1500, 900);
        frame.setLayout(null);

        // visible now
        frame.setVisible(true);
    }
}
