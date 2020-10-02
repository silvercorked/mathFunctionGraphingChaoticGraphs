package org.mod.interations;

import org.main.std.StdDraw;

public class KaplanYorke implements Runnable {
	
	private double alpha;
	private double x;
	private double y;
	private double a;
	private final double beta = Integer.MAX_VALUE;
	
	public KaplanYorke(){
		x = 128873/350377;
		y = 0.667751;
		alpha = 0.2;
		primary();
	}
	public void run(){}
	public static double getY(double a, double y, double x){
		return a * y + Math.cos(4*Math.PI*x);
	}
	public static double getX(double a, double b){
		return a/b;
	}
	public static double getA(double a, double b){
		return (2*a) % b;
	}
	public void primary(){
		StdDraw.setXscale(0.0, 1.0);
		StdDraw.setYscale(-1.0, 1.2);
		double oldX;
		System.out.println();
		for(double r = 0; r < 1.0; r+= 0.0001){
			for(int i = 0; i < 1; i++){
				alpha = getA(alpha, beta);
				oldX = x;
				x = getX(alpha, beta);
				y = getY(alpha, y, oldX);
			}
			for(int c = 0; c < 100; c++){
				alpha = getA(alpha, beta);
				oldX = x;
				x = getX(alpha, beta);
				y = getY(alpha, y, oldX);
				StdDraw.point(x, y);
				System.out.println("x: " + x + " y: " + y);
			}
			
		}
	}
}
