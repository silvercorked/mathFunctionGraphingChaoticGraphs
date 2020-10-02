package org.alex.attempt;

import java.util.Random;

import org.main.std.StdDraw;

public class AttemptMore implements Runnable{

	private static double function(double x, double r, double random){
		//System.out.println(x + " x");
		//return (x+r)*(r-x)/((r+(x*r))); -100 - 0 (almost normally distributed points with a pattern on the left 
		//return (x+r)*(r-x)/((r+(x*(r*-1))*x));  2 interceting lines, one function
		//return (x+r)*(r-x)/((r+(x*(r*-1))+(x/(r-1)))); -1 to 4. X(-4, 4) Y(-1, 4)
		return ((x+r)/(r-x))*(random/r);
	}
	
	public AttemptMore(){
		int N = 1000;
		StdDraw.setXscale(-2, 2);
		StdDraw.setYscale(-1.2, 0.8);
		double val = .53;
		Random rand = new Random();
		MainLoop:
		for(double x = -1.2; x < 0.8; x += 0.1/N){
			for(int i = 0; i < 1000; i++){
				val = function(x,val, rand.nextDouble());
			}
			for(int c = 0; c < 100; c++){
				System.out.println("Val: " + val + " r: " + x);
				val = function(x,val, rand.nextDouble());
				StdDraw.point(val, x);
				StdDraw.show();
			}
		}
	}
	
	public void run(){}
}