package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class PillarsGapEasy extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         if(x - start <= 4 || x - start >= 10){
            level.setBlock(x, level.getHeight() - 1, HarrisonLevel.ROCK);
         }

         if(x - start == 4){
            level.setBlock(x, level.getHeight() - 2, HarrisonLevel.ROCK);
            level.setBlock(x, level.getHeight() - 3, HarrisonLevel.ROCK);
            level.setBlock(x, level.getHeight() - 4, HarrisonLevel.ROCK);
         }
         else
            if(x - start == 10){
               level.setBlock(x, level.getHeight() - 2, HarrisonLevel.ROCK);
               level.setBlock(x, level.getHeight() - 3, HarrisonLevel.ROCK);
               level.setBlock(x, level.getHeight() - 4, HarrisonLevel.ROCK);
               level.setBlock(x, level.getHeight() - 5, HarrisonLevel.ROCK);
               level.setBlock(x, level.getHeight() - 6, HarrisonLevel.ROCK);
            }
      }

      level.setBlock(start + 0, level.getHeight() - 2, HarrisonLevel.COIN);
      level.setBlock(start + 2, level.getHeight() - 5, HarrisonLevel.COIN);
      level.setBlock(start + 4, level.getHeight() - 5, HarrisonLevel.COIN);
      level.setBlock(start + 9, level.getHeight() - 9, HarrisonLevel.COIN);
      level.setBlock(start + 11, level.getHeight() - 8, HarrisonLevel.COIN);
      level.setBlock(start + 13, level.getHeight() - 7, HarrisonLevel.COIN);

      level.setBlock(start + 8, level.getHeight() - 3, HarrisonLevel.ROCK);
      level.setBlock(start + 9, level.getHeight() - 3, HarrisonLevel.ROCK);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 7;
   }

   @Override public int getLength(){
      return 17;
   }
}