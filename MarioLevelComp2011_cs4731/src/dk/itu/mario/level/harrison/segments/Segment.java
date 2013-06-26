package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public abstract class Segment{

   public abstract int attach(int start, Level level);

   // scale 1 - 10
   public abstract int getDifficulty();

   public boolean canAttach(int start, int maplength){
      return (maplength - (start + getLength())) > 0;
   }

   public abstract int getLength();

   public abstract int getCoins();

   public abstract TYPE getType();

   public abstract int getJumps();

   public enum TYPE{
      JUMP, GAP, ENEMY, TRANSITION
   }
}
