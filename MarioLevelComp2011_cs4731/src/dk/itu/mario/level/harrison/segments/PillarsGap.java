package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class PillarsGap extends Segment{

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

      return getLength();
   }

   @Override public int getDifficulty(){
      return 10;
   }

   @Override public int getLength(){
      return 17;
   }

   @Override public int getCoins(){
      return 6;
   }

   @Override public TYPE getType(){
      return TYPE.GAP;
   }

   @Override public int getJumps(){
      return 2;
   }
}
