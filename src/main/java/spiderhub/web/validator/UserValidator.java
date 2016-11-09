package spiderhub.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spiderhub.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!StringUtils.hasText(user.getUserName()))
			errors.rejectValue("userName", "error.field.empty");
		if (!StringUtils.hasText(user.getPassword()))
			errors.rejectValue("password", "error.field.empty");
		if (!StringUtils.hasText(user.getEmailAddress()))
			errors.rejectValue("emailAddress", "error.field.empty");
		if (!StringUtils.hasText(user.getPhoneNumber()))
			errors.rejectValue("phoneNumber", "error.field.empty");
		if (StringUtils.hasText(user.getEmailAddress()))
		{
			errors.rejectValue("emailAddress", "error.field.email");
		}
	}

}
