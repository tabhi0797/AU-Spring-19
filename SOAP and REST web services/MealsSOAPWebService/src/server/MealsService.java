package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService
public class MealsService {

	HashMap<Integer,String> items;
	int lastID;
	
	MealsService()
	{
		items = new HashMap<Integer,String>();
		lastID = 0;
	}
	
	@WebMethod
	public Collection<String> getAllItems()
	{
		return items.values();
	}
	@WebMethod
	public String getItem(int id)
	{
		return items.getOrDefault(id,"item not found");
	}
	
	@WebMethod
	public String addItem(String name)
	{
		lastID++;
		return items.put(lastID,name);
	}
	
	@WebMethod
	public String updateItem(int id, String name)
	{
		return items.put(id, name);
	}
	
	@WebMethod
	public String deleteItem(int id)
	{
		return items.remove(id);
	}
}
