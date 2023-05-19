package donuts;

public class Donuts {
	
	private int donutID;
	private String Donut_name;
	private float Donut_price;
	
	

	//constructor 
	public Donuts(int donutID, String donut_name, float donut_price) {
		super();
		this.donutID = donutID;
		Donut_name = donut_name;
		Donut_price = donut_price;
	}


	public int getDonutID() {
		return donutID;
	}


	public void setDonutID(int donutID) {
		this.donutID = donutID;
	}


	public String getDonut_name() {
		return Donut_name;
	}


	public void setDonut_name(String donut_name) {
		Donut_name = donut_name;
	}


	public float getDonut_price() {
		return Donut_price;
	}


	public void setDonut_price(float donut_price) {
		Donut_price = donut_price;
	}
	
	public void printDonut() {
		String name = Donut_name;
		float price = Donut_price;
		
		System.out.print("DonutID:"+ donutID +"\t Donut name: " + name + "\t Donut price: " + price );
	}

}
