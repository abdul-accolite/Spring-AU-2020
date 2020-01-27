package assignment2;

public class Farmer implements Runnable {

	FruitMarket fm;
	public Farmer(FruitMarket obj)
	{
		this.fm=obj;
	}
	public void run()
	{
		int access=1;
		synchronized(this.fm)
		{
			
			while(true) {
			if(this.fm.cur_market_size==this.fm.max_market_size)
			{
				try {
					this.fm.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(this.fm.apple<this.fm.max_size)
			{
				System.out.println(Thread.currentThread().getName()+":produced apple");
				//this.fm.produceFruit("apple");
				this.fm.apple++;
				this.fm.cur_market_size++;
			}
			 if(fm.orange<fm.max_size)
			{
				 System.out.println(Thread.currentThread().getName()+":produced orange");
				fm.orange++;
				fm.cur_market_size++;
			}
			 if(fm.banana<fm.max_size)
			{
				 System.out.println(Thread.currentThread().getName()+":produced banana");
				fm.banana++;
				fm.cur_market_size++;
			}
			 if(Main.lis.size()>=1)
			 {
				 Main.lis.clear();
			 }
			 Main.lis.add(this.fm);
			 Main.lis.stream().map(x->x).forEach(y->System.out.println("apple count: "+ y.apple +", orange count: "+y.orange+", banana count"));
			 if(access==0)
			 {
			 try {
				this.fm.wait();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 access=2;
			 
		}
			access--;
			
			this.fm.notifyAll();
			}
		}
	}
}
