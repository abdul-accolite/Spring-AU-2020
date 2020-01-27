package assignment2;

import java.util.Scanner;

public class Consumer implements Runnable {
	FruitMarket fm ;
	public Consumer(FruitMarket obj)
	{
		this.fm=obj;
	}
	public void run()
	{ int access =1;
		Scanner input = new Scanner(System.in);
		synchronized(this.fm)
		{
			while(true)
			{
				if(this.fm.cur_market_size==0)
				{
					try {
						System.out.println(Thread.currentThread().getName()+" please wait");
						this.fm.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("press 1: to take apple");
				System.out.println("press 2: to take orange");
				System.out.println("press 3: to take banana");
				
				int inp = input.nextInt();
				switch(inp)
				{
				case 1:
					if(this.fm.apple<=0)
					{
						try {
							this.fm.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					this.fm.apple--;
					this.fm.cur_market_size--;
				case 2:
					if(this.fm.orange<=0)
					{
						try {
							this.fm.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					this.fm.orange--;
					this.fm.cur_market_size--;
				case 3: 
					if(this.fm.banana<=0)
					{
						try {
							this.fm.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					this.fm.banana--;
					this.fm.cur_market_size--;
				default: System.out.println("");
				}
				
				if(access==0) {
				try {
					this.fm.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				access=2;
				}
				this.fm.notifyAll();
				access--;
			}
		}
	}
}
