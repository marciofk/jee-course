package nl.hva.jeecourse.module06;

public class PaymentMethod {

	private String description;
	private String icon;
	
	public PaymentMethod(String description, String icon) {
		setDescription(description);
		setIcon(icon);
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
