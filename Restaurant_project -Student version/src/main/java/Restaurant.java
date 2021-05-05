import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String resName;
    private String resLocation;
    public LocalTime rsOpeningTime;
    public LocalTime rsClosingTime;
    private List<Item> menu = new ArrayList<Item>();
    LocalTime currentTime;

    public Restaurant(String resName, String resLocation, LocalTime rsOpeningTime, LocalTime rsClosingTime) {
        this.resName = resName;
        this.resLocation = resLocation;
        this.rsOpeningTime = rsOpeningTime;
        this.rsClosingTime = rsClosingTime;
    }

    public boolean isRestaurantOpen() {
        currentTime=this.getCurrentTime();
        if (currentTime.isAfter(rsOpeningTime) && currentTime.isBefore(rsClosingTime))
        {
            return true;
        }
        else {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return Collections
                .unmodifiableList(menu);
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ resName + "\n"
                +"Location:"+ resLocation + "\n"
                +"Opening time:"+ rsOpeningTime +"\n"
                +"Closing time:"+ rsClosingTime +"\n"
                +"Menu:"+"\n"+getMenu());
    }

    public String getName() {
        return resName;
    }

}