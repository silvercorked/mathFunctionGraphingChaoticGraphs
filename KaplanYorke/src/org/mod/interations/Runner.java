package org.mod.interations;

public class Runner {

	public static void main(String[] args) {
		new Thread( new KaplanYorke() ).start();
	}

}
