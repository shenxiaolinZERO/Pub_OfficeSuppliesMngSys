package cn.fjnu.officeSystem.extend;

import cn.fjnu.officeSystem.entity.ItemClassificationSummary;

public class ItemClassificationSummaryExtend extends ItemClassificationSummary{

	private String itemTypeName;

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	@Override
	public String toString() {
		return "ItemClassificationSummaryExtend [itemTypeName=" + itemTypeName + ", getId()=" + getId()
				+ ", getItemId()=" + getItemId() + ", getItemName()=" + getItemName() + ", getItemTypeId()="
				+ getItemTypeId() + ", getSpec()=" + getSpec() + ", getMeasureUnitId()=" + getMeasureUnitId()
				+ ", getPrice()=" + getPrice() + ", getInventory()=" + getInventory() + ", getInventoryMonney()="
				+ getInventoryMonney() + ", getRemark()=" + getRemark() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
