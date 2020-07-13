package spaceinvaders;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;


public class Game extends JFrame implements Runnable, MouseListener, MouseMotionListener, KeyListener {



    private int gameSpeed = 100;
    private boolean isRunning = true;
    public AlienArmy army;
    public Ship ship;

    private int x;

    private boolean paused = false;

    private int score = 0;

    private HashSet<IGameChanged> watchers = new HashSet<>();

    Image backGroundImage;

    public Game(String frameTitle) {
        super(frameTitle);


        backGroundImage = new ImageIcon("blackhole_small.jpg").getImage();
        ship = new Ship(this);
        army = new AlienArmy(ship, this);

        addMouseListener(this);

        addMouseMotionListener(this);

        startGame();
    }

    public void addGameWatcher(IGameChanged gameChanged){
        watchers.add(gameChanged);
    }

    public void removedGameWatcher(IGameChanged gameChanged){
        watchers.remove(gameChanged);
    }

    public void notifyGameChanged(){
        watchers.forEach(watcher -> watcher.GameChanged(this));
    }

    public void pauseGame(boolean state) {
        this.paused = state;
    }

    public boolean isRunning(){
        return isRunning;
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

//    public void paint(Graphics g){
//        offscreen_high.setColor(Color.black);
//        offscreen_high.fillRect(0,0, WIDTH, HEIGHT);
//        army.drawArmy(offscreen_high);
//        ship.drawShip(offscreen_high);
//        g.drawImage(offscreen, 0, 0, this);
//    }

    public void update(Graphics g){
        paint(g);
    }

    public void moveAliens(){
        army.moveArmy();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent mouseEvent){
        int newX = mouseEvent.getX();
        if(newX > (WIDTH - Ship.SHIP_WIDTH - 10)){
            x = WIDTH - Ship.SHIP_WIDTH - 10;
        } else {
            x = newX;
        }
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        pauseGame(false);
    }

    public void mouseExited(MouseEvent mouseEvent){
        pauseGame(true);
    }



    public void mousePressed(MouseEvent mouseEvent){

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent mouseEvent){
        AlienArmy army = getAlienArmy();
        ShipShot shipShot = new ShipShot(ship.getX() + (int) (Ship.SHIP_WIDTH / 2), ship.getHeightPosition());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            AlienArmy army = getAlienArmy();
            ShipShot shipShot = new ShipShot(x + (int)(ship.SHIP_WIDTH/2), ship.getHeightPosition());
        }
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
