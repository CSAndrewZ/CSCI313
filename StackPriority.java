public class StackPriority { 
	public static void main(String[] args) { 
		StackPQ<Integer> q = new StackPQ<>();
		q.push(3);
		q.push(4);
		q.push(2);
		
		q.push(1);
		System.out.println(q);
		while(!q.isEmpty()) {
			System.out.println(q.pop());
			System.out.println(q);
		}
	}
}

// NOTE: extends should go before implements
class StackPQ<V> extends SortedPriorityQueue<Integer,V> implements PriorityQueue<Integer,V> { 

	// Stack can implement a priority queue
	// by adding items and assigning keys 
	// based on order of insertion.
	// Keys should be a negative counter,
	// to keep them in reverse order added.
	int counter;

	/** Start with an empty stack. */
	public StackPQ(){ counter = 0; }

	// Stack ADT methods:
	public void push(V v) {
		counter++; // start at 1
		this.insert(new Integer(-1*counter), v);
	}

	public V pop() {
		counter--;
		return removeMin().getvalue();
	}

	// Can actually just use this.size()-1 instead of counter.
	// How do we communicate that insert, removeMin, peekMin, etc 
	// should probably not be used with this ADT? 
	// Don't sweat it. Just an exercise.
}
