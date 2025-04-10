package CharacterManager;

public class Armor {
    private int power;
    private int price;

    public Armor(int power, int price){
        this.power = power;
        this.price = price;
    }

    public int getPower(){
        return power;
    }

     public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
        
    
}
