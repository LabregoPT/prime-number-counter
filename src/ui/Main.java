package ui;

import java.util.Scanner;
import threads.VerifyingThread;


public class Main {
	public static void main(String[] a) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.print("How many threads do you want to use to count?: ");
		int amountThreads = Integer.parseInt(sc.nextLine());
		sc.close();
		VerifyingThread[] threads = new VerifyingThread[amountThreads];
		int intervals = 1000/threads.length;
		
		for (int i = 0; i < threads.length; i++) {
			VerifyingThread v = new VerifyingThread(i*intervals, (i+1)*intervals);
			threads[i] = v;
		}
		
		long init = System.currentTimeMillis();
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		int total = 0;
		for (int i = 0; i < threads.length; i++) {
			total += threads[i].getFound();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Total Prime numbers :" + total);
		System.out.println("Duration with "+amountThreads+" threads: "+ (double)(end-init)/1000 + "s");
	}
}
