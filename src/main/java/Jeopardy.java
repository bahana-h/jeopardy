import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// color picker: https://www.rapidtables.com/web/color/RGB_Color.html
// sources: https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html

public class Jeopardy extends JFrame {
    // using cardlayout = one window and switch whats inside which is smoother and doesnt create a new window everytime
    private CardLayout overall = new CardLayout();
    // this holds all the pages
    private JPanel everything = new JPanel(overall);

    public Jeopardy() 
    {
        setTitle("Jeopardy");
        // this like closes the program completely when the x is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this is the whole screen
        setSize(1500, 900);

        // initializing the screens
        HomePage homepg = new HomePage(this);
        GamePage gamepg = new GamePage();

        // add this stuff to the jpanel with everything
        everything.add(homepg, "homepg");
        everything.add(gamepg, "gamepg");

        // add everything to the jframe
        add(everything);

        // then we have to make sure the homepage is displayed first
        overall.show(everything, "homepg");

        // make it visible heheh
        setVisible(true);
    }

    /**
     * Allows other classes to tell it to switch screens now
     * @param screen The name of the screen to show
     */
    public void showScreen(String screen) {
        overall.show(everything, screen);
    }

    // ok wait i searched this up and this can start the whole application
    public static void main(String[] args) {
        // this drops off a request to the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            // this actually makes the window
            new Jeopardy();
        });
    }
}
