/**
 * 
 */
package net.brilliant.lingual.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoEntity;

/**
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
		name = "message_label", 
		uniqueConstraints={@UniqueConstraint(columnNames = {"key", "language"})
})
public class MessageLabel extends RepoEntity {
	private static final long serialVersionUID = 5150863975442948556L;

	@Column(name = "language", length = 5)
	private String language;

	@Column(name = "key", length = 150)
	private String key;

	@Column(name = "content")
	private String content;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
