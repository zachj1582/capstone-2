package spaceinvaders;

import spaceinvaders.Alien;

import java.awt.*;
import java.util.*;

public class AlienArmy {

    Alien rowOne[] = new Alien[10];
    Alien rowTwo[] = new Alien[10];
    Alien rowThree[] = new Alien[10];

    boolean movingRight = true;
    int moveDistance = 15;
    Vector alienShots = new Vector();
    private Ship ship;
    private SpaceInvaders spaceInvaders;
    Image alien;

    public AlienArmy(Ship ship, SpaceInvaders spaceInvaders, Image alien) {
        this.ship = ship;
        this.spaceInvaders = spaceInvaders;
        this.alien = alien;

        createArmy();
        setStartingPosition();
    }

    private void createArmy() {
        for (int i = 0; i < 10; i++) {
            rowOne[i] = new Alien(alien, spaceInvaders);
            rowTwo[i] = new Alien(alien, spaceInvaders);
            rowThree[i] = new Alien(alien, spaceInvaders);
        }
    }

    private void setStartingPosition() {
        int rowHeight = 50;
        int leftStart = 50;
        for (int i = 0; i < 10; i++) {
            rowOne[i].setPosition(leftStart, rowHeight);
            leftStart += 40;
        }

        rowHeight += 50;
        leftStart = 50;
        for (int i = 0; i < 10; i++) {
            rowTwo[i].setPosition(leftStart, rowHeight);
            leftStart += 40;
        }

        rowHeight += 50;
        leftStart = 50;
        for (int i = 0; i < 10; i++) {
            rowThree[i].setPosition(leftStart, rowHeight);
            leftStart += 40;
        }
    }


    public void moveArmy() {
        if (movingRight) {
            for (int i = 9; i >= 0; i--) {

                if (!rowOne[i].isHit()) {

                    if (rowOne[i].getLeftPosition() > (SpaceInvaders.WIDTH - Alien.ALIEN_WIDTH - 15)) {
                        movingRight = false;

                        for (int o = 0; o < 10; o++) {
                            rowOne[o].setPosition(rowOne[o].getLeftPosition(),
                                    rowOne[o].getHeightPosition() + moveDistance);
                            rowTwo[o].setPosition(rowTwo[o].getLeftPosition(),
                                    rowTwo[o].getHeightPosition() + moveDistance);
                            rowThree[o].setPosition(rowThree[o].getLeftPosition(),
                                    rowThree[o].getHeightPosition() + moveDistance);
                        }
                        return;
                    }
                }

                if (!rowTwo[i].isHit()) {
                    if (rowTwo[i].getLeftPosition() > (SpaceInvaders.WIDTH - Alien.ALIEN_WIDTH - 15)) {
                        movingRight = false;

                        for (int o = 0; o < 10; o++) {
                            rowOne[o].setPosition(rowOne[o].getLeftPosition(),
                                    rowOne[o].getHeightPosition() + moveDistance);
                            rowTwo[o].setPosition(rowTwo[o].getLeftPosition(),
                                    rowTwo[o].getHeightPosition() + moveDistance);
                            rowThree[o].setPosition(rowThree[o].getLeftPosition(),
                                    rowThree[o].getHeightPosition() + moveDistance);
                        }
                        return;
                    }
                }

                if (!rowThree[i].isHit()) {
                    if (rowThree[i].getLeftPosition() > (SpaceInvaders.WIDTH - Alien.ALIEN_WIDTH - 15)) {
                        movingRight = false;

                        for (int o = 0; o < 10; o++) {
                            rowOne[o].setPosition(rowOne[o].getLeftPosition(),
                                    rowOne[o].getHeightPosition() + moveDistance);
                            rowTwo[o].setPosition(rowTwo[o].getLeftPosition(),
                                    rowTwo[o].getHeightPosition() + moveDistance);
                            rowThree[o].setPosition(rowThree[o].getLeftPosition(),
                                    rowThree[o].getHeightPosition() + moveDistance);
                        }
                        return;
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                rowOne[i].setPosition(rowOne[i].getLeftPosition() + moveDistance, rowOne[i].getHeightPosition());
                rowTwo[i].setPosition(rowTwo[i].getLeftPosition() + moveDistance, rowTwo[i].getHeightPosition());
                rowThree[i].setPosition(rowThree[i].getLeftPosition() + moveDistance, rowThree[i].getHeightPosition());
            }

        } else {
            for (int i = 0; i < 10; i++) {

                if (rowOne[i].isHit()) {
                    if (rowOne[i].getLeftPosition() < Alien.ALIEN_WIDTH) {
                        movingRight = true;

                        for (int o = 0; o < 10; o++) {
                            rowOne[o].setPosition(rowOne[o].getLeftPosition(),
                                    rowOne[o].getHeightPosition() + moveDistance);
                            rowTwo[o].setPosition(rowTwo[o].getLeftPosition(),
                                    rowTwo[o].getHeightPosition() + moveDistance);
                            rowThree[o].setPosition(rowThree[o].getLeftPosition(),
                                    rowThree[o].getHeightPosition() + moveDistance);
                        }
                    }
                }

                if (rowTwo[i].isHit()) {
                    if (rowTwo[i].getLeftPosition() < Alien.ALIEN_WIDTH) {
                        movingRight = true;

                        for (int o = 0; o < 10; o++) {
                            rowOne[o].setPosition(rowOne[o].getLeftPosition(),
                                    rowOne[o].getHeightPosition() + moveDistance);
                            rowTwo[o].setPosition(rowTwo[o].getLeftPosition(),
                                    rowTwo[o].getHeightPosition() + moveDistance);
                            rowThree[o].setPosition(rowThree[o].getLeftPosition(),
                                    rowThree[o].getHeightPosition() + moveDistance);
                        }
                    }
                }

                if (rowThree[i].isHit()) {
                    if (rowThree[i].getLeftPosition() < Alien.ALIEN_WIDTH) {
                        movingRight = true;

                        for (int o = 0; o < 10; o++) {
                            rowOne[o].setPosition(rowOne[o].getLeftPosition(),
                                    rowOne[o].getHeightPosition() + moveDistance);
                            rowTwo[o].setPosition(rowTwo[o].getLeftPosition(),
                                    rowTwo[o].getHeightPosition() + moveDistance);
                            rowThree[o].setPosition(rowThree[o].getLeftPosition(),
                                    rowThree[o].getHeightPosition() + moveDistance);
                        }
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                rowOne[i].setPosition(rowOne[i].getLeftPosition() - moveDistance, rowOne[i].getHeightPosition());
                rowTwo[i].setPosition(rowTwo[i].getLeftPosition() - moveDistance, rowTwo[i].getHeightPosition());
                rowThree[i].setPosition(rowThree[i].getLeftPosition() - moveDistance, rowThree[i].getHeightPosition());
            }
        }

        Random generator = new Random();
        int random1 = generator.nextInt(10);
        int random2 = generator.nextInt(10);
        int random3 = generator.nextInt(10);
        if (!rowOne[random1].isHit()) {
            AlienShot as = new AlienShot(rowOne[random1].getLeftPosition() + (int) (Alien.ALIEN_WIDTH / 2),
                    rowOne[random1].getHeightPosition(), ship);
            alienShots.addElement(as);
        }
        if (!rowTwo[random2].isHit()) {
            AlienShot as = new AlienShot(rowTwo[random2].getLeftPosition() + (int) (Alien.ALIEN_WIDTH / 2),
                    rowTwo[random2].getHeightPosition(), ship);
            alienShots.addElement(as);
        }
        if (!rowThree[random3].isHit()) {
            AlienShot as = new AlienShot(rowThree[random3].getLeftPosition() + (int) (Alien.ALIEN_WIDTH / 2),
                    rowThree[random3].getHeightPosition(), ship);
            alienShots.addElement(as);
        }
    }

    public void drawArmy(Graphics g) {
        for (int i = 0; i < 10; i++) {
            rowOne[i].drawAlien(g);
            rowTwo[i].drawAlien(g);
            rowThree[i].drawAlien(g);
        }
        Vector temp = new Vector();
        for (int i = 0; i < alienShots.size(); i++) {
            AlienShot as = (AlienShot) alienShots.elementAt(i);
            if (as.getShotState()) {
                temp.addElement(as);
            }
            as.drawShot(g);
        }
        alienShots = temp;
    }

    public boolean checkShot(int x, int y) {
        for (int i = 0; i < 10; i++) {
            if (rowOne[i].hitAlien(x, y)) {
                spaceInvaders.hitAlienScore();
                return true;
            }
            if (rowTwo[i].hitAlien(x, y)) {
                spaceInvaders.hitAlienScore();
                return true;
            }
            if (rowThree[i].hitAlien(x, y)) {
                spaceInvaders.hitAlienScore();
                return true;
            }
        }
        return false;
    }

}
