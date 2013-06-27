package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison
 * Date: 6/26/13
 */
public class CannonFort extends Segment{

   @Override
   public int attach(int start, Level level) {
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 1, i, HarrisonLevel.ROCK);
         level.setBlock(start + 2, i, HarrisonLevel.ROCK);
         level.setBlock(start + 3, i, HarrisonLevel.ROCK);
         level.setBlock(start + 4, i, HarrisonLevel.ROCK);
         level.setBlock(start + 5, i, HarrisonLevel.ROCK);
         level.setBlock(start + 6, i, HarrisonLevel.ROCK);
      }
      level.setBlock(start + 1, y, HarrisonLevel.CANNON);
      level.setBlock(start + 2, y, HarrisonLevel.ROCK);
      level.setBlock(start + 2, y - 1, HarrisonLevel.CANNON);
      level.setBlock(start + 3, y, HarrisonLevel.ROCK);
      level.setBlock(start + 3, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 3, y - 2, HarrisonLevel.CANNON);
      level.setBlock(start + 4, y, HarrisonLevel.ROCK);
      level.setBlock(start + 4, y - 1, HarrisonLevel.CANNON);
      level.setBlock(start + 5, y, HarrisonLevel.CANNON);

      return getLength();
   }

   @Override
   public int getDifficulty() {
      return 8;
   }

   @Override
   public int getLength() {
      return 7;
   }
}
