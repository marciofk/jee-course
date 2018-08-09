package nl.hva.jeecourse.module06;

import java.util.LinkedHashSet;
import java.util.Set;

public class FinancialAgent {
	
	private static Set<PaymentMethod> methods;
	
	static {
		methods = new LinkedHashSet<>();
		methods.add(new PaymentMethod("VISA", "/JEECourse/images/visa.png"));
		methods.add(new PaymentMethod("Mastercard", "/JEECourse/images/mastercard.png"));
		methods.add(new PaymentMethod("PayPal", "/JEECourse/images/paypal.png"));
	}
	
	public static Set<PaymentMethod> getPaymentPethods() {
		return methods;
	}

}
