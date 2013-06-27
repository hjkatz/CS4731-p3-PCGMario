package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/25/13
 */
public class PlatformGap extends Segment{
   @Override public int attach(int start, Level level){
      for(int y = level.getHeight(); y > level.getHeight() - 2; y--){
         level.setBlock(start, y, HarrisonLevel.ROCK);
         level.setBlock(start + 1, y, HarrisonLevel.ROCK);
         level.setBlock(start + 2, y, HarrisonLevel.ROCK);
         level.setBlock(start + 6, y, HarrisonLevel.ROCK);
         level.setBlock(start + 7, y, HarrisonLevel.ROCK);
         level.setBlock(start + 8, y, HarrisonLevel.ROCK);
         level.setBlock(start + 9, y, HarrisonLevel.ROCK);
         level.setBlock(start + 10, y, HarrisonLevel.ROCK);
      }

      level.setBlock(start + 3, level.getHeight() - 5, HarrisonLevel.BLOCK_EMPTY);
      level.setBlock(start + 4, level.getHeight() - 5, HarrisonLevel.BLOCK_EMPTY);
      level.setBlock(start + 5, level.getHeight() - 5, HarrisonLevel.BLOCK_EMPTY);
      level.setBlock(start + 6, level.getHeight() - 5, HarrisonLevel.BLOCK_EMPTY);
      level.setBlock(start + 7, level.getHeight() - 5, HarrisonLevel.BLOCK_EMPTY);

      level.setBlock(start + 6, level.getHeight() - 6, HarrisonLevel.COIN);
      level.setBlock(start + 7, level.getHeight() - 2, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 7;
   }

   @Override public int getLength(){
      return 11;
   }
}
