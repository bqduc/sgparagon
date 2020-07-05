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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A user.
 * 
 * @author bqduc
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory_item_catalog")
@EqualsAndHashCode(callSuper = true)
public class InventoryItemCatalog extends RepoAuditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364353929273399898L;

	@ManyToOne(targetEntity=Catalogue.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "catalog_id")
	private Catalogue catalog;

	@ManyToOne(targetEntity=InventoryItem.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "inventory_item_id")
	private InventoryItem inventoryItem;

	public Catalogue getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalogue catalog) {
		this.catalog = catalog;
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

}
