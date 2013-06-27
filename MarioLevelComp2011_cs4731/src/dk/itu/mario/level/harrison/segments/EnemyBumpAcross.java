package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.engine.sprites.Enemy;
import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/**
 * Created By: TJ Harrison Date: 6/26/13
 */
public class EnemyBumpAcross extends Segment{

   @Override public int attach(int start, Level level){
      int y = level.getHeight() - 2;
      for(int i = level.getHeight(); i > y; i--){
         level.setBlock(start, i, HarrisonLevel.ROCK);
         level.setBlock(start + 13, i, HarrisonLevel.ROCK);
         level.setBlock(start + 14, i, HarrisonLevel.ROCK);
         level.setBlock(start + 15, i, HarrisonLevel.ROCK);
      }

      level.setBlock(start + 3, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 4, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 5, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 6, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 7, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 8, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 9, y - 1, HarrisonLevel.ROCK);
      level.setBlock(start + 10, y - 1, HarrisonLevel.ROCK);

      level.setSpriteTemplate(start + 4, y - 2, new SpriteTemplate(Enemy.ENEMY_RED_KOOPA, false));
      level.setSpriteTemplate(start + 7, y - 2, new SpriteTemplate(Enemy.ENEMY_GOOMBA, false));
      level.setSpriteTemplate(start + 9, y - 2, new SpriteTemplate(Enemy.ENEMY_GOOMBA, false));

      level.setBlock(start + 3, y - 2, HarrisonLevel.ROCK);
      level.setBlock(start + 6, y - 2, HarrisonLevel.ROCK);
      level.setBlock(start + 8, y - 2, HarrisonLevel.ROCK);
      level.setBlock(start + 10, y - 2, HarrisonLevel.ROCK);

      level.setBlock(start + 6, y - 3, HarrisonLevel.COIN);
      level.setBlock(start + 8, y - 3, HarrisonLevel.COIN);

      return getLength();
   }

   @Override public int getDifficulty(){
      return 7;
   }

   @Override public int getLength(){
      return 16;
   }
}
