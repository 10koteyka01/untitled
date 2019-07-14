import com.sun.org.glassfish.gmbal.Description;

public class Cat {
    String eyeColor;
    private String tailColor;
    @Description("What is your name, kitty?")
    private String name;

    public Cat() {
        name = "";
    }

    Cat(String eyeColor, String tailColor, String name) {
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

    protected void printCatsTailColor(){
        System.out.println(tailColor);
    }
}
