package model;

//Verifies if certain number is prime or not
public class Verifyer {
	private int number;
	private boolean isPrime;
	public Verifyer(int n) {
		number = n;
		isPrime = isPrime(number);
	}
	
	private boolean isPrime(int n) {
		if (n%2==0) {
			return false;
		}
	    
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public boolean getIfPrime() {
		return isPrime;
	}
}
