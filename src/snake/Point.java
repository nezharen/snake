/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author nezharen
 */
public class Point {
    public int x, y;
    
    public Point() {
        x = 0;
        y = 0;
    }
    
    public Point(int tx, int ty) {
        x = tx;
        y = ty;
    }
    
    public void setPoint(int tx, int ty) {
        x = tx;
        y = ty;
    }
}
