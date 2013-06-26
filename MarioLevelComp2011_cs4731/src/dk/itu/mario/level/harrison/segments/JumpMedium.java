
package dk.itu.mario.level.harrison.segments;

import dk.itu.mario.level.Level;
import dk.itu.mario.level.harrison.HarrisonLevel;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class JumpMedium extends Segment
{
    
    @Override
    public int attach( int start, Level level )
    {
        for ( int x = start; x < getLength() + start; x++ )
        {
            if ( x > start + 4 && x < start + 8 )
            {
                for ( int y = level.getHeight(); y > level.getHeight() - 5; y-- )
                {
                    level.setBlock( x, y, HarrisonLevel.ROCK );
                }
                level.setBlock( x, level.getHeight() - 6, HarrisonLevel.COIN );
            }
            else
            {
                level.setBlock( x, level.getHeight() - 1, HarrisonLevel.ROCK );
            }
        }
        
        return getLength();
    }
    
    @Override
    public int getDifficulty()
    {
        return 4;
    }
    
    @Override
    public int getLength()
    {
        return 9;
    }
}
