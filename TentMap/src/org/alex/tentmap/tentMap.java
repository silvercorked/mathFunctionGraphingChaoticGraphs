package org.alex.tentmap;

import org.main.std.StdDraw;

public class tentMap implements Runnable{
	public tentMap(){
		primary();
	}
	public void run(){}
	static double tent(double x, double muw){
		if(x < (0.5)){
			return muw * x;
		}
		else if(x >= (0.5)){
			return muw * (1 - x);
		}
		else{
			return muw * x;
		}
	}
	public void primary(){
		int N = 1000;
		StdDraw.setCanvasSize(1000, 700);
		StdDraw.setXscale(1.0, 2.0);
		StdDraw.setYscale(0.0, 1.00);
		for(double mew = 1.0; mew <= 2.0; mew += 0.1/N){
			double x = Math.random();
			for(int i = 0; i < 1000; i++){
				x =  tentMap.tent(x,mew);
			}
			for(int i = 0; i < 100; i++){
				x = tentMap.tent(x, mew);
				System.out.println("x: " + x + " mew: " + mew);
				StdDraw.point(mew, x);
			}
			StdDraw.show();
			//start = x = 1, y = .5
		
		}
	}
}
