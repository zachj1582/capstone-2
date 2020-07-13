package spaceinvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Screen implements ActionListener, IGameChanged {
    private JPanel countdown = new JPanel();
    private JButton start = new JButton("Start Game");
    private JLabel name = new JLabel("Space Invaders");
    private boolean startScreen = true;
    private Timer timer;
    Graphics offscreen_high;
    BufferedImage offscreen;
    public static int WIDTH = 1000;
    public static int HEIGHT = 800;
    Image alienImage;
    private Game game;

    public Screen(Game game){
        this.game = game;
        timer = new Timer(1000, this::actionPerformed);
        countdown.add(name);
        countdown.add(start);
        offscreen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        offscreen_high = offscreen.createGraphics();
        alienImage = new ImageIcon("alien.jpg").getImage();
        game.addGameWatcher(this);

        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setBackground(Color.black);
        game.setSize(WIDTH, HEIGHT);
        game.setResizable(false);
        game.setVisible(true);

    }


    public void paint(Graphics g){
        offscreen_high.setColor(Color.black);
        offscreen_high.fillRect(0,0, WIDTH, HEIGHT);
        game.army.drawArmy(offscreen_high);
        game.ship.drawShip(offscreen_high);
        g.drawImage(offscreen, 0, 0, game);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       game.repaint();
    }

    @Override
    public void GameChanged(Game game) {

    }
}
