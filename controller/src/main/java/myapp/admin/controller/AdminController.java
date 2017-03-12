package myapp.admin.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myapp.core.bean.Role;

/**
 * 
 * @author Mate
 *
 */
@Controller
@Secured(Role.ADMIN)
@RequestMapping(value = "/admin/")
public class AdminController
{

	@RequestMapping(value = "authenticatedUser", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody Authentication getAuthenticatedUser()
	{
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
