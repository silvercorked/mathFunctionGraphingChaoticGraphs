package org.differenials.how;

public class Runner {
	public static void main(String[] args){
		new Thread( new PredatorPrey() ).start();
	}
}
