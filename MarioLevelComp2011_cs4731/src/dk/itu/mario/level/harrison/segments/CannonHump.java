package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison
 * Date: 6/26/13
 */
public class CannonHump extends Segment{

   @Override
   public int attach(int start, Level level) {
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 1, i, HarrisonLevel.ROCK);
         level.setBlock(start + 2, i, HarrisonLevel.ROCK);
      }
      level.setBlock(start + 1, y - 1, HarrisonLevel.CANNON);

      return getLength();
   }

   @Override
   public int getDifficulty() {
      return 4;
   }

   @Override
   public int getLength() {
      return 3;
   }
}
