package de.jsfpraxis.detail.vc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named("enums")
@RequestScoped
public class EnumController {
	
	private Familienstand familienstand1;
	private Familienstand familienstand2;
	private Familienstand familienstand3;
	private Familienstand familienstandSelected;

	public EnumController() {
	}

	public SelectItem[] getValues() {
		SelectItem[] items = new SelectItem[Familienstand.values().length];
		for (int i = 0; i < items.length; i++) {
			items[i] = new SelectItem(Familienstand.values()[i], Familienstand.values()[i].toString().toLowerCase());
		}
		return items;
	}
	
	public List<SelectItem> getValues2() {
		return Arrays.stream(Familienstand.values()).map(val -> new SelectItem(val, val.toString().toLowerCase())).collect(Collectors.toList());
	}
	
	public Object[] getValues3() {
		return Familienstand.values();
	}

	public void ajaxBehaviorListener(AjaxBehaviorEvent event) {
		switch(event.getComponent().getParent().getClientId()) {
		case "form:enum1":
			familienstandSelected = familienstand1;
			break;
		case "form:enum2":
			familienstandSelected = familienstand2;
			break;
		case "form:enum3":
			familienstandSelected = familienstand3;
			break;
		default:
		}
	}

	
	// Getter und Setter
	public Familienstand getFamilienstand1() {
		return familienstand1;
	}
	public void setFamilienstand1(Familienstand familienstand1) {
		this.familienstand1 = familienstand1;
	}

	public Familienstand getFamilienstand2() {
		return familienstand2;
	}
	public void setFamilienstand2(Familienstand familienstand2) {
		this.familienstand2 = familienstand2;
	}

	public Familienstand getFamilienstand3() {
		return familienstand3;
	}
	public void setFamilienstand3(Familienstand familienstand3) {
		this.familienstand3 = familienstand3;
	}

	public Familienstand getFamilienstandSelected() {
		return familienstandSelected;
	}
	public void setFamilienstandSelected(Familienstand familienstandSelected) {
		this.familienstandSelected = familienstandSelected;
	}

}
