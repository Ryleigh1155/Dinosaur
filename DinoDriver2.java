import java.util.ArrayList;
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class DinoDriver2
     */
    public static void main(String[] args)
    {
        //Dinosaur[] pop = new Dinosaur[25];
        ArrayList<Dinosaur> dinoPop = new ArrayList<Dinosaur>();

        for(int i = 0; i<30; i++)
        {
            double rand = Math.random();
            if(rand<0.33) //make a TRex
            {
                Dinosaur t = new TRex();
                dinoPop.add(t); //.add puts object @END of ArrayList
            }
            else if(rand<0.67) //make a Stegosaurus
            {
                dinoPop.add(1, new Stegosaurus()); //.add(index, object), moves all after +1
            }
            else //make a Triceratops
            {
                dinoPop.add(new Triceratops());
            }
        }
        /*
        for(int i = 0; i < pop.length; i++) //loop
        {
        double rand = Math.random();
        if(rand<0.33)
        pop[i] = new TRex();
        else if(rand<0.67)
        pop[i] = new Triceratops();
        else
        pop[i] = new Stegosaurus();

        DinoDriver2.growUp(pop[i]);
        }

        for(int i=0; pop.length>1 && pop[i].getHealth()>0; i++)
        //first instance a dino is dead, it stops loop
        {
        System.out.println("Round: " + (i+1));
        DinoDriver2.battleRound(pop);
        }

        //output my Pop
        //for(int i = 0; i < pop.length; i++)
        for(Dinosaur d : pop) // d gets assigned to pop[i];
        {
        if(d.getHealth() > 0)
        System.out.println(d);
        else
        System.out.println("Dead");
        }*/
    }

    private static void battleRound(ArrayList<Dinosaur> p)
    {
        //Modify this code to call the update method with the correct dinos winning and losing
        //System.out.println("\t" + p[0]);
        //System.out.println("\t" + p[1]);

        int attWins = 0;
        int battles = 0;
        //traverse the array, all dinos battle one other dino

        for(Dinosaur d /* attacker */: p)
        {
            //Check opponent is not self or at 0 health
            int indexD = p.indexOf(d);

            if(d.getHealth()>0)
            {

                int rand;

                do
                {
                    rand = (int)(Math.random()*p.size());

                }while(p.get(rand).getHealth() == 0 || d == p.get(rand));

                battles++;
                int indexRand = p.indexOf(p.get(rand));

                //boolean attackerWon = d.attack(p[rand]);
                if (d.attack(p.get(rand)))
                {
                    d.update(p.get(rand));
                    attWins++;
                    if(p.get(rand).getHealth() <=0)
                        p.remove(indexRand);
                }
                else
                {   
                    p.get(rand).update(d);
                    if(d.getHealth()<=0)
                        p.remove(indexD);
                }
            }//give battle ends

            else if(d.getHealth()<=0)
            {
                p.remove(indexD);
            }
        }//round is over
        System.out.println("Total battles: "+battles+", and attacker wins "+attWins+" time(s)");
    }

    private static void growUp(Dinosaur d) //d = t1, must be static bc main is
    {
        int rand = (int)(Math.random()*35);
        //d.setBattleCount(rand);
        for(int i = 0; i<rand; i++)
        {    
            d.ageUp();
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}
