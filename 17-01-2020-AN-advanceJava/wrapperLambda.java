import java.util.function.BiConsumer;

public class wrapperLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,4,6,8,10};
		int key = 0;
		process(arr,key,wrapperLambda((v,k)->System.out.println(v/k)));

	}
	private static void process(int[] arr, int val,BiConsumer<Integer,Integer> consumer)
	{
		for(int i:arr)
		{
			consumer.accept(i, val);
		}
	}
	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer)
	{
		//return consumer;
		return(v,k)->{
			try {
				System.out.println(v/k);
			}
			catch(ArithmeticException e)
			{
				System.out.println("Exception caught in wrapperLambda");
				e.printStackTrace();
			}
		};
	}

}
