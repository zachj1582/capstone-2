import java.awt.*;

public class AlienShot implements Runnable {

    private int shotSpeed = 10;
    private int SHOT_WIDTH = 2;
    private int SHOT_HEIGHT = 5;

    private int x = 0;

    private int shotHeight = 0;

    boolean shotState = true;

    Ship ship;

    public AlienShot(int x, int y, Ship ship){
        this.x = x;
        this.shotHeight = y;
        this.ship = ship;
        Thread thread = new Thread(this);
        thread.start();
    }

    private boolean moveShot(){
        if(ship.checkShot(x, shotHeight)){
            System.out.println("We're hit Captain!");
            ship.hitByAlien();
            shotState = false;
            return true;
        }
        shotHeight += 2;
        if(shotHeight > SpaceInvaders.HEIGHT){
            shotState = false;
            return true;
        }
        return false;
    }

    public void drawShot(Graphics g){
        if(shotState){
            g.setColor(Color.green);
        } else {
            g.setColor(Color.black);
        }
        g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
    }

    public boolean getShotState(){
        return shotState;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(shotSpeed);
            } catch(InterruptedException ie){

            }
            if(moveShot()) {
                break;
            }
        }
    }


}
