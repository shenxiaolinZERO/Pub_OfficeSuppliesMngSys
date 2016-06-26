package cn.fjnu.officeSystem.Enum;

public enum ValidetaState {

	VALIDATE(1),
	INVALIDATE(0);
	
	private int value;

	private ValidetaState(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
