package org.ball.move;

import javax.swing.*;

public class Runner{
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	           new Movement(); // Let the constructor do the job
	        }
	     });
	}
}