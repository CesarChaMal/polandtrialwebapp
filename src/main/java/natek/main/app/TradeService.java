package natek.main.app;

import java.util.Date;

import natek.pojo.TradeDTO;

public interface TradeService {

	TradeDTO validate(String name, 
			 String type,
			 Date valueDate, 
			 Date tradeDate, 
			 String currency, 
			 String style, 
			 Date expireDate, 
			 Date premiumDate, 
			 Date deliveryDate
			);

}
