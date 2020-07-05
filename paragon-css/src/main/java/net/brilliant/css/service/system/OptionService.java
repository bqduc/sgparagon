package net.brilliant.css.service.system;

import org.springframework.data.domain.Page;

import net.brilliant.entity.options.OptionKey;
import net.brilliant.entity.system.Option;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.service.GenericService;

public interface OptionService extends GenericService<Option, Long>{
  /**
   * Get one option with the provided code.
   * 
   * @param user The option user
   * @param key The option key
   * @return The option
   * @throws ObjectNotFoundException If no such option exists.
   */
	Option getByOptionKey(OptionKey optionKey) throws ObjectNotFoundException;

	/**
   * Get one option with the provided code.
   * 
   * @param user The option user
   * @param key The option key
   * @return The option
   * @throws ObjectNotFoundException If no such option exists.
   */
	Option getByKey(String key) throws ObjectNotFoundException;

  /**
   * Get one option with the provided code.
   * 
   * @param user The option user
   * @param key The option key
   * @return The option
   * @throws ObjectNotFoundException If no such option exists.
   */
	Option getByUserKey(String user, String key) throws ObjectNotFoundException;

  /**
   * Get one option with the provided code.
   * 
   * @param user The option user
   * @param key The option key
   * @return The option
   * @throws ObjectNotFoundException If no such option exists.
   */
	Option getOption(String key, String defaultValue) throws ObjectNotFoundException;

  /**
   * Get one option with the provided code.
   * 
   * @param user The option user
   * @param key The option key
   * @return The option
   * @throws ObjectNotFoundException If no such option exists.
   */
	Option getOption(String key, String defaultValue, boolean forUser) throws ObjectNotFoundException;


  /**
   * Get one option with the provided code.
   * 
   * @param user The option user
   * @param key The option key
   * @return The option
   * @throws ObjectNotFoundException If no such option exists.
   */
	Option getOption(OptionKey optionKey, boolean create) throws ObjectNotFoundException;

	/**
   * Get one option with the provided search parameters.
   * 
   * @param searchParameter The search parameter
   * @return The pageable system sequences
   */
	Page<Option> getObjects(SearchParameter searchParameter);
}