package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class DoubleEnemy extends Segment{

   @Override public int attach(int start, Level level){
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 1, i, HarrisonLevel.ROCK);
         level.setBlock(start + 2, i, HarrisonLevel.ROCK);
         level.setBlock(start + 3, i, HarrisonLevel.ROCK);
         level.setBlock(start + 4, i, HarrisonLevel.ROCK);

         int enemyType = (int) HarrisonLevel.enemyTypes.get(HarrisonLevel.random.nextInt(HarrisonLevel.enemyTypes.size()));
         level.setSpriteTemplate(start + 1, y - 1, new SpriteTemplate(enemyType, false));
         level.setSpriteTemplate(start + 3, y - 1, new SpriteTemplate(enemyType, false));
      }

      return getLength();
   }

   @Override public int getDifficulty(){
      return 3;
   }

   @Override public int getLength(){
      return 5;
   }
}
