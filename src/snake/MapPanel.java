/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Graphics;
/**
 *
 * @author nezharen
 */
public class MapPanel extends javax.swing.JPanel{
    public MapPanel(Ground ground, Snake snake, Food food) {
        this.ground = ground;
        this.snake = snake;
        this.food = food;
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        this.ground.draw(g);
        this.snake.draw(g);
        this.food.draw(g);
    }
    
    private Snake snake;
    private Ground ground;
    private Food food;
}
