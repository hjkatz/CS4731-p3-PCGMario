package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class PipeDouble extends Segment{

   @Override public int attach(int start, Level level){
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 3, i, HarrisonLevel.ROCK);
         level.setBlock(start + 4, i, HarrisonLevel.ROCK);
         level.setBlock(start + 7, i, HarrisonLevel.ROCK);
         level.setBlock(start + 8, i, HarrisonLevel.ROCK);
      }
      level.setBlock(start + 1, y - 1, HarrisonLevel.TUBE_TOP_LEFT);
      level.setBlock(start + 2, y - 1, HarrisonLevel.TUBE_TOP_RIGHT);
      level.setBlock(start + 1, y, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 2, y, HarrisonLevel.TUBE_SIDE_RIGHT);
      level.setBlock(start + 1, y + 1, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 2, y + 1, HarrisonLevel.TUBE_SIDE_RIGHT);

      level.setBlock(start + 1, y - 3, HarrisonLevel.COIN);
      level.setBlock(start + 2, y - 3, HarrisonLevel.COIN);

      level.setBlock(start + 5, y - 2, HarrisonLevel.TUBE_TOP_LEFT);
      level.setBlock(start + 6, y - 2, HarrisonLevel.TUBE_TOP_RIGHT);
      level.setBlock(start + 5, y - 1, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 6, y - 1, HarrisonLevel.TUBE_SIDE_RIGHT);
      level.setBlock(start + 5, y, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 6, y, HarrisonLevel.TUBE_SIDE_RIGHT);
      level.setBlock(start + 5, y + 1, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 6, y + 1, HarrisonLevel.TUBE_SIDE_RIGHT);

      level.setBlock(start + 5, y - 4, HarrisonLevel.COIN);
      level.setBlock(start + 6, y - 4, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 8;
   }

   @Override public int getLength(){
      return 9;
   }
}
