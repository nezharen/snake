/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Graphics;
import java.awt.Color;
/**
 *
 * @author nezharen
 */
public class Snake {
    public Snake(boolean map[][]) {
        head = 2;
        tail = 0;
        direction = RIGHT_DIRECTION;
        for (int i = 0; i < LENGTH_MAX; i++)
            body[i] = new Point();
        body[0].setPoint(1, 1);
        body[1].setPoint(2, 1);
        body[2].setPoint(3, 1);
        map[1][1] = true;
        map[2][1] = true;
        map[3][1] = true;
    }
    
    public void setDirection(int direction) {
        if (dead) {
            return;
        }
        switch (direction) {
            case UP_DIRECTION:
                if (this.direction == LEFT_DIRECTION || this.direction == RIGHT_DIRECTION)
                    this.direction = UP_DIRECTION;
                break;
            case DOWN_DIRECTION:
                if (this.direction == LEFT_DIRECTION || this.direction == RIGHT_DIRECTION)
                    this.direction = DOWN_DIRECTION;
                break;
            case LEFT_DIRECTION:
                if (this.direction == UP_DIRECTION || this.direction == DOWN_DIRECTION)
                    this.direction = LEFT_DIRECTION;
                break;
            case RIGHT_DIRECTION:
                if (this.direction == UP_DIRECTION || this.direction == DOWN_DIRECTION)
                    this.direction = RIGHT_DIRECTION;
                break;
        }
    }
    
    public void forward(boolean map[][], Food food) {
        int thead = (int)((head + 1) % LENGTH_MAX);
        
        if (dead) {
            return;
        }
        map[body[tail].x][body[tail].y] = false;
        switch (direction) {
            case UP_DIRECTION:
                if (map[body[head].x][body[head].y - 1]) {
                    dead = true;
                    return;
                }
                body[thead].setPoint(body[head].x, body[head].y - 1);
                map[body[thead].x][body[thead].y] = true;
                break;
                
            case DOWN_DIRECTION:
                if (map[body[head].x][body[head].y + 1]) {
                    dead = true;
                    return;
                }
                body[thead].setPoint(body[head].x, body[head].y + 1);
                map[body[thead].x][body[thead].y] = true;
                break;
                
            case LEFT_DIRECTION:
                if (map[body[head].x - 1][body[head].y]) {
                    dead = true;
                    return;
                }
                body[thead].setPoint(body[head].x - 1, body[head].y);
                map[body[thead].x][body[thead].y] = true;
                break;
                
            case RIGHT_DIRECTION:
                if (map[body[head].x + 1][body[head].y]) {
                    dead = true;
                    return;
                }
                body[thead].setPoint(body[head].x + 1, body[head].y);
                map[body[thead].x][body[thead].y] = true;
                break;
        }
        head = thead;
        if (food.isPoint(body[head])) {
            map[body[tail].x][body[tail].y] = true;
            food.newFood(map);
        }
        else
            tail = (int)((tail + 1) % LENGTH_MAX);
    }
    
    public boolean isDead() {
        return(dead);
    }
    
    public void draw(Graphics g) {
        g.setColor(BODY_COLOR);
        for (int i = tail; i != head; i = (i + 1) % LENGTH_MAX) {
            g.fillRect(body[i].x * BODY_SIZE, body[i].y * BODY_SIZE, BODY_SIZE, BODY_SIZE);
        }
        g.setColor(HEAD_COLOR);
        g.fillRect(body[head].x * BODY_SIZE, body[head].y * BODY_SIZE, BODY_SIZE, BODY_SIZE);
    }
    
    private Point body[]= new Point[LENGTH_MAX];
    private int head, tail, direction;
    private boolean dead = false;
    public static final int LENGTH_MAX = 450;
    public static final int UP_DIRECTION = 1;
    public static final int DOWN_DIRECTION = 2;
    public static final int LEFT_DIRECTION = 3;
    public static final int RIGHT_DIRECTION = 4;
    public static final int BODY_SIZE = 20;
    public static final Color HEAD_COLOR = new Color(0, 0, 255);
    public static final Color BODY_COLOR = new Color(50, 50, 255);
    public static final int SLEEP_TIME = 250;
}
