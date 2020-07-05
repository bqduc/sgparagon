/**
 * 
 */
package net.brilliant.context;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import net.brilliant.lingual.entity.MessageLabel;

/**
 * @author ducbq
 *
 */
public interface MessagePersistenceService extends MessageSource {
	Map<String, String> getMessagesMap(Locale locale);
	List<MessageLabel> getMessages(Locale locale);
	void saveMessage(String key, String content, Locale locale);
}
