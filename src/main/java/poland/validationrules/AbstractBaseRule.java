package poland.validationrules;

import poland.model.AbstractBaseProduct;

public class AbstractBaseRule{
	AbstractBaseProduct prod;
	protected String description;
	
	
	public AbstractBaseRule(AbstractBaseProduct prod, String description) {
		this.prod = prod;
		this.description = description;
	}

	
	public String error() {
		return description + " : "+ Validator.error + "  ";
	}
	public String sucess() {
		return description + " : "+ Validator.sucess+ " ";
	}

}
