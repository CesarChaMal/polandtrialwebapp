package poland.validationrules;

import poland.model.AbstractBaseProduct;

public class ISOCurrencies extends AbstractBaseRule implements Validator{
	public ISOCurrencies(AbstractBaseProduct prod) {
		super(prod,"ISO currencies should be valid");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if(prod.getCurrency()!= null){
			if( "US".equals(prod.getCurrency()) ||
				"EUR".equals(prod.getCurrency())
			){
				return sucess();						
			}
		}
		return error();
	}

}
