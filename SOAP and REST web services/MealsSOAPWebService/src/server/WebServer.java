package server;

import javax.xml.ws.Endpoint;


public class WebServer {

	 public static void main(String[] args) {
	        String bindingURI = "http://localhost:9999/mealsService";
	        MealsService webService = new MealsService();
	        Endpoint.publish(bindingURI, webService);
	        System.out.println("Server started at: " + bindingURI);
	    }

}
