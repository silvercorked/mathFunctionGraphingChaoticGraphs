package org.differenials.how;

import org.main.std.StdDraw;

public class PredatorPrey implements Runnable {
	
	private double alpha;
	private double beta;
	private double gamma;
	private double sigma;
	private double prey;
	private double predator;
	private double DpreyDt;
	private double DpredatorDt;
	private double increment;
	
	public PredatorPrey(){
		alpha = 1.0;
		beta = 1.0;
		gamma = 1.0;
		sigma = 1.0;
		prey = 50.0;
		predator = 20.0;
		increment = 0.0001;
		System.out.println(getDpreyDt(alpha, beta, gamma, prey, predator));
		System.out.println(getDpredatorDt(gamma, sigma, prey, predator));
		primary();
	}
	public void run(){}
	public static double getDpreyDt(double a, double b, double g, double prey, double predator){
		return a*prey - b*prey* predator;
	}
	public static double getDpredatorDt(double g, double s, double prey, double predator){
		return s*prey* predator - g* predator;
	}
	public static double getNextY(double diff, double i){
		return diff*i;
	}
	public void primary(){
		StdDraw.setXscale(0.0, 0.5);
		StdDraw.setYscale(0.0, 0.5);
		double preyY;
		double predatorY;
		for(double i = 0; i < 50; i+= increment){
			predatorY = getNextY(getDpredatorDt(gamma, sigma, prey, predator), i);
			preyY = getNextY(getDpreyDt(alpha, beta, gamma, prey, predator), i);
			StdDraw.point(i, preyY);
			StdDraw.point(i, predatorY);
			prey += preyY;
			predator += predatorY;
			System.out.println(prey);
		}
	}
}
