package natek.validationrules;

import java.util.Calendar;
import java.util.GregorianCalendar;

import natek.model.AbstractBaseProduct;

public class ValueDateFallWeekend extends AbstractBaseRule implements Validator{
	public ValueDateFallWeekend(AbstractBaseProduct prod) {
		super(prod,"Value date not fall in weekend");
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
