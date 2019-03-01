package threads;

import model.Verifyer;

public class VerifyingThread extends Thread {
	private int startPoint;
	private int endPoint;
	private int found;
	
	public VerifyingThread(int s, int e) {
		startPoint = s;
		endPoint = e;
		found = 0;
	}
	
	private void verify() {
		for (int i = startPoint; i < endPoint; i++) {
			Verifyer n = new Verifyer(i);
			if(n.getIfPrime()) {
				found++;
			}
		}
	}
	
	public int getFound() {
		return found;
	}
	
	@Override
	public void run() {
		verify();
	}
}
