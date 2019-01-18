package de.jsfpraxis.detail.ajax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PickListController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> left;
	private List<String> right;
	private String selectedLeft;
	private String selectedRight;
	
	
	public PickListController() {
		left = new ArrayList<>(List.of("Banane", "Erdbeere", "Kiwi", "Ananas"));
		right = new ArrayList<>(List.of( "Kirsche", "Himbeere", "Orange", "Apfel"));
	}
	
	public void addToRight() {
		if (selectedLeft != null) {
			left.remove(selectedLeft);
			right.add(selectedLeft);
		}
	}

	public void addToLeft() {
		if (selectedRight != null) {
			right.remove(selectedRight);
			left.add(selectedRight);
		}
	}

	public void clickListener(AjaxBehaviorEvent event) {
		System.out.println(event.getComponent().getClientId());
		System.out.println(event.getComponent().getId());
		if (event.getComponent().getId().equals("addToRight")) {
			addToRight();
		} else if (event.getComponent().getId().equals("addToLeft")) {
			addToLeft();
		}
	}

	
	// Getter und Setter
	public List<String> getLeft() {
		return left;
	}
	public void setLeft(List<String> left) {
		this.left = left;
	}

	public List<String> getRight() {
		return right;
	}
	public void setRight(List<String> right) {
		this.right = right;
	}

	public String getSelectedLeft() {
		return selectedLeft;
	}
	public void setSelectedLeft(String selectedLeft) {
		this.selectedLeft = selectedLeft;
	}

	public String getSelectedRight() {
		return selectedRight;
	}
	public void setSelectedRight(String selectedRight) {
		this.selectedRight = selectedRight;
	}

}
