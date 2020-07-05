package net.brilliant.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import net.brilliant.auth.domain.UserSecurityProfile;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.exceptions.NgepAuthException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface UserAccountService extends GenericService<UserAccountProfile, Long>, UserDetailsService{
    /**
     * Finds the user with the provided name.
     * 
     * @param username The user name
     * @return The user
     * @throws ObjectNotFoundException If no such user exists.
     */
	UserAccountProfile get(String username) throws ObjectNotFoundException;

	/**
	 * Create a new user with the supplied details.
	 */
	UserSecurityProfile register(UserAccountProfile user) throws NgepAuthException;

	/**
	 * Update the specified user.
	 */
	void updateUser(UserAccountProfile user);

	/**
	 * Remove the user with the given login name from the system.
	 */
	void deleteUser(String username);

	/**
	 * Modify the current user's password. This should change the user's password in the
	 * persistent user repository (database, LDAP etc).
	 *
	 * @param oldPassword current password (for re-authentication if required)
	 * @param newPassword the password to change to
	 */
	void changePassword(String oldPassword, String newPassword);

	/**
	 * Check if a user with the email exists in the system.
	 */
	boolean existsByEmail(String emailAddress);

	/**
	 * Check if a user with the supplied login name exists in the system.
	 */
	boolean userExists(String username);

	int countByLogin(String login);

	UserDetails loadUserByEmail(final String email);
	UserAccountProfile save(UserAccountProfile user);
	UserAccountProfile getUserAccount(String loginId, String password) throws NgepAuthException;
	UserAccountProfile getUserAccount(String userToken) throws NgepAuthException;
	UserAccountProfile confirm(String confirmedEmail) throws NgepAuthException;
	void initializeMasterData() throws NgepAuthException;

	
}
