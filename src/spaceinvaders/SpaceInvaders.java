package spaceinvaders;

import spaceinvaders.AlienArmy;
import spaceinvaders.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class SpaceInvaders extends JFrame implements Runnable {

    public static int WIDTH = 1000;
    public static int HEIGHT = 800;

    private int gameSpeed = 100;

    AlienArmy army;

    Ship ship;

    private boolean paused = false;

    private int score = 0;

    Graphics offscreen_high;
    BufferedImage offscreen;

    Image backGroundImage;
    Image alienImage;


    public SpaceInvaders(String frameTitle) {
        super(frameTitle);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        backGroundImage = new ImageIcon("blackhole_small.jpg").getImage();

        alienImage = new ImageIcon("alien.jpg").getImage();

        ship = new Ship(this);

        army = new AlienArmy(ship, this, alienImage);

        addMouseListener(ship);

        addMouseMotionListener(ship);

        offscreen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        offscreen_high = offscreen.createGraphics();

        setBackground(Color.black);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
        startGame();
    }

    public void pauseGame(boolean state) {
        this.paused = state;
    }

    public void hitAlienScore(){
        this.score += 5;
        System.out.println("Current Score: " + score);
    }

    public void shotShip(){
        this.score -= 20;
        System.out.println("Current Score: " + score);
    }

    public void startGame(){
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g){
        offscreen_high.setColor(Color.black);
        offscreen_high.fillRect(0,0, WIDTH, HEIGHT);
        army.drawArmy(offscreen_high);
        ship.drawShip(offscreen_high);
        g.drawImage(offscreen, 0, 0, this);
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


}
