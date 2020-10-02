package org.alex.attempt;

import org.main.std.StdDraw;

public class Attempt implements Runnable{

	private static double function(double x, double r){
		//System.out.println(x + " x");
		//return (x+r)*(r-x)/((r+(x*r))); -100 - 0 (almost normally distributed points with a pattern on the left 
		//return (x+r)*(r-x)/((r+(x*(r*-1))*x));  2 interceting lines, one function
		//return (x+r)*(r-x)/((r+(x*(r*-1))+(x/(r-1)))); -1 to 4. X(-4, 4) Y(-1, 4)
		return (x+r)/(r-x);
	}
	
	public Attempt(){
		int N = 100;
		StdDraw.setXscale(-4, 4);
		StdDraw.setYscale(-2, 4);
		double val = .53;
		MainLoop:
		for(double x = -2.0; x < 4.0; x += 0.1/N){
			if(x == 0.0){
				System.out.println(x);
				continue;
			}
			for(int i = 0; i < 1000; i++){
				val = function(val,x);
				if(Double.isNaN(val)){
					break MainLoop;
				}
				if(Double.isInfinite(val)){
					break;
				}
			}
			for(int c = 0; c < 100; c++){
				if(Double.isInfinite(val)){
					break;
				}
				System.out.println("Val: " + val + " r: " + x);
				val = function(val,x);
				StdDraw.point(val, x);
				StdDraw.show();
			}
		}
	}
	
	public void run(){}
}