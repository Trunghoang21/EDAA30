package mountain;

import java.util.HashMap;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class bergfraktal extends Fractal{
    private Point a;
    private Point b;
    private Point c;
    private int dev;
    private HashMap<Side, Point> map; 
    
    
    public bergfraktal(Point a, Point b, Point c, int dev){
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.dev = dev;
        this.map = new HashMap<Side,Point>();
    }
    
    public String getTitle(){
        return "Mountain drawing";
    }

    public void draw (TurtleGraphics turtle){
        
        triangelDraw2(turtle, order, a, b, c, dev);
    }
    private void triangelDraw(TurtleGraphics turtle, int order, Point a, Point b, Point c,int dev){
        Point mid_ab = new Point(Math.abs(a.getX() + b.getX())/2, (int)(Math.abs( a.getY() + b.getY())/2 + RandomUtilities.randFunc(dev)));
        Point mid_ac = new Point(Math.abs(a.getX() + c.getX())/2,(int)(Math.abs( a.getY() + c.getY())/2 + RandomUtilities.randFunc(dev)));
        Point mid_bc = new Point(Math.abs(b.getX() + c.getX())/2,(int)(Math.abs( b.getY() + c.getY())/2 + RandomUtilities.randFunc(dev)));
        //this.dev/=2;
        if (order == 0){
            turtle.moveTo(a.getX(), a.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
        }
        else{
            triangelDraw(turtle, order-1, a, mid_ab, mid_ac, dev/2);
            triangelDraw(turtle, order-1, mid_ab, b, mid_bc, dev/2);
            triangelDraw(turtle, order-1, mid_ac, mid_bc, c, dev/2);
            triangelDraw(turtle, order-1, mid_ac, mid_ab, mid_bc, dev/2);
        } 

    }
    private void triangelDraw2(TurtleGraphics turtle, int order, Point a, Point b, Point c,int dev){
      /*  
        Side ab = new Side(a, b);
        Point mid_ab = new Point(Math.abs(a.getX() + b.getX())/2, (int)(Math.abs( a.getY() + b.getY())/2 + RandomUtilities.randFunc(dev)));
        if (!map.containsKey(ab)) 
            {
                System.out.println( "contains ab: " + dev);
                map.put(ab, mid_ab);
                
            }
        
        Side ac = new Side(a, c);
        Point mid_ac = new Point(Math.abs(a.getX() + c.getX())/2,(int)(Math.abs( a.getY() + c.getY())/2 + RandomUtilities.randFunc(dev)));
        if (!map.containsKey(ac)) 
            {
                System.out.println( "contains ab: " + dev);
                map.put(ac, mid_ac);
            }

        Side bc = new Side(b, c);
        Point mid_bc = new Point(Math.abs(b.getX() + c.getX())/2,(int)(Math.abs( b.getY() + c.getY())/2 + RandomUtilities.randFunc(dev)));
        if (!map.containsKey(bc)) 
            {
                System.out.println( "contains ab: " + dev);
                map.put(bc, mid_bc);
            }
            */ 
        //this.dev/=2;

        if (order == 0){
            turtle.moveTo(a.getX(), a.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
        }

        else{
            Point mid_ab = getMidPoint(a, b, dev);
            Point mid_ac = getMidPoint(a, c, dev);
            Point mid_bc = getMidPoint(b, c, dev);
            triangelDraw2(turtle, order-1, a, mid_ab , mid_ac, dev/2);
            triangelDraw2(turtle, order-1, mid_ab, b, mid_bc, dev/2);
            triangelDraw2(turtle, order-1, mid_ac, mid_bc, c, dev/2);
            triangelDraw2(turtle, order-1, mid_ac, mid_ab, mid_bc, dev/2);
        } 

    }
    private Point getMidPoint(Point a, Point b, int dev){
        Side ab = new Side(a,b);
        if (map.containsKey(ab)){
            Point result = map.get(ab);
            map.remove(ab);
            return result;
        }else{
            Point mid = new Point(Math.abs(a.getX() + b.getX())/2, (int)(Math.abs( a.getY() + b.getY())/2 + RandomUtilities.randFunc(dev)));
            map.put(ab,mid);
            return mid;
        }
        
    }
    
}
