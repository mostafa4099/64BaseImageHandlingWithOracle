package com.mostafa.sna.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.mostafa.sna.model.Person;

public class PersonForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	Person person = new Person();
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (person.getFirstName() == null || person.getFirstName().length() < 1) {
			errors.add("firstName", new ActionMessage(
					"error.firstName.required"));

		}
		if (person.getLastName() == null || person.getLastName().length() < 1) {
			errors.add("lastName", new ActionMessage("error.lastName.required"));

		}
		if (person.getUserName() == null || person.getUserName().length() < 1) {
			errors.add("userName", new ActionMessage("error.userName.required"));

		}
		if (person.getPassword() == null || person.getPassword().length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));

		}
		if (person.getEmail() == null || person.getEmail().length() < 1) {
			errors.add("email", new ActionMessage("error.email.required"));

		}
		if (person.getPhone() == null || person.getPhone().length() < 1) {
			errors.add("phone", new ActionMessage("error.phone.required"));

		}
		if (person.getFile().getFileSize() == 0) {
			errors.add("file", new ActionMessage("error.file.required"));
		}
		return errors;
	}
	
}
