import java.util.ArrayList;

public class Inventory {
    public ArrayList<String> items = new ArrayList<String>();
    public int credits = 0;
    public String character;

    public void Inventory(String characterSelection){
        character = characterSelection;
    }
    public String check(String item){

        return "";
    }
    public void add(String item){
        items.add(item);
    }
    public void money(int payment){
        credits += payment;
    }
}
