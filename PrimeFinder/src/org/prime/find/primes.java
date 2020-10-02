package org.prime.find;

import java.text.DecimalFormat;

public class primes {

	public static void main(String[] args) {
		double currentPrime = 1;
		System.out.println("hello");
		mainLoop :
			//this houses the number we are checking for primeness
		for(double i = Math.floor(Double.MAX_VALUE); i  > 0.0; i++){
			firstInside :
				//this produces values that are prime and checks them vs our candidate prime
			for(double c = 1.0; c < Math.floor(Math.floor(Double.MAX_VALUE)/2); c++){
				//if(c % 2.0 == 0){
					//continue;
				//}
				//this makes sure the previous loops has prime values
				for(double r = 2.0; r < c; r++){
					if(c % r == 0){
						continue firstInside;
					}
				}
				//if a value is prime, it is compared to the value we are checking 
				if(i % c == 0){System.out.println(c);}
				System.out.printf("%.1f", Double.MAX_VALUE);
				String alex = Double.toHexString(Double.MAX_VALUE);
				System.out.println(alex);
				alex = String.format("%.1f", Double.MAX_VALUE);
				char[] alPal = alex.toCharArray();
				for(int t = 0; t < alPal.length-1; t++){
					System.out.print(alPal[t]);
				}
				Double x = 2.0;
				String aelx;
				for(double v = 0; v < 1023; v++){
					x *= 2.0;
					aelx = String.format("%.16f", x);
					System.out.println(aelx);
				}
				DecimalFormat df = new DecimalFormat("####################################################################################################################################################################################################################################################################################################################################################################.#################################################################################");
				System.out.println(df.format(Double.MAX_VALUE));
				System.out.println(Double.MAX_VALUE);
				System.exit(0);
			}
			if(i > currentPrime){
				currentPrime = i;
			}
			System.out.println(i);
			
		}

	}

}
