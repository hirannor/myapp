package myapp.core.authorization.dao.mapper;

import org.apache.ibatis.annotations.Param;

import myapp.core.authorization.service.bean.IsAuthorizedReply;
import myapp.core.authorization.service.bean.IsAuthorizedRequest;

public interface AuthorizationMapper
{
	IsAuthorizedReply isAuthorized(@Param("request") IsAuthorizedRequest isAuthorizedRequest);
}
