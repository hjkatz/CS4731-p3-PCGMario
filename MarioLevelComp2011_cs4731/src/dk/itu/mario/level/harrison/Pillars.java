
package dk.itu.mario.level.harrison;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class Pillars extends Segment
{
    
    @Override
    public int attach( int start, Level level )
    {
        for ( int x = start; x < getLength() + start; x++ )
        {
            level.setBlock( x, level.getHeight() - 1, HarrisonLevel.ROCK );
            
            if ( x - start == 5 )
            {
                level.setBlock( x, level.getHeight() - 2, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 3, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 4, HarrisonLevel.ROCK );
            }
            else if ( x - start == 9 )
            {
                level.setBlock( x, level.getHeight() - 2, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 3, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 4, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 5, HarrisonLevel.ROCK );
            }
            else if ( x - start == 11 )
            {
                level.setBlock( x, level.getHeight() - 2, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 3, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 4, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 5, HarrisonLevel.ROCK );
            }
            else if ( x - start == 13 )
            {
                level.setBlock( x, level.getHeight() - 2, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 3, HarrisonLevel.ROCK );
                level.setBlock( x, level.getHeight() - 4, HarrisonLevel.ROCK );
            }
        }

        level.setBlock( start + 0, level.getHeight() - 2, HarrisonLevel.COIN );
        level.setBlock( start + 2, level.getHeight() - 5, HarrisonLevel.COIN );
        level.setBlock( start + 5, level.getHeight() - 5, HarrisonLevel.COIN );
        level.setBlock( start + 10, level.getHeight() - 9, HarrisonLevel.COIN );
        level.setBlock( start + 12, level.getHeight() - 8, HarrisonLevel.COIN );
        level.setBlock( start + 14, level.getHeight() - 7, HarrisonLevel.COIN );
        
        return getLength();
    }
    
    @Override
    public int getDifficulty()
    {
        return 10;
    }
    
    @Override
    public int getLength()
    {
        return 17;
    }
}
