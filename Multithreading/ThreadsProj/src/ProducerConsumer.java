import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {

		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		new Producer(queue).start();
		new Consumer(queue).start();
	}

}

//the producer class ( used for putting values into the blocking queue )
class Producer extends Thread {
	ArrayBlockingQueue<String> queue;

	public Producer(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 100; i++)
			{
				Thread.sleep(100);
				queue.put(new Integer(i).toString());
				System.out.println("Producer: "+i);
			}
		} catch (Exception e) {
		}
	}
}

//the consumer class ( used for getting values from the blocking queue )
class Consumer extends Thread {
	ArrayBlockingQueue<String> queue;

	public Consumer(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			for (int i = 0; i < 100; i++)
			{	Thread.sleep(300);
				System.out.println("Consumer: "+queue.take());
			}
		} catch (Exception e) {
		}
	}
}