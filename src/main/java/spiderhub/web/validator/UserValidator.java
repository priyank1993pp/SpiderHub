package spiderhub.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spiderhub.model.User;

@Component
public class UserValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;

	private boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);

		matcher = pattern.matcher(email);
		return matcher.matches();
	}

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
		else if (!validateEmail(user.getEmailAddress())) {
			// check using regex whether it is
			errors.rejectValue("emailAddress", "error.field.email");
		}

		if (!StringUtils.hasText(user.getPhoneNumber()))
			errors.rejectValue("phoneNumber", "error.field.empty");

	}

}
