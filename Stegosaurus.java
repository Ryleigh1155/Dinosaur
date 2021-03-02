
/**
 * Write a description of class Stegosaurus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stegosaurus extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten; //specific to the Stegosaurus class and not Dinosaur

    /**
     * Constructor for objects of class Stegosaurus
     */
    public Stegosaurus()
    {
        // super() --> Must be the first line of a constructor
        super("Stegosaurus"); //Calls the explicit constructor of the parent class
        
        this.numEaten = 0;
        
    }

    public boolean attack(Dinosaur other)
    {
        boolean win = false;
        int rand = (int)(Math.random()*45+55);
        int otherRand = 0;
        
        double attacker = rand*this.getBattleFactor(other);
        double temp1 = attacker+0.5;
        int myWeighting = (int)(temp1);
        
        if(other.getType().equals("TRex"))
            otherRand = (int)(Math.random()*45)+55;
        else if(other.getType().equals("Stegosaurus"))
            otherRand = (int)(Math.random()*50)+50;
        else if(other.getType().equals("Triceratops"))
            otherRand = (int)(Math.random()*60)+40;
        else
            System.out.println("Defender type unknown");
       
        double defender = otherRand*other.getBattleFactor(this);
        double temp2 = defender+0.5;
        int otherWeighting = (int)(temp2);
        
        if(myWeighting-otherWeighting>0)
        {
            win = true;
        }
        if(myWeighting-otherWeighting<0)
        {
            win = false;
        }
        
        System.out.println("My Weighting: " + myWeighting);
        System.out.println("Other Weighting: " + otherWeighting);
        return win;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        // put your code here
        if(this.getAge() == 0)
        {
            return super.toString();
        }
        
        else{
            return this.getType() + " " +  this.getWins() + " " + this.getBattleCount();
        }
    }
}
