package assignment.triConsumer;

public class DemoTriConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoTriConsumer d = new DemoTriConsumer();
		   TriConsumer<Integer, Integer, Integer > 
        equals = (a,b,c) -> 
    { 
        if (a==b && b==c) { 
            System.out.println("True"); 
        } 
        else { 
            
            System.out.println("False"); 
        } 
    }; 
    equals.accept(1,1,3); 
	   }
	
	
}
