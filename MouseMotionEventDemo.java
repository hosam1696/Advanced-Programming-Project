import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MouseMotionEventDemo extends JFrame implements MouseMotionListener,Runnable {
//    GameScreen gameScreen;
    public static int event_x;
    public static int event_y;
    public static boolean isDragged;
    public static Spaceship spaceship;
    public static JFrame gameFrame;
    public void run() {
        createAndShowGUI();
    }
    private void createAndShowGUI() {
        //Create and set up the window.
//        GameScreen gameScreen = new GameScreen();
        JFrame gameFrame = new JFrame("Chicken Invaders");
        this.gameFrame = gameFrame;
        gameFrame.addMouseMotionListener(this);
//        gameFrame.addMouseListener((MouseListener) this);
        JLabel backgroundLabel = new JLabel();
        JLabel spaceshipLabel = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        Component component = gameFrame.getContentPane();
//        Spaceship spaceship;
        boolean isDragging;
        boolean isPressed;
        boolean firstTime = true;
        boolean firstTimeP = true;

        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");


        gameFrame.setSize(2000, 1500);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(layout);
        gameFrame.setVisible(true);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gameFrame.add(backgroundLabel, gbc);
        backgroundLabel.setIcon(new ImageIcon("C:\\Users\\Amin\\IdeaProjects\\ChickenInvaders\\src\\tenor1.gif"));

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundLabel.add(spaceshipLabel, gbc);
        spaceshipLabel.setIcon(new ImageIcon("C:\\Users\\Amin\\IdeaProjects\\ChickenInvaders\\src\\Spaceship.png"));

        gameFrame.validate();
        gameFrame.repaint();
        gameFrame.setVisible(true);
        this.spaceship = new Spaceship(gameFrame.getContentPane(), spaceshipLabel);
//        Gun gun = new Gun(gameFrame.getContentPane(), spaceshipLabel);

        component.setCursor(blankCursor);
        gameFrame.validate();
        gameFrame.repaint();
        gameFrame.setVisible(true);

    }

    public MouseMotionEventDemo() {
//        GameScreen gameScreen = new GameScreen();
        //Register for mouse events on blankArea and panel.
//        .addMouseMotionListener(this);
//        addMouseMotionListener(this);

    }

    void eventOutput(String eventDescription, MouseEvent e) {
        if (eventDescription.equals("Mouse moved")){
            event_x = e.getX();
            event_y = e.getY();
        }
        if (eventDescription.equals("Mouse dragged")){
            event_x = e.getX();
            event_y = e.getY();
            isDragged = true;
            Gun.singleShot(event_x, event_y, gameFrame.getContentPane(), Gun.damage);

        }
        if (eventDescription.equals("Mouse released")){
            Gun.interruptShooting();
        }
//        System.out.println(eventDescription
//                + " (" + e.getX() + "," + e.getY() + ")"
//                + " detected on "
//                + e.getComponent().getClass().getName());
    }

    public void mouseMoved(MouseEvent e) {
        eventOutput("Mouse moved", e);
    }

    public void mouseDragged(MouseEvent e) {
        eventOutput("Mouse dragged", e);
    }
    public void mouseReleased(MouseEvent e){
        eventOutput("Mouse released", e);
    }
}