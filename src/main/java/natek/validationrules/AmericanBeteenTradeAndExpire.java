package natek.validationrules;

import natek.model.AbstractBaseProduct;

public class AmericanBeteenTradeAndExpire extends AbstractBaseRule implements Validator{
	public AmericanBeteenTradeAndExpire(AbstractBaseProduct prod) {
		super(prod, "American option style will have in addition the excerciseStartDate, which has to be after the trade date but before the expiry date");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if (prod.getExcerciseStartDate() != null){
			if(
					prod.getExcerciseStartDate().after(prod.getTradeDate())
					&&
					prod.getExcerciseStartDate().before(prod.getExpireDate())
					){
				return sucess();						
			}
		}
		return error();
	}

}
