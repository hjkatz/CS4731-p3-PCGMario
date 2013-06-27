package dk.itu.mario.level.harrison.transitions;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;
import dk.itu.mario.level.harrison.segments.Segment;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class LongTransition extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         for(int y = level.getHeight(); y > level.getHeight() - 2; y--){
            level.setBlock(x, y, HarrisonLevel.ROCK);
         }
      }

      for(int x = start + (getLength() / 3); x < getLength() + start - (getLength() / 3); x++){
         level.setBlock(x, level.getHeight() - 2, HarrisonLevel.COIN);
      }

      return getLength();
   }

   @Override public int getDifficulty(){
      return 1;
   }

   @Override public int getLength(){
      return 15;
   }
}
