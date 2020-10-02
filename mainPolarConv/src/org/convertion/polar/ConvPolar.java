package org.convertion.polar;

public class ConvPolar {
	double r;
	double row;
	public ConvPolar(double x, double y){
	}
	public double converterR(double x, double y){
		r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return r;
	}
	public double converterROW(double x, double y){
		row = Math.atan2(y, x);
		return row;
	}
}
