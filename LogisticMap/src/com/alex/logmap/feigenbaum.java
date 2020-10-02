package com.alex.logmap;

import java.util.Random;

import org.main.std.StdDraw;

public class feigenbaum implements Runnable{
	
	private Random rand;
	
	public feigenbaum(){
		rand = new Random();
		primary();
	}
	public void run(){}
	static double logistic(double y, double r){
		return r * y * (1.0 - y);
	}
	public void primary(){
		int N = 10;
		StdDraw.setCanvasSize(1200, 800);
		StdDraw.setXscale(0.0, 4.0);
		StdDraw.setYscale(0.0, 2.0);
		
		for(double r = 0.0; r <= 4.0; r += 0.1/N){
			double y = rand.nextDouble();
			for(int i = 0; i < 1000; i++){
				y =  feigenbaum.logistic(y,r);
				if(r >= 1.0)
					System.out.println(y  + " " + r);
			}
			
			for(int i = 0; i < 100; i++){
				y = feigenbaum.logistic(y, r);
				System.out.println("y: " + y + " r: " + r);
				StdDraw.point(r, y);
				if(Double.isInfinite(y))
					System.exit(0);
			}
			StdDraw.show();
		}
	}
}
