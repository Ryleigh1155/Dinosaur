
import java.util.ArrayList;
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health; // a range between 0 - 100
    private int wins;
    private int battleCount;
    private static int Population;

    /**
     * Default Constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        // initialise instance variables
        this.type = "Dino";
        this.age = 0;
        this.health = 10;
        this.gender = this.getRandGender();
        this.wins = 0;
        this.battleCount = 0;

        //write code that will assign a gender to this dino.
        //50% should be male, 50% should be female
    }

    /**
     * Explicit Constructor for the Dino Class
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.health = 10;
        this.gender = this.getRandGender();
        this.wins = 0;
        this.battleCount = 0;

    }
    
    /*********** Getter ***********/
    //Getters return private data
    public String getType()
    {
        return this.type;
    }

    public int getAge()
    {
        return this.age;
    }

    public int getHealth()
    {
        return this.health;
    }

    public String getGender()
    {
        return this.gender;
    }
    
    public int getWins()
    {
        return this.wins;
    }
    
    public int getBattleCount()
    {
        return this.battleCount;
    }
    
    public int getPop()
    {
        return this.Population;
    }
    
    /*********** Setter ***********/
    //Setters set an instance variable to a new value
    public void setType(String t)
    {
        this.type = t;
    }

    public void setAge(int a)
    {
        this.age = a;
    }

    public void setHealth(int h)
    {
        this.health = h;
    }

    public void setGender(String g)
    {
        this.gender = g;
    }
    
    public void setWins(int w)
    {
        this.wins = w;
    }
    
    public void setBattleCount(int b)
    {
        this.battleCount = b;
    }
    
    public void setPop(int p)
    {
        this.Population = p;
    }
    
    public String getRandGender()
    {
        int rand = (int)(Math.random()*2);
        if (rand == 0)
        {
            gender = "Female";
        }
        if (rand == 1)
        {
            gender = "Male";
        }
        return gender;
    }

    public boolean equals(Dinosaur d)
    {
        //write code that will return true if 2 dinos are "equal," false otherwise
        
        boolean same = false;
        if(this.getType().equals(d.getType()) && this.getGender().equals(d.getGender()))
        {
            int healthDiff = this.health-d.getHealth();
            if (Math.abs(healthDiff) < 10)
            {
                same = true;
            }
        }
        else
        {
            same = false;
        }
        return same;
    }
    
    public boolean isAMate(Dinosaur m)
    {
        boolean mates = false;
        if(this.age>7 && this.age<25 && m.getAge()>7 && m.getAge()<25)
        {
            if(this.type.equals(m.getType()) && !this.gender.equals(m.getGender()))
                mates = true;
        }
        return mates;
    }
    
    public void ageUp()
    {
        if (this.health > 0) // the dino is alive
        {
            this.age++;
            // Health decreases by 10 if age > 30
            if(this.age > 30)
            {
                health -= 10;
            }
            
            // Health decrease by 5 if age is between 25-30
            else if(this.age > 24)
            {
                health -= 5;
            }
            
            /** No change to health if age is 10-24 */
            
            //if age is less than 10, health increases by 10
            else if(this.age < 10)
            {
                health += 10;
            }
        }
    }
    
    public double getBattleFactor(Dinosaur other)
    {
       double relExp = 0;
       double healthPer = this.health/100.0;
       healthPer*=0.67;
       
       if(this.battleCount + other.getBattleCount() > 0)
       {
           relExp = (double)this.battleCount/(this.battleCount + other.getBattleCount());
           relExp*=0.33;
       }
       
       return (healthPer)+(relExp);
    }
    
    public void update(Dinosaur loser)
    {
        // reduce the health of loser and a little to winner
        // increase the wins for "this" dino
        // increase battlecount for both
        loser.setHealth((int)(loser.getHealth()*(0.25)+0.5));
        this.health-=5;
        if(loser.getHealth()<=0)
        {
            loser.setHealth(0);
        }
            
        loser.setBattleCount(loser.getBattleCount()+1);
        this.wins++;
        this.battleCount++;
        
    }
    
    public abstract boolean attack(Dinosaur other);
    
    /**
     * Return this Dino as a string
     */
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.health + " " + this.gender;
        return answer;
    }
}
