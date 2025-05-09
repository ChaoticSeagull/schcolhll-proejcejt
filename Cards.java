import java.util.ArrayList;
public class Cards {
    private int suit;
    private int value;
    public static String[] deckNames = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52"};
    private static int index = 0;
    private static String temp;
    public static ArrayList<Cards> deck = new ArrayList<Cards>();
    public static void createDeck(){
    for(int s = 0; s < 4; s++){
        for(int v = 0; v < 13; v++){
            temp = deckNames[index];
            Cards temp = new Cards(v,s);
            deck.add(temp);
            index++;
            }
        }
    }
    public static Cards getIndex(int temp){
        return deck.get(temp);
    }
    public int getSuit(){
        return this.suit;
    }
    public int getValue(){
        return this.value;
    }
    public Cards(int val, int st){
        this.value = val;
        this.suit = st;
    }
    
    public String getSuits(){
        if(this.suit == 0){
            return "Hearts";
        } else if(this.suit == 1){
            return "Diamonds";
        } else if(this.suit == 2){
            return "Spades";
        } else if(this.suit == 3){
            return "Clubs";
        } else {
            return "Null Suit";
        }
    }
    public String getVals(){
        if(this.value == 0){
            return "Ace of ";
        } else if(this.value == 1){
            return "Two of ";
        } else if(this.value == 2){
            return "Three of ";
        } else if (this.value == 3){
            return "Four of ";
        } else if (this.value == 4){
            return "Five of ";
        } else if (this.value == 5){
            return "Six of ";
        } else if (this.value == 6){
            return "Seven of ";
        } else if (this.value == 7){
            return "Eight of ";
        } else if (this.value == 8){
            return "Nine of ";
        } else if (this.value == 9){
            return "Ten of ";
        } else if (this.value == 10){
            return "Jack of ";
        } else if (this.value == 11){
            return "Queen of ";
        } else if (this.value == 12){
            return "King of ";
        } else {
            return "Null Value of ";
        }
    }
    public String toString(){
        return this.getVals()+this.getSuits();
    }
    
}
