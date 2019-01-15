
public class EvenOdd {

	volatile boolean isEven;
	int number;
	EvenOdd(int number, boolean isEven)
	{
		this.number = number;
		this.isEven = isEven;
	}
	
	public static void main(String[] args) 
	{
		EvenOdd eo = new EvenOdd(1, false);
		new Thread(() -> {
			for(int i=0;i<10;i++)
			eo.printEven();
		}).start();
		
		new Thread(() -> {
			for(int i=0;i<10;i++)
			eo.printOdd();
		}).start();
	}

	
	public synchronized void printEven()
	{
		while(!isEven)
		{
			try {
				wait();
			}
			catch(Exception e) {}
		}
		System.out.println("Even : "+number);
		isEven = !isEven; number++;
		notify();
	}
	
	public synchronized void printOdd()
	{
		while(isEven)
		{
			try {
				wait();
			}
			catch(Exception e) {}
		}
		System.out.println("Odd : "+number);
		isEven = !isEven; number++;
		notify();
	}
	
}
