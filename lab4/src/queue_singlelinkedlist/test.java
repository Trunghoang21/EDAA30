package queue_singlelinkedlist;

import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        FifoQueue<Integer> list = new FifoQueue<>();
        for(int i = 0; i < 5; i ++){
            list.add(i);
        }
        System.out.println("step 1 done");
        FifoQueue<Integer> list1 = new FifoQueue<>();
        for (int i = 10; i < 15;i ++){
            list1.offer(i);
        }
        System.out.println("step 2 done");
        list.append(list1);
        System.out.println("Step 3 done");
        System.out.println("Efter appending: " + list1.peek());
        for (Integer i : list){
            System.out.println("list is:" +i);
        }

    }
        
}
