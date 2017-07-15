package poland.validationrules;

import java.util.Date;

import poland.model.AbstractBaseProduct;

public class DateVSProductType extends AbstractBaseRule  implements Validator{
	public DateVSProductType(AbstractBaseProduct prod) {
		super(prod, "Date vs product type");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if(prod.getValueDate()!= null){
			if( prod.getValueDate().after(new Date())  ){
				return sucess();						
			}
		}
		return error();
	}

}
