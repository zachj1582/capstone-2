import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Ship implements MouseListener, MouseMotionListener {
    public static int SHIP_HEIGHT = 25;
    public static int SHIP_WIDTH = 15;

    private int x = 0;
    private int heightPosition = 0;

    SpaceInvaders spaceInvaders = null;

    Shot shot = null;

    boolean hitState = false;

    public Ship(SpaceInvaders spaceInvaders){
        this.spaceInvaders = spaceInvaders;
        this.x = (int)((SpaceInvaders.WIDTH/2) + (SHIP_WIDTH/2));
        this.heightPosition = SpaceInvaders.HEIGHT - SHIP_HEIGHT - 20;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent mouseEvent){
        int newX = mouseEvent.getX();
        if(newX > (SpaceInvaders.WIDTH - SHIP_WIDTH - 10)){
            x = SpaceInvaders.WIDTH - SHIP_WIDTH - 10;
        } else {
            x = newX;
        }
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        spaceInvaders.pauseGame(false);
    }

    public void mouseExited(MouseEvent mouseEvent){
        spaceInvaders.pauseGame(true);
    }



    public void mousePressed(MouseEvent mouseEvent){

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent mouseEvent){
        AlienArmy army = spaceInvaders.getAlienArmy();
        shot = new Shot(x + (int)(SHIP_WIDTH/2), heightPosition, army);
    }

    public void drawShip(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, heightPosition, SHIP_WIDTH, SHIP_HEIGHT);
        if((shot != null) && (shot.getShotState())){
            shot.drawShot(g);
        }
    }

    public boolean checkShot(int x, int y){
        if((x >= this.x) && (x <= (x + SHIP_WIDTH))){
            if((y >= heightPosition) && (y <= (heightPosition + SHIP_HEIGHT))) {
                hitState = true;
                return true;
            }
        }
        return false;
    }

    public void hitByAlien(){
        spaceInvaders.shotShip();
    }
}
