package myapp.core.authentication.dao;

import myapp.core.authentication.userdetails.bean.UserInfo;

/**
 * DAO for Authentication
 * 
 * @author Mate
 *
 */
public interface AuthenticationDao
{
	/**
	 * Method for getting user credentials from database
	 * 
	 * @param username
	 * @return @{link UserInfo}
	 */
	UserInfo getUserInfo(String usernameOrPassword);
}
