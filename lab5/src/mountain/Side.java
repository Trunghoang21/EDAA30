package mountain;

public class Side {
    private Point p1;
    private Point p2;

    public Side(Point a, Point b){
        this.p1 = a;
        this.p2 = b;
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Side)){
            return false;
        }
        Side com = (Side)o;
        if((com.p1.equals(this.p1)) && (com.p2.equals(this.p2))) return true;
        if((com.p1.equals(this.p2)) && (com.p2.equals(this.p1))) return true;
       
        return false;
    }
    @Override
    public int hashCode(){
        return p1.hashCode() + p2.hashCode();
    }
    
}
