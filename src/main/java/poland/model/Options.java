package poland.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import poland.pojo.TradeDTO;
import poland.validationrules.AmericanBeteenTradeAndExpire;
import poland.validationrules.AmericanEuropeanStyle;
import poland.validationrules.CounterPartyNotSupported;
import poland.validationrules.ExpireAndPremiumBeforeDelivery;
import poland.validationrules.ISOCurrencies;
import poland.validationrules.Validator;
import poland.validationrules.ValueDateBeforeTradeDate;
import poland.validationrules.ValueDateFallWeekend;
import poland.validationrules.ValueDateFallWorkingDay;


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
