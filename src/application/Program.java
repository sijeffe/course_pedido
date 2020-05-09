package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);
		SimpleDateFormat sdfdt =  new SimpleDateFormat("dd/MM/yyyy");	
		System.out.println("Enter cliente data:");
		System.out.print("Name");
		String name = sc.nextLine(); 
		
		System.out.print("Email");
		String email = sc.nextLine(); 
		
		System.out.print("Birth date (DD/MM/YYYY):");
		Date birthDate= sdfdt.parse(sc.nextLine()); 
		
		System.out.println("");
		System.out.println("Enter order data:");
		
		System.out.print("Status:");
		OrderStatus  status = OrderStatus.valueOf( sc.nextLine());
	
		Client client =  new Client(name, email, birthDate); 
		Order order  =  new Order(new Date(), status, client); 
		
		System.out.print("How many items to this order?" );
		int orderItems =  sc.nextInt();

		for (int i = 0 ; i < orderItems; i++)
		{
			System.out.println("Enter #" + (i+1) +  " item data:" );
			sc.nextLine();
			
			System.out.print("Product name: " );
			String productName = sc.nextLine();
			
			System.out.print("Product price: " );
			double productPrice =  sc.nextDouble();
			
			Product product =  new Product(productName , productPrice );
				
			System.out.print("Quantity: " );
			int quantity =  sc.nextInt();
			
			OrderItem orderItem =  new OrderItem (quantity, productPrice , product ); 
				
			order.addItem(orderItem);
		}

		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());
		
		sc.close();
	}
}
