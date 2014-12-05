/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Component;
/**
 *
 * @author nezharen
 */
public class GameThread extends Thread{
    public GameThread(boolean[][] map, Snake snake, Food food, Component component) {
        this.map = map;
        this.snake = snake;
        this.food = food;
        this.component = component;
    }
    
    public void run() {
        while (!snake.isDead()) {
            snake.forward(map, food);
            component.repaint();
            try {
                Thread.sleep(Snake.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private boolean[][] map;
    private Snake snake;
    private Food food;
    private Component component;
}
