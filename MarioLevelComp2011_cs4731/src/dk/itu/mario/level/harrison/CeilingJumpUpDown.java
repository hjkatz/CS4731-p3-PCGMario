
package dk.itu.mario.level.harrison;

import dk.itu.mario.level.Level;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class CeilingJumpUpDown extends Segment
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
            
            if ( x < start + 5 )
            {
                for ( int y = 0; y < level.getHeight() - 3; y++ )
                {
                    level.setBlock( x, y, HarrisonLevel.ROCK );
                }
            }
            else if ( x < start + 10 && x > start + 5 )
            {
                for ( int y = level.getHeight(); y > level.getHeight() - 6; y-- )
                {
                    level.setBlock( x, y, HarrisonLevel.ROCK );
                }
                level.setBlock( x, level.getHeight() - 6, HarrisonLevel.COIN );
            }
            else if ( x > start + 10 )
            {
                for ( int y = 0; y < level.getHeight() - 3; y++ )
                {
                    level.setBlock( x, y, HarrisonLevel.ROCK );
                }
            }
        }
        
        return getLength();
    }
    
    @Override
    public int getDifficulty()
    {
        return 7;
    }
    
    @Override
    public int getLength()
    {
        return 15;
    }
}
