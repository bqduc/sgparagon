package net.brilliant.auth.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.auth.entity.AccessDecisionAuthority;
import net.brilliant.auth.entity.AccessDecisionPolicy;
import net.brilliant.auth.entity.Authority;
import net.brilliant.auth.repository.AccessDecisionAuthorityRepository;
import net.brilliant.auth.repository.AccessDecisionPolicyRepository;
import net.brilliant.auth.service.AccessDecisionPolicyService;
import net.brilliant.common.ListUtility;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;


@Service
public class AccessDecisionPolicyServiceImpl extends GenericServiceImpl<AccessDecisionPolicy, Long> implements AccessDecisionPolicyService {
	private static final long serialVersionUID = 7987317340813933975L;

	@Inject 
	private AccessDecisionPolicyRepository repository;

	@Inject
	private AccessDecisionAuthorityRepository accessDecisionAuthorityRepository;
	
	protected BaseRepository<AccessDecisionPolicy, Long> getRepository() {
		return this.repository;
	}

	@Override
	public List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern) {
		return this.repository.findByAccessPattern(accessPattern);
	}

	@Override
	public List<AccessDecisionPolicy> getAccessDecisionPoliciesByAuthority(Authority authority) {
		List<AccessDecisionPolicy> fetchedResults = ListUtility.createList();
		List<AccessDecisionAuthority> accessDecisionAuthorities = accessDecisionAuthorityRepository.findByAuthority(authority);
		for (AccessDecisionAuthority accessDecisionAuthority :accessDecisionAuthorities) {
			fetchedResults.add(accessDecisionAuthority.getAccessDecisionPolicy());
		}
		return fetchedResults;//this.repository.findByAuthority(authority);
	}
}
