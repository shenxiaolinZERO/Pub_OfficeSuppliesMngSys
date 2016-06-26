package cn.fjnu.officeSystem.Enum;

public enum BorrowState {

	ISNOTBORROW(1),//未借出
	ISBORROW(2),//已借出
	ISRETURN(3);//已归还
	
	private int value;

	private BorrowState(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
}
