package poland.validationrules;

import poland.model.AbstractBaseProduct;

public interface Validator {
		String validate(AbstractBaseProduct regData);
		public static String sucess ="SUCESS";
		public static String error ="ERROR";
		
}
