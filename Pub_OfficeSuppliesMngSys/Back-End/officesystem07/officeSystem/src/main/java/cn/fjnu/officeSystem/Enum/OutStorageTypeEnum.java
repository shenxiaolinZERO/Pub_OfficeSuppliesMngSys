package cn.fjnu.officeSystem.Enum;

public enum OutStorageTypeEnum {

	BORROW(1), // 借用
	RECIPIENT(2), // 领用
	SEND(3);// 赠予
	private int outValue;
	// 构造函数必须为private的,防止意外调用

	private OutStorageTypeEnum(int outValue) {
		this.outValue = outValue;
	}
	public int getOutValue() {
		return outValue;
	}

}
