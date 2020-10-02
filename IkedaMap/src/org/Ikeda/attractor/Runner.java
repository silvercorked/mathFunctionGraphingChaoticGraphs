package org.Ikeda.attractor;

public class Runner {

	public static void main(String[] args) {
		new Thread( new Ikeda() ).start();
	}

}
