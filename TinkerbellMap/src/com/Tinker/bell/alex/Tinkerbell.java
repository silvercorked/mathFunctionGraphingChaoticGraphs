package com.Tinker.bell.alex;

public class Tinkerbell {
	static double xVal(double x, double y){
		return (x*x) - (y*y) + ((0.9)*x) + ((-0.6013)*y);
	}
	static double yVal(double x, double y){
		return 2*x*y + 2.0*x + 0.5*y;
	}
	//common values
	// for x(n+1) = x^2 - y^2 + ax + by
	// for y(n+1) = 2xy + cx + dy
	// a = 0.9 b = -0.6013 c = 2.0 d = 0.5
	// a = 0.3 b = 0.6 c = 2.0 d = 0.27
}
