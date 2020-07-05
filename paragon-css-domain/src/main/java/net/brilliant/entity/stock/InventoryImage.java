package net.brilliant.entity.stock;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Entity class Product
 * 
 * @author ducbq
 */
@Data
@Builder
@Entity
@Table(name = "inventory_image")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class InventoryImage extends RepoEntity {
	private static final long serialVersionUID = 9092368070849737080L;
	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private InventoryCore owner;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "image_buffer")
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] imageBuffer;

  @Column(name = "content_type", length=30)
  private String contentType;

  @Column(name = "image_name", length=100)
  private String imageName;
}
