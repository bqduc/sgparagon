/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class ItemDictionary extends Repository {
	private String code;
	private String category;
	private String valueMaster;
	private String valueExt1;
	private String valueExt2;
	private String valueExt3;
	private String valueExt4;
	private String valueExt5;

	public ItemDictionary(){
	}

	public ItemDictionary(ItemDictionary itemDictionary){
		fetchFromItem(itemDictionary);
	}

	public void fetchFromItem(ItemDictionary itemDictionary){
		this.code = itemDictionary.getCode();
		this.category = itemDictionary.getCategory();
		this.valueMaster = itemDictionary.getValueMaster();
		this.valueExt1 = itemDictionary.getValueExt1();
		this.valueExt2 = itemDictionary.getValueExt2();
		this.valueExt3 = itemDictionary.getValueExt3();
		this.valueExt4 = itemDictionary.getValueExt4();
		this.valueExt5 = itemDictionary.getValueExt5();
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValueMaster() {
		return valueMaster;
	}
	public void setValueMaster(String valueMaster) {
		this.valueMaster = valueMaster;
	}
	public String getValueExt1() {
		return valueExt1;
	}
	public void setValueExt1(String valueExt1) {
		this.valueExt1 = valueExt1;
	}
	public String getValueExt2() {
		return valueExt2;
	}
	public void setValueExt2(String valueExt2) {
		this.valueExt2 = valueExt2;
	}
	public String getValueExt3() {
		return valueExt3;
	}
	public void setValueExt3(String valueExt3) {
		this.valueExt3 = valueExt3;
	}
	public String getValueExt4() {
		return valueExt4;
	}
	public void setValueExt4(String valueExt4) {
		this.valueExt4 = valueExt4;
	}
	public String getValueExt5() {
		return valueExt5;
	}
	public void setValueExt5(String valueExt5) {
		this.valueExt5 = valueExt5;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ItemDictionary))
			return false;

		return super.equals(object);
		/*return 
			this.code.equals(((ItemDictionary)object).getCode())&&
			this.category.equals(((ItemDictionary)object).getCategory())&&
			this.valueMaster.equals(((ItemDictionary)object).getValueMaster())&&
			this.valueExt1.equals(((ItemDictionary)object).getValueExt1())&&
			this.valueExt2.equals(((ItemDictionary)object).getValueExt2())&&
			this.valueExt3.equals(((ItemDictionary)object).getValueExt3())&&
			this.valueExt4.equals(((ItemDictionary)object).getValueExt4())&&
			this.valueExt5.equals(((ItemDictionary)object).getValueExt5());*/
	}
}