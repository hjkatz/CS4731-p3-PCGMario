package dk.itu.mario.level.harrison;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class Transition extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         for(int y = level.getHeight(); y > level.getHeight() - 2; y--){
            level.setBlock(x, y, HarrisonLevel.ROCK);
         }
      }
      return getLength();
   }

   @Override public int getDifficulty(){
      return 1;
   }

   @Override public int getLength(){
      return 5;
   }
}
