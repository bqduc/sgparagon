/*
* Copyright 2017, Bui Quy Duc
* by the @authors tag. See the LICENCE in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.brilliant.entity.stock;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A user.
 * 
 * @author bqduc
 */
@Data
@Entity
@Table(name = "product_catalog")
@EqualsAndHashCode(callSuper = true)
public class ProductCatalog extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8091363533819119110L;

	@ManyToOne(targetEntity=Catalogue.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "catalog_id")
	private Catalogue catalog;

	@ManyToOne(targetEntity=InventoryDetail.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private InventoryDetail product;

	public InventoryDetail getProduct() {
		return product;
	}

	public void setProduct(InventoryDetail product) {
		this.product = product;
	}

	public Catalogue getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalogue catalog) {
		this.catalog = catalog;
	}

	public static ProductCatalog getInstance(InventoryDetail product, Catalogue catalog){
		ProductCatalog instance = new ProductCatalog();
		instance.setProduct(product);
		instance.setCatalog(catalog);
		return instance;
	}
}
