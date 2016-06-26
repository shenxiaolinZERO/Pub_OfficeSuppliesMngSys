package cn.fjnu.officeSystem.Enum;

public enum RecipientState {

	ISNOTRECIPIENT(1),//未领取
	ISRECIPIENT(2);//已领取
	
	private int value;

	private RecipientState(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
}
