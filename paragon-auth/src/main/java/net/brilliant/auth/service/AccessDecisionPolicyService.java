package net.brilliant.auth.service;

import java.util.List;

import net.brilliant.auth.entity.AccessDecisionPolicy;
import net.brilliant.auth.entity.Authority;
import net.brilliant.framework.service.GenericService;

public interface AccessDecisionPolicyService extends GenericService<AccessDecisionPolicy, Long> {
	List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern);
	List<AccessDecisionPolicy> getAccessDecisionPoliciesByAuthority(Authority authority);
}
