package natek.validationrules;

import natek.model.AbstractBaseProduct;

public class ExpireAndPremiumBeforeDelivery extends AbstractBaseRule implements Validator{
	public ExpireAndPremiumBeforeDelivery(AbstractBaseProduct prod) {
		super(prod, "Expire and premium date before delivery date");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if (prod.getExpireDate() != null 
			&& prod.getPremiumDate()!= null
			){
			if(prod.getPremiumDate().before(prod.getDeliveryDate()) &&
			   prod.getExpireDate().before(prod.getDeliveryDate()))
					{
				return sucess();
			}
		}
		return error();
		
	}

}
