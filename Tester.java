import java.util.Scanner;
public class Tester
{
    public static void main(String[] args)
    {
        /* to do
        gameplay loop
        */
        double bet = 0;
        boolean playing = true;
        Cards.createDeck();
        double targed = 2000;
        double playerBet = 0;
        double dealerBet = 0;
        double response = 0;
        String pName = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name:");
        pName = input.nextLine();
        //Cards.getIndex returns a Cards object's toString();
        Dealer bongle = new Dealer(2500, "Dealer");
        Dealer player = new Dealer(2500, pName);
        while(playing == true){
            bongle.dealOut();
            player.dealOut();
            System.out.println("How much would you like to bet? \n Current balance: " + player.getBal() + "\n");
            response = input.nextDouble();
            playerBet = player.bet(response);
            dealerBet = bongle.bet(response);
            System.out.println("\n Dealer's Cards: \n");
            bongle.printCards();
            System.out.println();
            bongle.announce();
            System.out.println("\n Player's Cards: \n");
            player.printCards();
            System.out.println();
            player.announce();
            System.out.println();
            if(playerBet > dealerBet){
                player.setBal(player.getBal() + playerBet);
            } else {
                if(player.getBal() - response <= 0){
                    System.out.println("No mnoenye :<");
                    playing = false;
                } else {
                    player.setBal(player.getBal() - response);
                }
            }
        }
    }
}
