package de.jsfpraxis.detail.vc.wb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Bernd Müller
 *
 */
@Named
@RequestScoped
@Password(groups = PasswordValidationGroup.class)
public class BackingBean implements PasswordHolder, Cloneable {

	@NotNull(groups = PasswordValidationGroup.class)
	@Size(max = 16, min = 8, message = "Password must be between 8 and 16 characters long", groups = PasswordValidationGroup.class)
	private String password1;
	
	@NotNull(groups = PasswordValidationGroup.class)
	@Size(max = 16, min = 8, message = "Password must be between 8 and 16 characters long", groups = PasswordValidationGroup.class)
	private String password2;

	public BackingBean() {
		password1 = "";
		password2 = "";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		BackingBean other = (BackingBean) super.clone();
		other.setPassword1(this.getPassword1());
		other.setPassword2(this.getPassword2());
		return other;
	}

	@Override
	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	@Override
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
