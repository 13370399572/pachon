package com.feng.config;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.entity.TbUser;
import com.feng.servcie.TbUserService;


public class MyShiroRealm  extends AuthorizingRealm{
	
	@Autowired
	private TbUserService tbUserService;
	
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}
 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken uToken = (UsernamePasswordToken)token;
		 String username = uToken.getUsername();
		 TbUser user = tbUserService.selectTbUser(username);
		 if (user==null) {
			 throw new UnknownAccountException();
		}
		 if (user.getValid() == 0) {
			throw new ServiceException("您已经被禁用");
		}
		 
		 ByteSource  credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		 
		 SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user ,user.getPasswd(),credentialsSalt ,getName());
		 
		 return info;
	}

}
