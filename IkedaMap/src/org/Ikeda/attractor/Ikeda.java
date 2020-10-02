package org.Ikeda.attractor;

import java.util.Random;

import org.main.std.StdDraw;

public class Ikeda implements Runnable{
	
	private double x;
	private double y;
	private double t;
	private double oldX;
	private double u;
	
	public Ikeda(){
		primary();
	}
	public void run(){}
	public void primary(){
		int N = 1000;
		
		StdDraw.setXscale(-1.0, 3.0);
		StdDraw.setYscale(-1.5, 1.0);
		for( u  = 0.0; u < 1.0; u += 0.1/N){
			for(int i = 0; i < 1000; i++){
				t = getNextT(x,y);
				oldX = x;
				x = getNextX(x,y,t);
				y = getNextY(oldX,y,t);
			}
			for(int r = 0; r < 1000; r++){
				t = getNextT(x,y);
				oldX = x;
				x = getNextX(x,y,t);
				y = getNextY(oldX,y,t);
				StdDraw.point(x,y);
				System.out.println("x: " + x + " y: " + y + " t: " + t + " u: " + u);
			}
		}
	}
	public double getNextT(double x, double y){
		return 0.4 - ( 6 / ( 1 + Math.pow(x, 2) + Math.pow(y, 2) ) );
	}
	public double getNextX(double x, double y, double t){
		return 1 + u * (x * Math.cos(t) - y * Math.sin(t));
	}
	public double getNextY(double x, double y, double t){
		return u * (x * Math.sin(t) + y * Math.cos(t));
	}
}
