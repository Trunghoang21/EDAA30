package mountain;

import java.util.HashMap;

public class test1 {
    public static void main(String[] args) {
        HashMap<Side, Integer> map = new HashMap<>();
        Point p1 = new Point(100, 100);
        Point p2 = new Point(200, 200);
        Side s = new Side(p1, p2);
        map.put(s, 12);
        Side s2 = new Side(p2,p1);
        System.out.println(map.containsKey(s2));
        System.out.println(map.get(s2));
    }
}
