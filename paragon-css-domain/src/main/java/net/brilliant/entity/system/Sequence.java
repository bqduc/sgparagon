package net.brilliant.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoEntity;

/**
 * An attachment.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sequence")
public class Sequence extends RepoEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6042526746778066937L;

  @Column(name="seq_type")
  private Integer type;

  @Column(name="seq_serial", length=60)
  private String serial;
  
  @Builder.Default
  @Column(name="seq_number", nullable=false)
  private Long number = 0l;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
  
}
