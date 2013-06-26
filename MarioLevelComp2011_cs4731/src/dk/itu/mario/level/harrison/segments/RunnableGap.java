package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class RunnableGap extends Segment{
   @Override public int attach(int start, Level level){
      for(int y = level.getHeight(); y > level.getHeight() - 2; y--){
         level.setBlock(start, y, HarrisonLevel.ROCK);
         level.setBlock(start + 1, y, HarrisonLevel.ROCK);
         level.setBlock(start + 3, y, HarrisonLevel.ROCK);
         // level.setBlock(start + 3, y, HarrisonLevel.ROCK);
         level.setBlock(start + 5, y, HarrisonLevel.ROCK);
      }

      level.setBlock(start + 3, level.getHeight() - 2, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 2;
   }

   @Override public int getLength(){
      return 6;
   }

   @Override public int getCoins(){
      return 1;
   }

   @Override public TYPE getType(){
      return TYPE.GAP;
   }

   @Override public int getJumps(){
      return 0;
   }
}
