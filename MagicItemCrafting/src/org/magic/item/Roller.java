package org.magic.item;

import java.util.Random;

public class Roller {
	
	private Random rand;
	private int mod;
	private int dc;
	private int gold;
	private int daysRemaining;
	private int daysExcess;
	private int timeExpended;
	private int currentRoll;
	private long oneTracker;
	
	public Roller(int modifier, int difficultyClass, int goldSum){
		rand = new Random();
		mod = modifier;
		dc = difficultyClass;
		gold = goldSum;
		daysRemaining = daysRemainingFinder();
		daysExcess = 0;
		timeExpended = 0;
	}
	
	private int daysRemainingFinder(){
		return (int) gold/25;
	}
	
	public int daysRemainingFinder(int g){
		return (int) g/25;
	}
	
	public int roll(int modifier, int difficultyClass, int gold){
		mod = modifier;
		dc = difficultyClass;
		timeExpended = 0;
		for(daysRemaining = daysRemainingFinder(gold); daysRemaining >= 0; daysRemaining--){
			currentRoll = rand.nextInt(20)+1+mod;
			if(currentRoll-mod == 1){
				timeExpended++;
				daysRemaining++;
				oneTracker++;
				//System.err.println("Rolled a 1");
				if(oneTracker >= 3){
					return -54;
				}
				continue;
			}
			//System.out.println("This is currentRoll before floor: " + currentRoll);
			if(currentRoll >= dc){
				currentRoll = (int) Math.floor((currentRoll-dc)/5);
				//System.out.println("This is currentRoll after floor: " + currentRoll);
				daysRemaining -= currentRoll+1;
				daysExcess += (currentRoll > 0) ? currentRoll : 0;
				//System.out.println("daysRemaining: " + daysRemaining);
				//System.out.println("DaysExcess: " + daysExcess);
			}
			else if(daysExcess > 0){
				daysExcess--;
			}
			else{
				timeExpended++;
				System.out.println(daysRemaining + " this is days remaining");
				System.out.println("Time was expended : " + timeExpended);
			}
			oneTracker = 0;
			//System.out.println(timeExpended + daysExcess + daysRemaining);
		}
		daysExcess = 0;
		daysRemaining = 0;
		return timeExpended;
	}
	
	public int roll(){
		timeExpended = 0;
		for(daysRemaining = daysRemainingFinder(gold); daysRemaining >= 0; daysRemaining--){
			currentRoll = rand.nextInt(20)+1+mod;
			if(currentRoll-mod == 1){
				timeExpended++;
				daysRemaining++;
				//System.err.println("Rolled a 1");
				continue;
			}
			//System.out.println("This is currentRoll before floor: " + currentRoll);
			if(currentRoll >= dc){
				currentRoll = (int) Math.floor((currentRoll-dc)/5);
				//System.out.println("This is currentRoll after floor: " + currentRoll);
				daysRemaining -= currentRoll+1;
				daysExcess += (currentRoll > 0) ? currentRoll : 0;
				//System.out.println("daysRemaining: " + daysRemaining);
				//System.out.println("DaysExcess: " + daysExcess);
			}
			else if(daysExcess > 0){
				daysExcess--;
			}
			else{
				timeExpended++;
				
			}
			//System.out.println(timeExpended + daysExcess + daysRemaining);
		}
		daysExcess = 0;
		daysRemaining = 0;
		return timeExpended;
	}
}
