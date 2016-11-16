package spiderhub.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spiderhub.model.Project;
import spiderhub.model.dao.ProjectDao;

@Component
public class ProjectValidator implements Validator {
	//taken from stackoverflow
	private static final String linkPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private Pattern pattern;
	private Matcher matcher;

	@Autowired
	private  ProjectDao projectDao;

	// helper method
	private boolean validateLink(String link) {
		pattern = Pattern.compile(linkPattern);

		matcher = pattern.matcher(link);
		return matcher.matches();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Project project = (Project) target;
		String link = project.getProjectGitHubLink();
		if (!StringUtils.hasText(link))
			errors.rejectValue("projectGitHubLink", "error.field.empty");
		else if (!validateLink(link)) {
			// check using regex whether it is
			errors.rejectValue("projectGitHubLink", "error.field.link");
		} else if (StringUtils.hasText(link)) {
			Project p = projectDao.checkLinkExist(link);
			if (p != null) {
				errors.rejectValue("projectGitHubLink", "error.field.linkExist");
			}
		}
	}
}
