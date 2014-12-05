/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
/**
 *
 * @author nezharen
 */
public class Food {
    public Food(boolean map[][]) {
        Random rm = new Random();
        int tx, ty;
        
        while (true) {
            tx = rm.nextInt(21) + 1;
            ty = rm.nextInt(21) + 1;
            if (!map[tx][ty]) {
                body.setPoint(tx, ty);
                break;
            }
        }
    }
    
    public void newFood(boolean map[][]) {
        Random rm = new Random();
        int tx, ty;
        
        while (true) {
            tx = rm.nextInt(21) + 1;
            ty = rm.nextInt(21) + 1;
            if (!map[tx][ty]) {
                body.setPoint(tx, ty);
                break;
            }
        }
    }
    
    public boolean isPoint(Point x) {
        if (body.x == x.x && body.y == x.y)
            return true;
        return false;
    }
    
    public void draw(Graphics g) {
        g.setColor(FOOD_COLOR);
        g.fillRect(body.x * Snake.BODY_SIZE, body.y * Snake.BODY_SIZE, Snake.BODY_SIZE, Snake.BODY_SIZE);
    }
    
    private Point body = new Point();
    public static final Color FOOD_COLOR = new Color(255, 0, 0);
}
