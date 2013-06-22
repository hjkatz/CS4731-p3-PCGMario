package dk.itu.mario.level.harrison;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class Transition extends Segment{

   @Override public int attach(int start, Level level){
      for(int y = 0; y < 3; y++){
         for(int x = start; x < getLength(); x++){
            level.setBlock(x, y, HarrisonLevel.GROUND);
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
