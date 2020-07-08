import java.awt.*;

public class Shot implements Runnable {

    private int shotSpeed = 10;

    private int SHOT_WIDTH = 2;
    private int SHOT_HEIGHT = 5;

    private int x = 0;

    private int shotHeight = 0;

    boolean shotState = true;

    AlienArmy alienArmy = null;

    public Shot(int x, int y, AlienArmy alienArmy){
        this.x = x;
        this.shotHeight = y;
        this.alienArmy = alienArmy;
        Thread thread = new Thread(this);
        thread.start();
    }

    private boolean moveShot(){
        if(alienArmy.checkShot(x, shotHeight)){
            System.out.println("Direct hit Captain!");
            shotState = false;
            return true;
        }
        shotHeight -= 2;

        if(shotHeight < 0){
            shotState = false;
            return true;
        }
        return false;
    }

    public void drawShot(Graphics g){
        if (shotState){
            g.setColor(Color.white);
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
            if(moveShot()){
                break;
            }
        }
    }
}
