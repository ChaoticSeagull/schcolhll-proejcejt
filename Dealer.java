import java.util.Arrays;
public class Dealer extends Entity{
    private int rep;
    private int min = 0;
    private int rand;
    private int max = 51;
    private double betAmount = 0;
    private double betPower = 0;
    private double handPower = 0;
    private int[] hand = {-1,-1,-1,-1,-1,-1,-1,-1};
    private boolean interactable;
    private String name = "";
    public Dealer(double bal, String nm){
        this.rep = 10;
        this.setBal(bal);
        this.name = nm;
        interactable = true;
    }
    public void setCard(int card, int val){
        card -= 1;
        hand[card] = val;
    }
    public int getHand(int i){
        return hand[i];
    }
    public int getRandom(){
        rand = (int) (Math.random() * (max - min + 1) + min);
        return rand;
    }
    public boolean isRoyalFlush(){
        boolean temp = false;
        int first = 9;
        int second = 9;
        int third = 9;
        int fourth = 9;
        int val = -1;
        int over = 10;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getSuit() == Cards.getIndex(hand[i+1]).getSuit() && Cards.getIndex(hand[i]).getValue() > over && Cards.getIndex(hand[i+1]).getValue() > over){
                first = hand[i];
                second = hand[i+1];
                val = Cards.getIndex(hand[i]).getSuit();
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second){
                if(Cards.getIndex(hand[i]).getSuit() == val && Cards.getIndex(hand[i]).getValue() > over){
                    third = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third){
                if(Cards.getIndex(hand[i]).getSuit() == val && Cards.getIndex(hand[i]).getValue() > over){
                    fourth = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third && hand[i] != fourth){
                if(Cards.getIndex(hand[i]).getSuit() == val && Cards.getIndex(hand[i]).getValue() > over){
                    temp = true;
                }
            }
        }
        return temp;
    }
    public boolean isStraightFlush(){
        boolean temp = false;
        int count = 0;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() - Cards.getIndex(hand[i+1]).getValue() == 1 && Cards.getIndex(hand[i]).getSuit() == Cards.getIndex(hand[i+1]).getSuit()){
                count++;
            }
            if(count >= 5){
                return true;
            }
        }
        return false;
    }
    
    public boolean isStraight(){
        boolean temp = false;
        int count = 0;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() - Cards.getIndex(hand[i+1]).getValue() == 1){
                count++;
            }
            if(count >= 5){
                return true;
            }
        }
        return false;
    }
    public boolean isFlush(){
        boolean temp = false;
        int first = 9;
        int second = 9;
        int third = 9;
        int fourth = 9;
        int val = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getSuit() == Cards.getIndex(hand[i+1]).getSuit()){
                first = hand[i];
                second = hand[i+1];
                val = Cards.getIndex(hand[i]).getSuit();
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second){
                if(Cards.getIndex(hand[i]).getSuit() == val){
                    third = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third){
                if(Cards.getIndex(hand[i]).getSuit() == val){
                    fourth = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third && hand[i] != fourth){
                if(Cards.getIndex(hand[i]).getSuit() == val){
                    temp = true;
                }
            }
        }
        return temp;
    }
    
    public boolean isFullHouse(){
        boolean temp = false;
        int evilPair = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue()){
                temp = true;
                evilPair = Cards.getIndex(hand[i]).getValue();
            }
        }
        boolean tempp = false;
        int first = 9;
        int second = 9;
        int val = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue() && Cards.getIndex(hand[i]).getValue() != evilPair){
                first = hand[i];
                second = hand[i+1];
                val = Cards.getIndex(hand[i]).getValue();
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && Cards.getIndex(hand[i]).getValue() != evilPair){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    tempp = true;
                }
            }
        }
        if(temp == true && tempp == true){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFiveOfAKind(){
        boolean temp = false;
        int first = 9;
        int second = 9;
        int third = 9;
        int fourth = 9;
        int val = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue()){
                first = hand[i];
                second = hand[i+1];
                val = Cards.getIndex(hand[i]).getValue();
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    third = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    fourth = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third && hand[i] != fourth){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    temp = true;
                }
            }
        }
        return temp;
    }   
    public boolean isFourOfAKind(){
        boolean temp = false;
        int first = 9;
        int second = 9;
        int third = 9;
        int val = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue()){
                first = hand[i];
                second = hand[i+1];
                val = Cards.getIndex(hand[i]).getValue();
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    third = hand[i];
                }
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second && hand[i] != third){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    temp = true;
                }
            }
        }    
        return temp;
    }
    public boolean isThreeOfAKind(){
        boolean temp = false;
        int first = 9;
        int second = 9;
        int val = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue()){
                first = hand[i];
                second = hand[i+1];
                val = Cards.getIndex(hand[i]).getValue();
            }
        }
        for(int i = 0; i < 8; i++){
            if(hand[i] != first && hand[i] != second){
                if(Cards.getIndex(hand[i]).getValue() == val){
                    temp = true;
                }
            }
        }
        return temp;
    }
    public boolean isTwoPair(){
        boolean temp = false;
        boolean test = false;
        int first = -1;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue()){
                first = Cards.getIndex(hand[i]).getValue();
                test = true;
            }
        }
        if(test == true){
            for(int x = 0; x < 7; x++){
                if(Cards.getIndex(hand[x]).getValue() == Cards.getIndex(hand[x+1]).getValue() && first != Cards.getIndex(hand[x]).getValue()){
                    temp = true;
                }
            }
        }   
        return temp;
    }
    public boolean isPair(){
        boolean temp = false;
        for(int i = 0; i < 7; i++){
            if(Cards.getIndex(hand[i]).getValue() == Cards.getIndex(hand[i+1]).getValue()){
                temp = true;
                
            }
        }
        return temp;
    }
    public int highCard(){
        int highest = 0;
        for(int i = 0; i < 8; i++){
            if(highest < Cards.getIndex(hand[i]).getValue()){
                highest = Cards.getIndex(hand[i]).getValue();
            }
        }
        return highest;
    }
    public void printCards(){
        for(int i = 0; i < 8; i++){
            System.out.println(Cards.getIndex(hand[i]).toString());
        }
    }
    public void dealOut(){
        for(int i = 0; i < 8; i++){
            rand = (int) (Math.random() * (max - min + 1) + min);
            hand[i] = rand;
        }
        for (int i = 0; i < hand.length; i++) {

            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < hand.length; j++) {

                // Checking elements
                int temp = 0;
                if (Cards.getIndex(hand[j]).getValue() < Cards.getIndex(hand[i]).getValue()) {

                    // Swapping
                    temp = hand[i];
                    hand[i] = hand[j];
                    hand[j] = temp;
                }
            }
        }
    }
    public double bet(double s){
        this.betAmount = s;
        this.betPower = this.highCard();
        if(this.isRoyalFlush() == true){
            this.betPower = 10000;
        } else if(this.isStraightFlush() == true){
            this.betPower = 7500;
        } else if(this.isFiveOfAKind() == true){
            this.betPower = 10;
        } else if(this.isFourOfAKind() == true){
            this.betPower = 7.5;
        } else if(this.isFullHouse() == true){
            this.betPower = 6;
        } else if(this.isFlush() == true){
            this.betPower = 5;
        } else if(this.isStraight() == true){
            this.betPower = 4.5;
        } else if(this.isThreeOfAKind() == true){
            this.betPower = 2.5;
        } else if(this.isTwoPair() == true){
            this.betPower = 1.75;
        } else if(this.isPair() == true){
            this.betPower = 1.5;
        }
        this.handPower = this.betAmount * this.betPower;
        return this.handPower;
    }
    public void announce(){
        if(this.isRoyalFlush() == true){
            System.out.println(this.name + " just scored a " + "Royal Flush!");
        } else if(this.isStraightFlush() == true){
            System.out.println(this.name + " just scored a " + "Straight Flush!");
        } else if(this.isFiveOfAKind() == true){
            System.out.println(this.name + " just scored a " + "Five of a Kind!");
        } else if(this.isFourOfAKind() == true){
            System.out.println(this.name + " just scored a " + "Four of a Kind!");
        } else if(this.isFullHouse() == true){
            System.out.println(this.name + " just scored a " + "Full House!");
        } else if(this.isFlush() == true){
            System.out.println(this.name + " just scored a " + "Flush!");
        } else if(this.isStraight() == true){
            System.out.println(this.name + " just scored a " + "Straight!");
        } else if(this.isThreeOfAKind() == true){
            System.out.println(this.name + " just scored a " + "Three of a Kind!");
        } else if(this.isTwoPair() == true){
            System.out.println(this.name + " just scored a " + "Two Pair!");
        } else if(this.isPair() == true){
            System.out.println(this.name + " just scored a " + "Pair!");
        } else {
            System.out.println(this.name + " just scored a " + "High Card!");
        }
    }
    public void win(){
        rep--;
        if(rep <= 0){
            interactable = false;
        }
    }
}
