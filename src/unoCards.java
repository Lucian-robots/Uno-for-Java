
public class unoCards {
    private String color;
    private String value;
    // color is "red", "blue", "yellow", "green"
    // values are "0", "1-9", and "Plus 2, Wild Card, Wild draw 4, Reverse, Draw 2, Skip"

    // cards will be stored: Yellow, 4  (color, value)

    public unoCards(String tempColor, String tempValue) {
        this.color = tempColor;
        this.value = tempValue;
    }
    @Override 
    public String toString() {
        return color + " " + value;
    }

}