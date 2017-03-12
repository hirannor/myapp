package myapp.common.dao.impl;

import org.springframework.stereotype.Repository;

import myapp.common.dao.CommonDao;
import myapp.common.dao.mapper.CommonMapper;
import myapp.common.service.bean.RegistrateRequest;

/**
 * CommonDao Implementation
 * 
 * @author Mate
 *
 */
@Repository
public class CommonDaoImpl implements CommonDao
{
	private CommonMapper commonMapper;

	public CommonDaoImpl(CommonMapper commonMapper)
	{
		if (commonMapper == null)
		{
			throw new IllegalArgumentException(commonMapper + " Bean creation error!");
		}

		this.commonMapper = commonMapper;
	}

	@Override
	public Integer insertCustomer(RegistrateRequest registrateRequest)
	{
		return commonMapper.insertCustomer(registrateRequest);
	}

	@Override
	public Integer insertUsrAuth(String username, String password)
	{
		return commonMapper.insertUsrAuth(username, password);
	}

	@Override
	public Integer insertUsrRole(String username, String role)
	{
		return commonMapper.insertUsrRole(username, role);
	}

	@Override
	public Integer resetPassword(String usernameOrEmail, String newPassword)
	{
		return commonMapper.resetPassword(usernameOrEmail, newPassword);
	}

}
