package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		/* FILL CODE */
		if(type<0 || type>2)type = 1;
		this.type = type;

		if(type == 2)priceperstation = 25;
		else priceperstation = 30;
	}
	
	public void setStation(Station start,Station end) {
		/* FILL CODE */
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		/* FILL CODE */
		double tt = getStationDistance(start,end) * priceperstation;

		if(type == 0){
			if(getStationDistance(start,end) > 4) tt *= 0.8;
		}else if(type == 2){
			tt *= 0.6;
		}
		if(!isStationValid(start,end)) return -1;
		return tt;
	}
	
	public String getDescription() {
		String typename;
		if(!isStationValid(start, end)) {
			return "Invalid Ticket, from " + start.getName() + " to " + end.getName();
		}
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			//FILL CODE
			typename = "Adult";
			break;
		case 2:
			//FILL CODE
			typename = "Elderly";
			break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+/* FILL CODE */start.getName()+" to "+/* FILL CODE */end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public static int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
