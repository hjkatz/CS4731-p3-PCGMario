package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class SpacedFiverEnemy extends Segment{

   @Override public int attach(int start, Level level){
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 1, i, HarrisonLevel.ROCK);
         level.setBlock(start + 2, i, HarrisonLevel.ROCK);
         level.setBlock(start + 3, i, HarrisonLevel.ROCK);
         level.setBlock(start + 4, i, HarrisonLevel.ROCK);
         level.setBlock(start + 5, i, HarrisonLevel.ROCK);
         level.setBlock(start + 6, i, HarrisonLevel.ROCK);
         level.setBlock(start + 7, i, HarrisonLevel.ROCK);
         level.setBlock(start + 8, i, HarrisonLevel.ROCK);
         level.setBlock(start + 9, i, HarrisonLevel.ROCK);
         level.setBlock(start + 10, i, HarrisonLevel.ROCK);
         level.setBlock(start + 11, i, HarrisonLevel.ROCK);
         level.setBlock(start + 12, i, HarrisonLevel.ROCK);
         level.setBlock(start + 13, i, HarrisonLevel.ROCK);
         level.setBlock(start + 14, i, HarrisonLevel.ROCK);

         int enemyType = (int) HarrisonLevel.enemyTypes.get(HarrisonLevel.random.nextInt(HarrisonLevel.enemyTypes.size()));
         level.setSpriteTemplate(start + 1, y - 1, new SpriteTemplate(enemyType, false));
         level.setSpriteTemplate(start + 4, y - 1, new SpriteTemplate(enemyType, false));
         level.setSpriteTemplate(start + 7, y - 1, new SpriteTemplate(enemyType, false));
         level.setSpriteTemplate(start + 10, y - 1, new SpriteTemplate(enemyType, false));
         level.setSpriteTemplate(start + 13, y - 1, new SpriteTemplate(enemyType, false));
      }

      return getLength();
   }

   @Override public int getDifficulty(){
      return 7;
   }

   @Override public int getLength(){
      return 14;
   }
}
