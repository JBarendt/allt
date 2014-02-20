package testqueue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;

public class TestAppendFifoQueue {

	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<String> myStringQueue;

	@Before
	public void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myIntQueue = null;
	}

	@Test
	public final void TestAppendTwoEmptyQueue() {
		FifoQueue<Integer> q = new FifoQueue<Integer>();
		
		myIntQueue.append(q);
		assertEquals("Wrong size after apprend empty queue", 0, myIntQueue.size());
		
		assertEquals("Appended q not empty", 0, q.size());
	}
	
	@Test
	public final void TestAppendEmptyQueueToNonEmpty() {
		FifoQueue<Integer> q = new FifoQueue<Integer>();
		
		myIntQueue.offer(1);
		myIntQueue.append(q);
		assertEquals("Wrong size after addind empty to non empty q", 1, myIntQueue.size());
		
		assertEquals("Appended q not empty", 0, q.size());
	}
	
	@Test
	public final void TestAppendNonEmptyQueueToEmpty() {
		FifoQueue<Integer> q = new FifoQueue<Integer>();
		q.offer(1);
		
		myIntQueue.append(q);
		assertEquals("Wrong size after addind non empty to empty q", 1, myIntQueue.size());
		
		assertEquals("Appended q not empty", 0, q.size());
	}

	
	@Test
	public final void TestAppendNonEmptyQueue() {
		FifoQueue<Integer> q = new FifoQueue<Integer>();
		q.offer(1);
	
		myIntQueue.offer(2);
		myIntQueue.append(q);
		assertEquals("Wrong size after addind empty to non empty q", 2, myIntQueue.size());
		
		assertEquals("Appended q not empty", 0, q.size());
	}
}
