
public class Data extends Item {
	
	private int value;
	
	public Data (int v){
		value = v;
	}

	@Override
	
	public boolean isData() {
		return true;
	}
	@Override
	
	public int getValue() {
		return value;
	}
}
