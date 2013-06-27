package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class CeilingJumpUp extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         level.setBlock(x, level.getHeight(), HarrisonLevel.ROCK);
         level.setBlock(x, level.getHeight() - 1, HarrisonLevel.ROCK);
         level.setBlock(x, 0, HarrisonLevel.ROCK);
         level.setBlock(x, 1, HarrisonLevel.ROCK);
         level.setBlock(x, 2, HarrisonLevel.ROCK);

         if(x <= start + (getLength() - 1) / 2){
            for(int y = 0; y < level.getHeight() - 6; y++){
               level.setBlock(x, y, HarrisonLevel.ROCK);
            }
         }
         else
            if(x >= start + (getLength() - 1) / 2){
               for(int y = level.getHeight(); y > level.getHeight() - 6; y--){
                  level.setBlock(x, y, HarrisonLevel.ROCK);
               }
            }
      }

      level.setBlock(start + 2, level.getHeight() - 2, HarrisonLevel.COIN);
      level.setBlock(start + 3, level.getHeight() - 3, HarrisonLevel.COIN);
      level.setBlock(start + 4, level.getHeight() - 4, HarrisonLevel.COIN);
      level.setBlock(start + 8, level.getHeight() - 6, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 7;
   }

   @Override public int getLength(){
      return 15;
   }
}
