package poland.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import poland.pojo.TradeDTO;
import poland.validationrules.CounterPartyNotSupported;
import poland.validationrules.DateVSProductType;
import poland.validationrules.ISOCurrencies;
import poland.validationrules.Validator;
import poland.validationrules.ValueDateBeforeTradeDate;
import poland.validationrules.ValueDateFallWeekend;
import poland.validationrules.ValueDateFallWorkingDay;

public class Forward extends AbstractBaseProduct{

	public Forward(String name, String type, Date valueDate, Date tradeDate, String currency, String style, Date expireDate, Date premiumDate, Date deliveryDate) {
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

		 //only spot and forward
		 rules.add(new DateVSProductType(this));
		 
		 List<Object> errors = new ArrayList<Object>();
		 
		 for (Validator tradeRule : rules) {
			errors.add(tradeRule.validate(this));
		}
		return new TradeDTO(this.getName(), errors);
	}
}
