package logic;

public class Station {
	private String name;
	private int number;

	public Station(String name,int number){
		this.name = name;
//		this.number = number;
		setNumber(number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if(number<0) number = 0;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
