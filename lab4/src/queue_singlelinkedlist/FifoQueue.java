package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> element = new QueueNode<E>(e);
		this.size ++;
		if (last == null){
			last = element;
			last.next = element;
		}else {
			element.next = last.next;
			last.next = element;
			last = element;
		}
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return this.size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (last == null ){
			return null;
		}
		return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		
		if (last == null){
			return null;
		}
		if (size == 1){
			QueueNode<E> temp = last;
			last = null;
			this.size--;
			return temp.element;	
		}
		else if (size > 1){
			this.size--;
			QueueNode<E> temp = last.next;
			last.next = last.next.next;
			return temp.element;
		}


		return null;
	}
	public QueueNode<E> getLast(){
		return last;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}


	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		
		/* Konstruktor */
		private QueueIterator() {
			if(last != null){
				pos = last.next;
				
			}
			
		}
		public boolean hasNext() {		
			if(pos == null)  {
				
				return false;
			}
			return true;
		}
		public E next() {
			if(hasNext()){
				QueueNode<E> temp = pos;
				pos = pos.next;
				if (pos == last.next){
					pos = null;
				}
				return temp.element;
			}
			else{
				throw new  NoSuchElementException();
			}
			
		}
	}
		
		public void append(FifoQueue<E> q){
			
			if (this == q){
				throw new IllegalArgumentException();
			}
			else{
				if(this.last == null){
					if(q.last == null){
						this.last = null;
					}
					else if( q.last != null){
						this.last = q.last;
						this.size += q.size;
						
					}
				} else{

					if(q.last != null){
					QueueNode<E> temp = this.last.next;
					// temp pekar mot den första element i listan
					this.last.next = q.last.next;
					//sista element i listan pekar mot den första element i q-listan
					q.last.next = temp;
					// sista element i q-listan perkar mot temp 
					this.last = q.last;
					// atribut last pekar mot sista element i q-listan
					this.size += q.size;
					//uppdateras attribut size i listan
					}
				}
				// nollställa attribut last, size i q-listan
				q.last = null;
				q.size = 0;
				
			}
			
			

		}
		

}
