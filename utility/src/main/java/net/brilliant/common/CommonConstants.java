/**
 * 
 */
package net.brilliant.common;

import java.math.BigDecimal;
import java.nio.charset.Charset;

/**
 * @author bqduc
 *
 */
public interface CommonConstants {
	static final Long ANONYMOUS_USER_ID = Long.valueOf(-1l);
	static final String ANONYMOUS_USER = "anonymousUser";
	static final String AT_SIGN = "@";
	static final String DOT_SEPARATOR = ".";
	static final String FILE_EXTENSION_SEPARATOR = ".";
	static final String FILE_PATH_SEPARATOR = "/";

	static final int BUFFER_SIZE = 1024;
	static final int MAX_POST_SIZE = 200000000;//200MB
	static final String UNDEFINED = "undefined";
	static final String DUMMY = "DUMMY";
	static final long _sequenceMinValue = 0;
	static final String ENCODING_NAME_UTF8 = Charset.forName("UTF-8").name();
	static final String ENCODING_UTF8 = "UTF8";

	static final int DUMMY_LARGE_COUNT = 5000000;
	static final String TRUE_STRING = Boolean.TRUE.toString();
	static final String PROPERTY_KEY = "id";
	static final String PROPERTY_CODE = "code";
	static final String PROPERTY_NAME = "name";
	static final String PROPERTY_NAME_LOCAL = "nameLocal";

	static final String SEPARATOR_SEMICOLON = ";";
	static final String SEPARATOR_PIPELINE = "\\|";
	static final String SEQUENCE_SEPARATOR = ".";
	static final String ZERO_PATTERN = "000000000000000";

	static final String OPTION_ENABLED = "on";
	static final String OPTION_DISABLED = "off";

	static final String DEFAULT_MODULE_ID = "main";

	static final Object EMPTY_DATA = null;

	static final int VARIANCE_SIZE = 41599; // Equivalent to 40KB

	static final int DECIMAL_DIGITS = 1;
	static final int SUCCESS_STATE_VALUE = 1;
	static final int FAILURE_STATE_VALUE = 0;

	/*static final byte		LENGTH_OBJECT_SERIAL = 15;
	static final byte		LENGTH_OBJECT_CODE = 20;//Including the backup part
	static final byte		LENGTH_CURRENCY_CODE = 5;
	static final byte		LENGTH_ZIP_POSTAL_CODE = 7;
	static final short	LENGTH_OBJECT_NAME = 250;*/

	static final String UNFINISHED_PATTERN = "unfinished";
	static final String REST_API_SEPARATOR = "/";

	static final String STRING_WILDCARD = "%";

	static final String STRING_SPACE = " ";
	static final String STRING_BLANK = "";
	static final String SEPARATOR_PHONE = "-";
	static final String SEPARATOR_ADDRESS = ", ";
	
	static final String LEFT_BRACKET = "[";
	static final String RIGHT_BRACKET = "]";
	static final String STRING_BLANK_CAPTION = LEFT_BRACKET + RIGHT_BRACKET;

	static final String PERSPECTIVE_DEFAULT_EN = "en";
	static final String PERSPECTIVE_DEFAULT_VI = "vi";
	
	static final int ENTITY_REFERENCE_SIZE = 15;

	static final int NUMBER_OF_IMAGE_COPIES = 256;
	static final String AVATAR_JPG = "avatar.jpg";
	static final int AVATAR_SIZE = 80;
	static final int DEFAULT_IMAGE_SIZEVALUE = 120;
	static final String SLASH = "/";
	static final String DOT = ".";
	static final String JPEG = "jpeg";
	static final String JPG = "JPG";
	static final String UPLOAD_ROOT_COMPONENT_NAME = "uploadRoot";
	static final String UPLOAD_ROOT_PATH_COMPONENT_NAME = "uploadRootPath";
	static final int INITIAL_DELAY = 4000;
	static final int DELAY = 3000;
	static final String DEFAULT_PICTURE = "default/noimage_small200.jpg";
	static final String DEFAULT_ORIGINAL_PICTURE = "default/noimage.jpg";
	static final int DEFAULT_BUFFER_SIZE = 20480;//20KB //8192;
	static final String UPLOAD = "upload";
	static final String FEMALE = "Female";
	static final String MALE = "Male";
	static final String TEMP_DIR = "java.io.tmpdir";
	static final String WEB_INF = "WEB-INF";
	static final String IMAGE_FOLDER = "/Upload";
	static final String PHOTOALBUM_FOLDER = "richfaces_photoalbum";

	//Persistence constants
	static final String BEAN_PROPERTY_OBJECT_ID = "id";
	static final String BEAN_PROPERTY_CODE = "code";
	static final String BEAN_PROPERTY_NAME = "name";
	static final String BEAN_PROPERTY_ACTIVE = "active";
	static final String BEAN_PROPERTY_SYSTEM = "system";
	static final String BEAN_PROPERTY_MODULE = "module";
	static final String BEAN_PROPERTY_TYPE = "type";

	//Service -constants
	static final String USER_EXIST_QUERY = "user-exist";
	static final String USER_LOGIN_QUERY = "user-login";
	static final String LOGIN_PARAMETER = "login";
	static final String PASSWORD_PARAMETER = "password";
	static final String USERNAME_PARAMETER = "username";
	static final String USER_PARAMETER = "user";
	static final String DATE_PARAMETER = "date";
	static final String ALBUM_PARAMETER = "album";
	static final String COMMA = ",";
	static final String PERCENT = "%";
	static final String TAG_SUGGEST_QUERY = "tag-suggest";
	static final String TAG_POPULAR_QUERY = "tag-popular";
	static final String TAG_PARAMETER = "tag";
	static final String TAG_BY_NAME_QUERY = "tag-byName";
	static final String SEARCH_QUERY_SHARED_ADDON = " and sh.shared=true";
	static final String SEARCH_QUERY_MY_ADDON = " and sh.owner.login=:login";
	static final String SEARCH_SHELVES_QUERY = "from Shelf sh where (lower(sh.name) like :name or lower(sh.info) like :name) ";
	static final String SEARCH_METATAG_QUERY = "from MetaTag t where lower(t.tag) like :name";
	static final String SEARCH_USERS_QUERY = "select  u from User u where (lower(u.login) like :name or lower(u.firstName) like :name or lower(u.secondName) like :name) ";
	static final String SEARCH_IMAGE_SHARED_ADDON = " and i.album.shelf.shared=true";
	static final String SEARCH_IMAGE_MY_ADDON = " and i.album.shelf.owner.login=:login";
	static final String SEARCH_IMAGE_QUERY = "from Image i where (lower(i.name) like :name or lower(i.info) like :name or lower(i.cameraModel) like :name) ";
	static final String SHARED_PARAMETER = "shared";
	static final String NAME_PARAMETER = "name";
	static final String SEARCH_ALBUM_SHARED_ADDON = " and a.shelf.shared=true";
	static final String SEARCH_ALBUM_MY_ADDON = " and a.shelf.owner.login=:login";
	static final String SEARCH_ALBUM_QUERY = "from Album a where (lower(a.name) like :name or lower(a.info) like :name)";
	static final String USER_SHELVES_QUERY = "user-shelves";
	static final String SHELF_PARAMETER = "shelf";
	static final String PATH_PARAMETER = "path";
	static final String IMAGE_PATH_EXIST_QUERY = "image-exist";
	static final String IMAGE_IDENTICAL_QUERY = "image-countIdenticalImages";
	static final String SEARCH_NO_OPTIONS_ERROR = "You must select at least one search option";
	static final String TREE_ID = "treeform";
	static final String USER_COMMENTS_QUERY = "user-comments";
	static final String AUTHOR_PARAMETER = "author";
	static final String EMAIL_EXIST_QUERY = "email-exist";
	static final String EMAIL_PARAMETER = "email";
	
	static final String ENTITY_MANAGER_CACHED = "entity.manager";

	static final String CLAUSE_SELECT = " SELECT ";
	static final String CLAUSE_FROM = " FROM ";
	static final String CLAUSE_AND = " AND ";
	static final String CLAUSE_WHERE = " WHERE ";
	static final String CLAUSE_ORDER_BY = " ORDER BY ";

	static final String COMPONENT_ENTITY_MANAGER = "entityManager";
	static final String COMPONENT_ORGANIZATION_MANAGER = "organizationManager";
	static final String CONTEXT_INVENTORY_SERVICE = "contextInventoryService";
	static final String CONTEXT_EXECUTION = "contextExecution";
	static final String CONTEXT_CAST_MARHSALLER = "contextCastMarshaller";
	
	
	static final String SYSTEM_COUNTRY_CODE = "VN";
	static final String SYSTEM_CURRENCY_CODE = "VND";
  static final String SYSTEM_CURRENCYDEC_CODE = "₫";

	static String globalCurrencyCode = SYSTEM_CURRENCY_CODE;//"USD";

	static final String REMOTE_API_PATTERN = "/rest/";

	static final String REST_API_REQUEST_URL = "apiUrl";
	static final String REST_API_REQUEST_METHOD = "method";
	static final String REST_API_REQUEST_CONTENT_TYPE = "contentType";

	static final String AUTHENTICATED_ATTRIBUTE = "authInfo";
	
	static final int REST_API_STATUS_OK = 200;
	static final int REST_API_STATUS_FAILED = 201;
	static final int REST_API_STATUS_INVALID_TOKEN = 498;
	static final int REST_API_TOKEN_LENGTH = 12;

	static final String REST_API_EXECUTE_SUCCESS = "SUCCESS";
	static final String REST_API_EXECUTE_FAILURE = "FAILURE";
	
	static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

	static final String PARAM_OPERATION = "operation";
	static final String PARAM_DATA = "data";
	
	
	
	//TODO: Have to refactor
	static final String SPRING_PROFILE_DEVELOPMENT = "dev";
	static final String SPRING_PROFILE_PRODUCTION = "prod";

	static final String REST_API = "/rapi/";

	static final String LIST_CATEGORY = "categoryList";
	static final String LIST_DEPARTMENT = "departmentList";

	static final String FETCHED_MASTER_OBJECT = "fetchedMasterObject";

	static final String FETCHED_OBJECT = "fetchedObject";
	static final String FETCHED_OBJECTS = "fetchedObjects";

	static final String REALM = "MY_TEST_REALM";

	static final String REQUEST_CLERK = "requestClerk";
	static final String REQUEST_CLIENT = "requestClient";

	static final Integer DEFAULT_PAGE_BEGIN = 0;
	static final Integer DEFAULT_PAGE_SIZE = 50;

	static final String HEADER_AUTHORIZED = "Authorization";
	

	//Controllers 
	static final String CONTROLLER_MODULE = "module";
	static final String CONTROLLER_AUTHORITY = "authority";

	static final String CACHED_PAGE_MODEL = "cachedModel";
	
	static final int PAGE_SIZE_INFINITELY = -1;
	
	static final int MAX_DUMMY_OBJECTS = 297;

	
	static final String PARAM_SEARCH_PATTERN = "searchPattern";
	static final String PARAM_KEYWORD = "keyword";
	static final String PARAM_PAGE = "page";
	static final String PARAM_PAGE_SIZE = "size";

	static final String PARAM_PAGEABLE = "pageable";

	static final String CONFIGURED_CONTROLLER = "configuredController";

	static final String AUTHORITY_LIST = "authorityList";
}
