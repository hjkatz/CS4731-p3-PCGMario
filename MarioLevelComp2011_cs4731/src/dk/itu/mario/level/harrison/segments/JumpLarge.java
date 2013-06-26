package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class JumpLarge extends Segment{

   @Override public int attach(int start, Level level){
      for(int x = start; x < getLength() + start; x++){
         if(x > start + 4 && x < start + 8){
            for(int y = level.getHeight(); y > level.getHeight() - 6; y--){
               level.setBlock(x, y, HarrisonLevel.ROCK);
            }
            level.setBlock(x, level.getHeight() - 6, HarrisonLevel.COIN);
         }
         else{
            level.setBlock(x, level.getHeight() - 1, HarrisonLevel.ROCK);
         }
      }

      level.setBlock(start + 0, level.getHeight() - 2, HarrisonLevel.COIN);
      level.setBlock(start + 1, level.getHeight() - 3, HarrisonLevel.COIN);
      level.setBlock(start + 2, level.getHeight() - 4, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 5;
   }

   @Override public int getLength(){
      return 9;
   }

   @Override public int getCoins(){
      return 3;
   }

   @Override public TYPE getType(){
      return TYPE.JUMP;
   }

   @Override public int getJumps(){
      return 1;
   }
}
