package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class GapSmall extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         if(x <= (start + getLength() / 2 - 2) || x >= (start + getLength() / 2 + 2)){
            level.setBlock(x, level.getHeight() - 1, HarrisonLevel.ROCK);
         }
         else{
            level.setBlock(x, level.getHeight() - 5, HarrisonLevel.COIN);
         }
      }

      return getLength();
   }

   @Override public int getDifficulty(){
      return 1;
   }

   @Override public int getLength(){
      return 15;
   }

   @Override public int getCoins(){
      return 3;
   }

   @Override public TYPE getType(){
      return TYPE.GAP; // To change body of implemented methods use File | Settings | File Templates.
   }

   @Override public int getJumps(){
      return 1;
   }
}
