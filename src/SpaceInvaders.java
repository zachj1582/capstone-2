import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

public class SpaceInvaders extends JFrame implements Runnable {

    public static int WIDTH = 600;
    public static int HEIGHT = 400;

    private int gameSpeed = 100;

    AlienArmy army = null;

    Ship ship = null;

    private boolean paused = false;

    private int score = 0:

    Graphics offscreen_high;
    BufferedImage offscreen;

    Image backGroundImage = null;
    Image alienImage = null;

    public SpaceInvaders(String frameTitle) {
        super(frameTitle);


        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        backGroundImage = new javax.swing.ImageIcon("back3.jpg").getImage();

        alienImage = new javax.swing.ImageIcon("alien.jpg").getImage();

        ship = new Ship(this);

        army = new AlienArmy(ship, this, alienImage);

        addMouseListener(ship);

        addMouseMotionListener(ship);

        offscreen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        offscreen_high = offscreen.createGraphics();

        setBackground(Color.black);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        startGame();
    }

    public void pauseGame(boolean state) {
        paused = state;
    }

    public void hitAlienScore(){
        score += 5;
        System.out.println("Current Score: " + score);
    }

    public void shotShip(){
        score -= 20;
        System.out.println("Current Score: " + score);
    }

    public void startGame(){
        Thread thread = new Thread(this);
        thread.start();
    }

    public void update(Graphics g){
        paint(g);
    }

    public void moveAliens(){
        army.moveArmy();
    }

    public void run(){
        int count = 0;
        while(true) {
            try {
                Thread.sleep(gameSpeed);
            } catch(InterruptedException ie) {

            }
            if(!paused){
                if (count >= 5){
                    moveAliens();
                    count = 0;
                }
            }
            repaint();
            count++;
        }
    }

    public AlienArmy getAlienArmy() {
        return army;
    }

    public static void main(String[] args){
        SpaceInvaders invaders = new SpaceInvaders("Space Invaders");
    }
}
