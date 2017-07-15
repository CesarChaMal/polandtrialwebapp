package natek.main.app;

import java.util.Date;

import org.springframework.stereotype.Service;

import natek.factory.ProductFactory;
import natek.pojo.TradeDTO;

@Service
public class TradeServiceImpl implements TradeService {



	@Override
	public TradeDTO validate(
			 String name, 
			 String type,
			 Date valueDate, 
			 Date tradeDate, 
			 String currency, 
			 String style, 
			 Date expireDate, 
			 Date premiumDate, 
			 Date deliveryDate
			) {
		ProductFactory factory = new ProductFactory();
		return factory.createProduct(
				name, type,
				  valueDate, 
				  tradeDate, 
				  currency, 
				  style, 
				  expireDate, 
				  premiumDate, 
				  deliveryDate
				).validate();
	}
}
