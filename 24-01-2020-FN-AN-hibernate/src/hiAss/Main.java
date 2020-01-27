package hiAss;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tables.Address;
import tables.Cart;
import tables.Customer;
import tables.Laptop;
import tables.Product;
import tables.Speaker;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	 Session session=sessionFactory.openSession();
	//creating objects of product and laptop, speakers
	 Product p1 = new Product();
	 p1.setCost(200);
	 p1.setName("product");
	 Laptop l1 = new Laptop();
	 l1.setBrand("Dell");
	 l1.setProcessor("i7");
	 Laptop l2 = new Laptop();
	 l2.setBrand("hp");
	 l2.setProcessor("i5");
	 Speaker s1 = new Speaker();
	 s1.setBrand("bose");
	 s1.setWaterProof(true);
	 Speaker s2 = new Speaker();
	 s2.setBrand("boot");
	 s2.setWaterProof(false);
	 Speaker s3 = new Speaker();
	 s3.setBrand("reliance");
	 s3.setWaterProof(true);
	 
	 
	//creating objects of cart and adding laptop and speakers in it. 
	 Cart cart1 = new Cart();
     cart1.setId(1);
     cart1.setAmount(120.00);
     cart1.getProductList().add(l1);
     cart1.getProductList().add(s1);
     
     Cart cart2 = new Cart();
     cart2.setId(2);
     cart2.setAmount(340.00);
     cart2.getProductList().add(l2);
     cart2.getProductList().add(s2);
     
     Customer customer=new Customer();
     customer.setId(1);
     customer.setName("abdul");
     customer.setMobile("8951466449");
     
     
     //setting address object
     Address addr = new Address();
     addr.setNumber(10);
     addr.setStreet("obeya street");
     addr.setArea("koramangala");
     addr.setCity("bangalore");
     customer.setOfficeAddress(addr);
	 
	 
	        session.beginTransaction();
	        session.save(p1);
	        session.save(l1);
	        session.save(s1);
	        session.save(s2);//insert
	        session.save(cart1);
	        session.save(cart2);
	        session.save(customer);
	        
	        session.delete(s3);//delete s3
	        s1.setWaterProof(false);
	        session.update(s1);//update s1
	        
	        //creating session query hibernate query.hql
	        List<Speaker> results = new ArrayList<Speaker>();
	        String hql = "FROM Speaker";
	        Query query = session.createQuery(hql);
	        results = query.getResultList();
	        for(Speaker s : results)
	        {
	        	System.out.println(s.getBrand()+":Brand");
	        }

	        //named query
	        
	        Query query2= session.getNamedQuery("Cart.byId");
	        List<Cart> lst = new ArrayList<Cart>();
	        lst=query2.getResultList();
	        for(Cart c : lst)
	        {
	        	System.out.println(c.getAmount()+" :amount, "+"id:"+c.getId());
	        }
	        //System.out.println(query2.getResultList());
	        
	        
	        //named native query

	        Query query3 = session.getNamedNativeQuery("Cart.byAmount");
	        
	        lst=query3.getResultList();
	        for(Cart c : lst)
	        {
	        	System.out.println(c.getAmount()+" :amount,"+c.getId()+":id");
	        }
	        //System.out.println(query3.getResultList());
	        
		/*
		 * System.out.println(department); System.out.println(query3.getResultList());
		 */
		/*
		 * Query q = session.createQuery("select _acc from Speaker _acc"); List<Speaker>
		 * lst = q.list(); System.out.println();
		 * System.out.println("Reading speaker records...");
		 * System.out.printf("%-30.30s  %-30.30%n", "brand","waterProof"); for ( Speaker
		 * c : lst) {
		 * System.out.printf("%-30.30s  %-30.30s%n",c.getBrand(),c.isWaterProof()); }
		 * read operation.
		 */
	        session.getTransaction().commit();
	        session.close();
	}

}
