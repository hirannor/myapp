package myapp.core.authentication.dao.mapper;

import myapp.core.authentication.userdetails.bean.UserInfo;

/**
 * Mapper interface for AuthenticationMapper
 * 
 * @author Mate
 *
 */
public interface AuthenticationMapper
{
	UserInfo getUserInfo(String usernameOrPassword);
}
