package shoppingCart;
import java.util.*;
public class mainClass {
	static HashMap<String, String> CartItems = new HashMap<String, String>();
	static HashMap<String, String> OrderedItems = new HashMap<String,String>();
	static Scanner input = new Scanner(System.in);
	public static void addProduct() {
		//System.out.println("inside addProduct");
		System.out.println("enter the id of the product that you want to buy");
		String OrderId=input.next();
		System.out.println("enter the name of the product");
		String OrderName=input.next();
		CartItems.put(OrderId,OrderName);
		
			}
	
	public static void removeProduct()
	{
		if(CartItems.size()==0)
		{
			System.out.println("the cart is empty, no more elements to delete");
		}
		System.out.println("enter the id of the product to be deleted");
		String OrderId = input.next();
		try {
		CartItems.remove(OrderId);
		System.out.println("removed item from cart");
		}
		catch(Exception e)
		{	
			System.out.println("no products are present with id: "+OrderId );
			e.printStackTrace();
		}
		
	}
	public static void viewCart()
	{
		if(CartItems.size()==0)
		{
			System.out.println("cart is empty");
		}
		else {
			System.out.println("elements in cart are:");
		for (String name : CartItems.keySet())  
            System.out.println("key: " + name+" name: "+CartItems.get(name)); }
          
	}
	public static void placeOrder()
	{	
		System.out.println("enter the id of the product that you want to buy");
		String OrderId=input.next();
		if(CartItems.size()==0 || CartItems.containsKey(OrderId)==false)
		{
			System.out.println("the cart is empty or the item is not there in the cart");
			
			System.out.println("enter the name of the product");
			String OrderName=input.next();
			OrderedItems.put(OrderId, OrderName);
			
		}
		else
		{
			OrderedItems.put(OrderId, (String)CartItems.get(OrderId));
		}
	}
	public static void showOrders()
	{
		if(OrderedItems.size()==0)
		{
			System.out.println("orders is empty");
		}
		else {
			System.out.println("elements in orders are:");
		for (String name : OrderedItems.keySet())  
            System.out.println("key: " + name+" name: "+OrderedItems.get(name)); }
		
	}
	public static void cancelOrder()
	{
		if(OrderedItems.size()==0)
		{
			System.out.println("the order is empty, no more orders to delete");
			
		}
		else {
		System.out.println("enter the id of the product to be deleted");
		String OrderId = input.next();
		try {
		OrderedItems.remove(OrderId);
		System.out.println("order cancelled");
		}
		catch(Exception e)
		{	
			System.out.println("no products are present with id: "+OrderId );
			e.printStackTrace();
		}
	}}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true)
		{
			int option=0;
			
			System.out.println();
			System.out.println("enter your choice");
			System.out.println("1 for add a product");
			System.out.println("2 for removing a product");
			System.out.println("3 for viewing the cart");
			System.out.println("4 for placing an order");
			System.out.println("5 for cancelling an order");
			System.out.println("6 for viewing the orders");
			option = input.nextInt();
			switch(option)
			{
			case 1:addProduct();break;
			case 2: removeProduct();break;
			case 3: viewCart();break;
			case 4: placeOrder();break;
			case 5: cancelOrder();break;
			case 6: showOrders();break;
			default: break;
			}
		}

	}

}
