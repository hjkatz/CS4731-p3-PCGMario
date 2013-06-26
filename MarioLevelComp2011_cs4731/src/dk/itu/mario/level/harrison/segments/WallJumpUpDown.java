package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class WallJumpUpDown extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         level.setBlock(x, level.getHeight(), HarrisonLevel.ROCK);
         level.setBlock(x, level.getHeight() - 1, HarrisonLevel.ROCK);
         level.setBlock(x, 0, HarrisonLevel.ROCK);
         level.setBlock(x, 1, HarrisonLevel.ROCK);
         level.setBlock(x, 2, HarrisonLevel.ROCK);

         if(x < start + 5){
            for(int y = 0; y < level.getHeight() - 3; y++){
               level.setBlock(x, y, HarrisonLevel.ROCK);
            }
         }
         else
            if(x < start + 10 && x > start + 5){
               for(int y = level.getHeight(); y > level.getHeight() - 7; y--){
                  level.setBlock(x, y, HarrisonLevel.ROCK);
               }
            }
            else
               if(x > start + 10){
                  for(int y = 0; y < level.getHeight() - 3; y++){
                     level.setBlock(x, y, HarrisonLevel.ROCK);
                  }
               }
      }

      level.setBlock(start + 5, level.getHeight() - 5, HarrisonLevel.COIN);
      level.setBlock(start + 5, level.getHeight() - 9, HarrisonLevel.COIN);
      level.setBlock(start + 7, level.getHeight() - 11, HarrisonLevel.COIN);
      level.setBlock(start + 10, level.getHeight() - 10, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 9;
   }

   @Override public int getLength(){
      return 15;
   }

   @Override public int getCoins(){
      return 4;
   }

   @Override public TYPE getType(){
      return TYPE.JUMP;
   }

   @Override public int getJumps(){
      return 2;
   }
}
