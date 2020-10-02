package com.Gauss.Alex;

import org.main.std.StdDraw;

public class Gauss implements Runnable{
	
	public Gauss(){
		primary();
	}
	public void run(){}
	static double gauss(double x, double b){
		//=exp(-a*x^2)+b
		return Math.exp((-6.20)*(x*x)) + b;
	}
	public void primary(){
		int N = 100;
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.5);
		
		for(double x = -1.0; x <= 1.0; x += 0.1/N){
			double y = Math.random();
			for(int i = 0; i < 1000; i++){
				y =  Gauss.gauss(y,x);
			}
			for(int i = 0; i < 100; i++){
				y = Gauss.gauss(y, x);
				System.out.println("y: " + y + " x: " + x);
				StdDraw.point(x, y);
			}
			StdDraw.show();
		}
	}
}
