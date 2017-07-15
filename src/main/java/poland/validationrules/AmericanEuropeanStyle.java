package poland.validationrules;

import poland.model.AbstractBaseProduct;

public class AmericanEuropeanStyle extends AbstractBaseRule implements Validator{
	public AmericanEuropeanStyle(AbstractBaseProduct prod) {
		super(prod, "American European Style");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if(prod.getStyle()!= null){
			if( "AMERICAN".equals(prod.getStyle()) ||
				"EUROPEAN".equals(prod.getStyle())
			){
				return sucess();						
			}
		}
		return error();
	}

}
