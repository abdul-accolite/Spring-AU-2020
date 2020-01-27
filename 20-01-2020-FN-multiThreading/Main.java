package assignment2;

import java.util.ArrayList;
import java.util.*;

public class Main {
	 
	static List<FruitMarket> lis = new ArrayList<FruitMarket>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitMarket fm = new FruitMarket();
		
			
		
		Thread consumer_1 = new Thread( new Consumer(fm));
		Thread consumer_2 = new Thread( new Consumer(fm));
		Thread consumer_3 = new Thread( new Consumer(fm));
		Thread consumer_4 = new Thread( new Consumer(fm));
		Thread consumer_5 = new Thread( new Consumer(fm));
		Thread producer_1 = new Thread( new Farmer(fm));
		Thread producer_2 = new Thread( new Farmer(fm));
		Thread producer_3 = new Thread( new Farmer(fm));
		consumer_1.start();
		consumer_2.start();
		consumer_3.start();
		consumer_4.start();
		consumer_5.start();
		producer_1.start();
		producer_2.start();
		producer_3.start();
		

	}

}
