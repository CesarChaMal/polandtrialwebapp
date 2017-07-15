package natek.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import natek.pojo.TradeDTO;
import natek.validationrules.AmericanBeteenTradeAndExpire;
import natek.validationrules.AmericanEuropeanStyle;
import natek.validationrules.CounterPartyNotSupported;
import natek.validationrules.ExpireAndPremiumBeforeDelivery;
import natek.validationrules.ISOCurrencies;
import natek.validationrules.Validator;
import natek.validationrules.ValueDateBeforeTradeDate;
import natek.validationrules.ValueDateFallWeekend;
import natek.validationrules.ValueDateFallWorkingDay;


public class Options extends AbstractBaseProduct{

	public Options(String name, String type, Date valueDate, Date tradeDate, String currency, String style, Date expireDate, Date premiumDate, Date deliveryDate) {
		super(name, type,
	  			 valueDate, 
				 tradeDate, 
				 currency, 
				 style, 
				 expireDate, 
				 premiumDate, 
				 deliveryDate
       		 
				);
	}

	@Override
	public TradeDTO validate() {
		 List<Validator> rules = new ArrayList<>();
		 rules.add(new ValueDateBeforeTradeDate(this));
		 rules.add(new ValueDateFallWeekend(this));
		 rules.add(new ValueDateFallWorkingDay(this));
		 rules.add(new CounterPartyNotSupported(this) );
		 rules.add(new ISOCurrencies(this) );
		 
		 //only for options
		 rules.add(new AmericanEuropeanStyle(this) );
		 rules.add(new AmericanBeteenTradeAndExpire(this) );
		 rules.add(new ExpireAndPremiumBeforeDelivery(this) );
		 
		 List<Object> errors = new ArrayList<Object>();
		 
		 for (Validator tradeRule : rules) {
			errors.add(tradeRule.validate(this));
		}
		return  new TradeDTO(this.getName(),errors);
	}


}
