
package dk.itu.mario.level.harrison;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class WallJumpUp extends Segment
{
    
    @Override
    public int attach( int start, Level level )
    {
        for ( int x = start; x < getLength() + start; x++ )
        {
            level.setBlock( x, level.getHeight(), HarrisonLevel.ROCK );
            level.setBlock( x, level.getHeight() - 1, HarrisonLevel.ROCK );
            level.setBlock( x, 0, HarrisonLevel.ROCK );
            level.setBlock( x, 1, HarrisonLevel.ROCK );
            level.setBlock( x, 2, HarrisonLevel.ROCK );
            
            if ( x <= start + ( getLength() - 1 ) / 2 - 1 )
            {
                for ( int y = 0; y < level.getHeight() - 4; y++ )
                {
                    level.setBlock( x, y, HarrisonLevel.ROCK );
                }
            }
            else if ( x >= start + ( getLength() - 1 ) / 2 + 1)
            {
                for ( int y = level.getHeight(); y > level.getHeight() - 7; y-- )
                {
                    level.setBlock( x, y, HarrisonLevel.ROCK );
                }
            }
        }

        level.setBlock( start + 6, level.getHeight() - 2, HarrisonLevel.COIN );
        level.setBlock( start + 7, level.getHeight() - 4, HarrisonLevel.COIN );
        level.setBlock( start + 7, level.getHeight() - 5, HarrisonLevel.COIN );
        level.setBlock( start + 7, level.getHeight() - 6, HarrisonLevel.COIN );
        level.setBlock( start + 7, level.getHeight() - 7, HarrisonLevel.COIN );
        level.setBlock( start + 7, level.getHeight() - 8, HarrisonLevel.COIN );
        level.setBlock( start + 8, level.getHeight() - 11, HarrisonLevel.COIN );
        level.setBlock( start + 9, level.getHeight() - 12, HarrisonLevel.COIN );
        level.setBlock( start + 10, level.getHeight() - 12, HarrisonLevel.COIN );
        level.setBlock( start + 11, level.getHeight() - 11, HarrisonLevel.COIN );

        return getLength();
    }
    
    @Override
    public int getDifficulty()
    {
        return 9;
    }
    
    @Override
    public int getLength()
    {
        return 15;
    }
}
