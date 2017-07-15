package natek.validationrules;

import java.util.Calendar;
import java.util.GregorianCalendar;

import natek.model.AbstractBaseProduct;

public class ValueDateFallWorkingDay extends AbstractBaseRule implements Validator{
	public ValueDateFallWorkingDay(AbstractBaseProduct prod) {
		super(prod, "Value date not fall in working day");
	}

	@Override
	public String validate(AbstractBaseProduct prod) {
		if (prod.getValueDate() != null) {
		    GregorianCalendar dt = new GregorianCalendar();
		    dt.setTime(prod.getValueDate());
		    if (
		    	dt.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
		    	dt.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
		    	) {
		        return error();
		    }
		}
		return sucess();

	}
}
