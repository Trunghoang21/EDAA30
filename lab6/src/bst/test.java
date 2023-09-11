package bst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bst.BinarySearchTree;
//import queue_delegate.FifoQueue;
//import queue_singlelinkedlist.FifoQueue;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Iterator;

public class test {
    private BinarySearchTree tree;
    private BinarySearchTree<String> tree2;
    @BeforeEach
	void setUp() {
		tree = new BinarySearchTree<>();
        tree2 = new BinarySearchTree<>((e1, e2) -> ((e2).compareTo(e1)));
	}

	@AfterEach
	void tearDown(){
		tree = null;
        tree2 = null;
	}

	/**
	 * Test if a newly created queue is empty.
	 */
	@Test
	void test_add_one() {
        tree.add(3);
        assertEquals(1, tree.height());
        //tree2.add("hello");
        assertEquals(0, tree2.height());
	}

   @Test
   void test_add_two(){
        tree.add(5);
        tree.add(2);
        assertEquals(2, tree.height());
        tree2.add("b");
        tree2.add("a");
        assertEquals(2, tree2.height());
    
   }

   @Test
   void test_size_and_add(){
        tree.add(5);
        tree.add(1);
        tree.add(6);
        tree.add(7);
        assertEquals(3, tree.height());
        assertEquals(4, tree.size());
   }

   @Test
   void clear_test(){
        tree.add(2);
        tree.clear();
        assertEquals(0, tree.size());
        tree.add(3);
        assertEquals(1, tree.size());
   }

   @Test
   void test_duplicate(){
        tree.add(2);
        tree.add(3);
        assertEquals(2, tree.size());
        assertFalse(tree.add(3));
        assertEquals(2, tree.size());
   }

}
