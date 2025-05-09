public class Entity {
    private double balance;
    public void Entity(){
        balance = 2000;
    }
    public void Entity(double bal){
        balance = bal;
    }
    public double getBal(){
        return this.balance;
    }
    public void setBal(double bal){
        this.balance = bal;
    }
}
