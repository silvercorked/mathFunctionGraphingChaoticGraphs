package com.Tinker.bell.alex;

import org.main.std.StdDraw;

public class TinkRunThread implements Runnable{

	public TinkRunThread(){
		run();
	}
	@Override
	public void run() {
		primary();
	}
	public void primary(){
		int N = 1000;
		StdDraw.setXscale(-1.3, 0.5);
		StdDraw.setYscale(-1.7, 0.7);
		double x = -0.72;
		double y = -0.64;
		double oldX = x;
		double oldY = y;
		for(double r = -1.0; r <= 1.0; r += 0.1/N){
			for(int i = 0; i < 1000; i++){
				x = Tinkerbell.xVal(oldX, oldY);
				y = Tinkerbell.yVal(oldX, oldY);
				oldX = x;
				oldY = y;
			}
			for(int i = 0; i < 100; i++){
				x = Tinkerbell.xVal(oldX, oldY);
				y = Tinkerbell.yVal(oldX, oldY);
				oldX = x;
				oldY = y;
				System.out.println("x: " + x + "y: " + y + " r: " + r);
				StdDraw.point(x, y);
			}
			StdDraw.show();
		}
	}

}
