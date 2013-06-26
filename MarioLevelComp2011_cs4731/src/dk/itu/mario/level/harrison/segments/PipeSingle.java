package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class PipeSingle extends Segment{

   @Override public int attach(int start, Level level){
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 3, i, HarrisonLevel.ROCK);
      }
      level.setBlock(start + 1, y - 1, HarrisonLevel.TUBE_TOP_LEFT);
      level.setBlock(start + 2, y - 1, HarrisonLevel.TUBE_TOP_RIGHT);
      level.setBlock(start + 1, y, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 2, y, HarrisonLevel.TUBE_SIDE_RIGHT);
      level.setBlock(start + 1, y + 1, HarrisonLevel.TUBE_SIDE_LEFT);
      level.setBlock(start + 2, y + 1, HarrisonLevel.TUBE_SIDE_RIGHT);

      level.setBlock(start + 1, y - 3, HarrisonLevel.COIN);
      level.setBlock(start + 2, y - 3, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 3;
   }

   @Override public int getLength(){
      return 4;
   }

   @Override public int getCoins(){
      return 2;
   }

   @Override public TYPE getType(){
      return TYPE.JUMP;
   }

   @Override public int getJumps(){
      return 1;
   }
}
