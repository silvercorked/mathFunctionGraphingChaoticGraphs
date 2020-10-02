package com.graphs.alex;

import org.main.std.StdDraw;

public class Runner implements Runnable{
	
	public Runner(){
		new Thread(this).start();
		run();
	}
	public static void main(String[] args) {
		Runner alex  = new Runner();
	}

	@Override
	public void run() {
		int N = 10000;
		StdDraw.setXscale(0.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		double y = 0; 
		for(double i = 1.0; i < 1.0; i+=0.1/N){
			//sin(3/x)*sin(5/(1-x)) 2, no simple
			//(2*sin(3/x))+(3*cos(5/x))+(4*sin(6/x))+(1*cos(3/x)) 1, no simple
			//sin ( (1/x) (1/(1-x)) ) 2, simple
			//sin(1/x) 1, simple
			y = Math.sin(3/(i))*Math.sin(5/(1-i));
			StdDraw.point(i, y);
			System.out.println("x: " + i + " y: " + y);
			StdDraw.show();
		}
	}
}
