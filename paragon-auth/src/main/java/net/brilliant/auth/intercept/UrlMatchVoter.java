package net.brilliant.auth.intercept;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import lombok.AllArgsConstructor;
import net.brilliant.auth.service.AuthorizationService;
import net.brilliant.common.CommonConstants;

/**
 *
 * @Description: 增加一个授权逻辑投票项，根据url和httpmethod判断权限。
 *
 * @auther: csp
 * @date: 2019/1/7 下午10:03
 *
 */
@AllArgsConstructor
//@RequiredArgsConstructor
public class UrlMatchVoter implements AccessDecisionVoter<Object> {
	@Inject
	private AuthorizationService authorizationService;

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		FilterInvocation filterInvocation = null;
		if (authentication == null || CommonConstants.ANONYMOUS_USER.equals(authentication.getPrincipal())) {
			return ACCESS_DENIED;
		}

		if (object instanceof FilterInvocation) {
			filterInvocation = (FilterInvocation)object;
		}

		if (null==filterInvocation)
			return ACCESS_DENIED;

		return (!authorizationService.hasAccessDecisionPolicy(filterInvocation, authentication))?ACCESS_DENIED:ACCESS_GRANTED;
		///Keep original 
		/*
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		// 请求路径
		String url = getUrl(object);
		// http 方法
		String httpMethod = getMethod(object);

		boolean hasPerm = false;

		for (GrantedAuthority authority : authorities) {
			if (!(authority instanceof UrlGrantedAuthority))
				continue;
			
			//Check app 
			UrlGrantedAuthority urlGrantedAuthority = (UrlGrantedAuthority) authority;
			if (StringUtils.isEmpty(urlGrantedAuthority.getAuthority()))
				continue;
			// 如果method为null，则默认为所有类型都支持
			String httpMethod2 = (!StringUtils.isEmpty(urlGrantedAuthority.getHttpMethod())) ? urlGrantedAuthority.getHttpMethod() : httpMethod;
			// AntPathRequestMatcher进行匹配，url支持ant风格（如：/user/**）
			AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(urlGrantedAuthority.getAuthority(), httpMethod2);
			if (antPathRequestMatcher.matches(((FilterInvocation) object).getRequest())) {
				hasPerm = true;
				break;
			}
		}

		if (!hasPerm) {
			return ACCESS_DENIED;
		}

		return ACCESS_GRANTED;
		*/
	}

	private boolean hasAccessPermission() {
		return true;
	}
	/**
	 * 获取请求中的url
	 */
	private String getUrl(Object o) {
		// 获取当前访问url
		String url = ((FilterInvocation) o).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
			return url.substring(0, firstQuestionMarkIndex);
		}
		return url;
	}

	private String getMethod(Object o) {
		return ((FilterInvocation) o).getRequest().getMethod();
	}
}