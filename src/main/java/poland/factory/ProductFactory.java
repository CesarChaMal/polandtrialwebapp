package poland.factory;

import java.util.Date;

import poland.model.AbstractBaseProduct;
import poland.model.Forward;
import poland.model.Options;
import poland.model.Spot;

public class ProductFactory {
		  	public AbstractBaseProduct createProduct(String name, String type, 
		  			 Date valueDate, 
					 Date tradeDate, 
					 String currency, 
					 String style, 
					 Date expireDate, 
					 Date premiumDate, 
					 Date deliveryDate
					){
		      if(type.equals("Option"))
		         return new Options(
		        		 name,
		        		 type,
			  			 valueDate, 
						 tradeDate, 
						 currency, 
						 style, 
						 expireDate, 
						 premiumDate, 
						 deliveryDate
		        		 
		        		 );
		      else if(type.equals("Forward"))
		         return new Forward(
		        		 name,
		        		 type,
			  			 valueDate, 
						 tradeDate, 
						 currency, 
						 style, 
						 expireDate, 
						 premiumDate, 
						 deliveryDate
		        		 
		        		 );
		      else if(type.equals("Spot"))
		    	  return new Spot(
			        		 name,
			        		 type,
				  			 valueDate, 
							 tradeDate, 
							 currency, 
							 style, 
							 expireDate, 
							 premiumDate, 
							 deliveryDate
			        		 
			        		 );
		      else
		         return null;
		   }
}

