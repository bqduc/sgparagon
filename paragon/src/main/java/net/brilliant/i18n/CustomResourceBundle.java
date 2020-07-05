 package net.brilliant.i18n;

import org.springframework.stereotype.Component;

import net.brilliant.common.CommonConstants;

/**
 * Adds support for UTF-8 based bundles for admin i18n messages
 * 
 * Taken from: https://stackoverflow.com/a/3646601/1260910
 *
 * @author rafael-pestano
 */
 @Component
public class CustomResourceBundle extends MultiplePropertiesResourceBundle {

    protected static final String BUNDLE_NAME = "admin";
    protected static final String BUNDLE_EXTENSION = "properties";
    protected static final String CHARSET = CommonConstants.ENCODING_NAME_UTF8;
    
    static String i18nMvp = "";
    static {
      i18nMvp = "i18n.mvp";
    }

    public CustomResourceBundle() {
    	//super("i18n/*." + BUNDLE_EXTENSION);
    	//super("net.paragon.resources.i18n", "*.properties");//ok. Fine
    	super(new String[] {"i18n", "i18n.admin", "i18n.general", i18nMvp}, 
    			"*.properties");//ok. Fine
    }
}
