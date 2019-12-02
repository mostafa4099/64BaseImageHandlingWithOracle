package com.mostafa.sna.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import com.mostafa.sna.dao.PersonDao;
import com.mostafa.sna.form.PersonForm;
import com.mostafa.sna.model.Person;

public class PersonAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession ses = request.getSession(true);

		PersonForm personForm = (PersonForm) form;
		
		String firstName = personForm.getPerson().getFirstName();
		String lastName = personForm.getPerson().getLastName();
		String userName = personForm.getPerson().getUserName();
		String password = personForm.getPerson().getPassword();
		String email = personForm.getPerson().getEmail();
		String phone = personForm.getPerson().getPhone();
		FormFile file = personForm.getPerson().getFile();
		String fileName = file.getFileName();
		
		String contentType = file.getContentType();
		System.out.println("File Content Type "+contentType);
		System.out.println("File Name "+fileName);
		
		//File image = new File(fileName);
		byte [] encoded = Base64.getEncoder().encode(file.getFileData());
		//Blob blob = new SerialBlob(encoded);
		InputStream stream = new ByteArrayInputStream(encoded);
		//FileInputStream stream = new FileInputStream(image);
		
		PersonDao dao = new PersonDao();
		
		int id = dao.insertData(firstName, lastName, userName, password, email, phone, stream);
		
		Person person = dao.get(id);
		
		ses.setAttribute("id", person.getId());
		ses.setAttribute("firstName", person.getFirstName());
		ses.setAttribute("lastName", person.getLastName());
		ses.setAttribute("userName", person.getUserName());
		ses.setAttribute("password", person.getPassword());
		ses.setAttribute("email", person.getEmail());
		ses.setAttribute("phone", person.getPhone());
		ses.setAttribute("base64Image", person.getBase64Image());
		
		if (firstName.equals("") || lastName.equals("") || userName.equals("")
				|| password.equals("") || email.equals("") || phone.equals("")
				|| fileName.equals("")) {
			
			return mapping.findForward("error");
			
		}
		
		return mapping.findForward("success");

	}
}
