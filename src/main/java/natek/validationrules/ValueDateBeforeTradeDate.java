package natek.validationrules;

import natek.model.AbstractBaseProduct;

public class ValueDateBeforeTradeDate extends AbstractBaseRule implements Validator{

	public ValueDateBeforeTradeDate(AbstractBaseProduct prod) {
		super(prod,"Value date must be before Trade date");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if (prod.getValueDate() != null && prod.getTradeDate() != null){
			if (prod.getValueDate().before(prod.getTradeDate())) {
				return sucess();
			}
		}
		return error();
		
	}

}
