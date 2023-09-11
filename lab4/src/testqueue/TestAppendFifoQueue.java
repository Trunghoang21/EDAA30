package testqueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import queue_delegate.FifoQueue;
import queue_singlelinkedlist.FifoQueue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

public class TestAppendFifoQueue {
    
    private FifoQueue<Integer> list1;
	private FifoQueue<Integer> list2; 
    
    @BeforeEach
	void setUp() {
		list1 = new FifoQueue<Integer>();
		list2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown(){
		list1 = null;
		list2 = null;
	}

	/**
	 * Test if a newly created queue is empty.
	 */
	@Test
	void two_empty_list() {
        assertEquals(0, list2.size(), "Wrong size of empty queue");
        assertEquals(0, list1.size(), "Wrong size of empty queue");
        list1.append(list2);

		assertTrue(list1.isEmpty(), "Wrong result from empty of queue");
		assertTrue(list2.isEmpty(), "Wrong result from empty of queue");
		
	}

   @Test
   void an_empty_list_concatenated_to_nonEmptyList(){
    list1.offer(1);
    list1.offer(2);
    list1.append(list2);
    assertEquals(1, list1.poll(), "Wrong output");
    assertEquals(2, list1.poll(), "Wrong output");
    assertEquals(null, list1.poll(), "Wrong output");
    assertTrue(list2.isEmpty(), "Wrong result from empty of queue");
   }

   @Test
   void nonEmpty_list_concatenated_to_Empty_List(){
    list2.offer(1);
    list2.offer(2);
    list1.append(list2);
    assertEquals(1, list1.poll(), "Wrong output");
    assertEquals(2, list1.poll(), "Wrong output");
    assertEquals(null, list1.poll(), "Wrong output");
    assertTrue(list2.isEmpty(), "Wrong result from empty of queue");
   }

   @Test
   void nonEmpty_list_concatenated_to_nonEmpty_List(){
    list1.offer(1);
    list1.offer(2);
    list2.offer(11);
    list1.append(list2);
    assertEquals(1, list1.poll(), "Wrong output");
    assertEquals(2, list1.poll(), "Wrong output");
    assertEquals(11, list1.poll(), "Wrong output");
    assertEquals(null, list1.poll(), "Wrong output");
    assertTrue(list2.isEmpty(), "Wrong result from empty of queue");
   }

   @Test
   void two_identical_List(){
    list1.offer(1);
    assertThrows(IllegalArgumentException.class, ()->
                                                    {list1.append(list1);});
   }



}
