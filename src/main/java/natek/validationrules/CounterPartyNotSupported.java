package natek.validationrules;

import natek.model.AbstractBaseProduct;

public class CounterPartyNotSupported extends AbstractBaseRule implements Validator{
	public CounterPartyNotSupported(AbstractBaseProduct prod) {
		super(prod, "Counter Party not supported rule");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if(prod.getName()!= null){
			if( "PLUTO1".equals(prod.getName()) ||
				"PLUTO2".equals(prod.getName())	
					){
				return sucess();						
			}
			
		}
		return error();
	}

}
