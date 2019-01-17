package client;

import java.util.*;

public class WebClient {
 
    public static void main(String[] args) {
        MealsServiceService client = new MealsServiceService();
        MealsService mealsService = client.getMealsServicePort();
        Scanner sc = new Scanner(System.in);
        
        while(true)
        {
        	System.out.println("1.get 2.add 3.update 4.delete 5.all items 6.exit \n Enter choice:");
        	int choice = sc.nextInt();
        	
        	switch(choice)
        	{
        	case 1: 
        		System.out.println("Enter item id:");
        		int id = sc.nextInt();
        		System.out.println(mealsService.getItem(id));
        		break;
        	case 2:
        		System.out.println("Enter item name:");
        		String name = sc.next();
        		System.out.println(mealsService.addItem(name));
        		break;
        	case 3:
        		System.out.println("Enter item id:");
        		int id1 = sc.nextInt();
        		System.out.println("Enter item name:");
        		String name1 = sc.next();
        		System.out.println(mealsService.updateItem(id1, name1));
        		break;
        	case 4:
        		System.out.println("Enter item id:");
        		int id2 = sc.nextInt();
        		System.out.println(mealsService.deleteItem(id2));
        		break;
        	case 5:
        		Collection<String> list = mealsService.getAllItems();
        		for(String item:list)
        		{
        			System.out.println(item);
        		}
        		break;
        	case 6:
        		return;
        	default: System.out.println("invalid option");
        	}
        }
    }
}