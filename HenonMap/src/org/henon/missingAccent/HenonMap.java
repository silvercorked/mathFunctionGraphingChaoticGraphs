package org.henon.missingAccent;

import org.main.std.StdDraw;

public class HenonMap implements Runnable {
	
	private double x;
	private double y;
	private double oldX;
	private static double a;
	private static double b;
	
	public HenonMap(){
		a = 1.4;
		b = 0.3;
		primary();
	}
	public void run(){}
	public void primary(){
		int N = 1000;
		StdDraw.setXscale(-1.5, 1.5);
		StdDraw.setYscale(-1.0, 1.0);
		for(int e = 0; e < 1000; e++){
			StdDraw.point((Math.sqrt(609)-7)/28, (3*(Math.sqrt(609)-7))/280);
		}
		for(double i = 0.0; i < 2.0; i += 0.1/N){
			for(int c = 0; c < 1000; c++){
				oldX = x;
				x = henonX(x, y);
				y = henonY(oldX, y);
			}
			for(int r = 0; r < 100; r++){
				oldX = x;
				x = henonX(x, y);
				y = henonY(oldX, y);
				StdDraw.point(x, y);
				System.out.println("x: " + x + " y: " + y);
			}
		}
	}
	public static double henonX(double x, double y){
		return 1 - a * Math.pow(x, 2) + y;
	}
	public static double henonY(double x, double y){
		return b*x;
	}
}
