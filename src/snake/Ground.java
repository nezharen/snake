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
public class Ground {
    public Ground(boolean map[][]) {
        for (int i = 0; i <= MAP_LENGTH; i++) {
            map[i][0] = true;
            map[i][MAP_LENGTH] = true;
            map[0][i] = true;
            map[MAP_LENGTH][i] = true;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        for (int i = 0; i <= MAP_LENGTH; i++) {
            g.fillRect(i * Snake.BODY_SIZE, 0, Snake.BODY_SIZE, Snake.BODY_SIZE);
            g.fillRect(i * Snake.BODY_SIZE, MAP_LENGTH * Snake.BODY_SIZE, Snake.BODY_SIZE, Snake.BODY_SIZE);
        }
        for (int i = 1; i < MAP_LENGTH; i++) {
            g.fillRect(0, i * Snake.BODY_SIZE, Snake.BODY_SIZE, Snake.BODY_SIZE);
            g.fillRect(MAP_LENGTH * Snake.BODY_SIZE, i * Snake.BODY_SIZE, Snake.BODY_SIZE, Snake.BODY_SIZE);
        }
    }
    
    public static final Color color = new Color(0, 255, 0);
    public static final short MAP_LENGTH = 22;
}
