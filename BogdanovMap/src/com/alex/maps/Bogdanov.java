package com.alex.maps;

import org.main.std.StdDraw;

public class Bogdanov implements Runnable {
	double oldX; 
	double oldY;
	double y;
	double x;
	public Bogdanov(){
		x = -0.5;
		y = -0.5;
		primary();
	}
	public void run(){}
	public static double bogX(double x, double y){
		return x+y;
		//y is y(n+1) and x is x(n)
	}
	public static double bogY(double x, double y){
		double c = Math.random()*2 - 1;
		double d = Math.random()*2 - 1;
		double e = Math.random()*2 - 1;
		return y + c * y + d * x * (x - 1) + e * x * y;
	}
	private void primary(){
		int N = 100;
		StdDraw.setXscale(-5.0, 5.0);
		StdDraw.setYscale(-5.0, 5.0);
		for(double i = 0; i < 1.0; i+= 0.1/N){
			for(int a = 0; a < 1000; a++){
				oldY = y;
				y = bogY(x, y);
				x = bogX(x, y);
			}
			for(int b = 0; b < 100; b++){
				oldY = y;
				y = bogY(x, y);
				x = bogX(x, y);
				StdDraw.point(x, y);
				System.out.println("x: " + x + " y: " + y);
			}
			
		}

	}
}
