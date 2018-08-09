package nl.hva.jeecourse.module06;

import java.io.Serializable;

public class AccessRight implements Serializable{
	
	private static final long serialVersionUID = -5272907446091490212L;
	
	private String name;
	private boolean canView;
	private boolean canEdit;
	private boolean cadDelete;
	
	public AccessRight(String name,boolean canView, boolean canEdit, boolean canDelete) {
		setName(name);
		setCanView(canView);
		setCanEdit(canEdit);
		setCadDelete(canDelete);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanView() {
		return canView;
	}

	public void setCanView(boolean canView) {
		this.canView = canView;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public boolean isCadDelete() {
		return cadDelete;
	}

	public void setCadDelete(boolean cadDelete) {
		this.cadDelete = cadDelete;
	}

}
