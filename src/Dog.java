import com.sun.org.glassfish.gmbal.Description;

public class Dog {
	String eyeColor;
	public String tailColor;
	@Description("What is your name, kitty?")
	public String name;

	public Dog() {
		name = "";
	}

	Dog(String eyeColor, String tailColor, String name) {
		this.eyeColor = eyeColor;
		this.tailColor = tailColor;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printTailColor() {
		System.out.println(tailColor);
	}
}
