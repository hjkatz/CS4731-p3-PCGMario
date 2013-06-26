
package dk.itu.mario.level.harrison;

import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.level.RandomLevel;
import dk.itu.mario.level.harrison.segments.*;
import dk.itu.mario.level.harrison.transitions.*;

import java.util.Random;

/** Created By: Harrison Katz on Date: 6/21/13 */
public class HarrisonLevel extends RandomLevel
{
    public static final byte BLOCK_EMPTY         = ( byte ) ( 0 + 1 * 16 );    // 1 * 16
    public static final byte BLOCK_POWERUP       = ( byte ) ( 4 + 2 + 1 * 16 ); // 7 * 16
    public static final byte BLOCK_COIN          = ( byte ) ( 4 + 1 + 1 * 16 ); // 6 * 16
    public static final byte GROUND              = ( byte ) ( 1 + 9 * 16 );    // 10 * 16
    public static final byte ROCK                = ( byte ) ( 9 + 0 * 16 );    // 9 * 16
    public static final byte COIN                = ( byte ) ( 2 + 2 * 16 );    // 4 * 16
    public static final byte LEFT_GRASS_EDGE     = ( byte ) ( 0 + 9 * 16 );    // 9 * 16
    public static final byte RIGHT_GRASS_EDGE    = ( byte ) ( 2 + 9 * 16 );    // 11 * 16
    public static final byte RIGHT_UP_GRASS_EDGE = ( byte ) ( 2 + 8 * 16 );    // 10 * 16
    public static final byte LEFT_UP_GRASS_EDGE  = ( byte ) ( 0 + 8 * 16 );    // 8 * 16
    public static final byte LEFT_POCKET_GRASS   = ( byte ) ( 3 + 9 * 16 );    // 12 * 16
    public static final byte RIGHT_POCKET_GRASS  = ( byte ) ( 3 + 8 * 16 );    // 11 * 16
    public static final byte HILL_FILL           = ( byte ) ( 5 + 9 * 16 );    // 14 * 16
    public static final byte HILL_LEFT           = ( byte ) ( 4 + 9 * 16 );    // 13 * 16
    public static final byte HILL_RIGHT          = ( byte ) ( 6 + 9 * 16 );    // 15 * 16
    public static final byte HILL_TOP            = ( byte ) ( 5 + 8 * 16 );    // 13 * 16
    public static final byte HILL_TOP_LEFT       = ( byte ) ( 4 + 8 * 16 );    // 12 * 16
    public static final byte HILL_TOP_RIGHT      = ( byte ) ( 6 + 8 * 16 );    // 14 * 16
    public static final byte HILL_TOP_LEFT_IN    = ( byte ) ( 4 + 11 * 16 );   // 15 * 16
    public static final byte HILL_TOP_RIGHT_IN   = ( byte ) ( 6 + 11 * 16 );   // 17 * 16
    public static final byte TUBE_TOP_LEFT       = ( byte ) ( 10 + 0 * 16 );   // 10 * 16
    public static final byte TUBE_TOP_RIGHT      = ( byte ) ( 11 + 0 * 16 );   // 11 * 16
    public static final byte TUBE_SIDE_LEFT      = ( byte ) ( 10 + 1 * 16 );   // 11 * 16
    public static final byte TUBE_SIDE_RIGHT     = ( byte ) ( 11 + 1 * 16 );   // 12 * 16
    // These are the place of the end of the level
    private long             seed;
    private Random           random;
    private GamePlay         playerMetrics;
    
    public HarrisonLevel( long seed, GamePlay playerMetrics )
    {
        super( 600, 15 );
        this.seed = seed;
        this.playerMetrics = playerMetrics;
        width = 600;
        height = 15;
        create();
    }
    
    public void create()
    {
        random = new Random( seed );

        Segment singletonTransition = new SingletonTransition();
        Segment shortTransition = new ShortTransition();
        Segment mediumTransition = new MediumTransition();
        Segment longTransition = new LongTransition();
        Segment platformTransition = new PlatformTransition();
        Segment ceilingJumpUp = new CeilingJumpUp();
        Segment ceilingJumpUpDown = new CeilingJumpUpDown();
        Segment wallJumpUp = new WallJumpUp();
        Segment wallJumpUpDown = new WallJumpUpDown();
        Segment gapSmall = new GapSmall();
        Segment gapMedium = new GapMedium();
        Segment gapLarge = new GapLarge();
        Segment gapExtraLarge = new GapExtraLarge();
        Segment jumpMedium = new JumpMedium();
        Segment jumpLarge = new JumpLarge();
        Segment pillars = new Pillars();
        Segment pillarsGap = new PillarsGap();
        Segment runnableGap = new RunnableGap();
        Segment runnableGapLong = new RunnableGapLong();
        Segment pipeSingle = new PipeSingle();
        Segment pipeDouble = new PipeDouble();
        
        // create the start location
        int length = 0;
        length += longTransition.attach( length, this );
        
        // create all of the medium sections
        while ( length < width - 20 )
        {
            length += runnableGapLong.attach(length, this);
            //length += pipeSingle.attach(length, this);
            length += pipeDouble.attach(length, this);
            length += shortTransition.attach( length, this );
            length += runnableGap.attach(length, this);
            length += ceilingJumpUp.attach( length, this );
            length += platformTransition.attach(length, this);
            length += wallJumpUp.attach( length, this );
            length += singletonTransition.attach(length, this);
            length += ceilingJumpUpDown.attach( length, this );
            length += mediumTransition.attach( length, this );
            length += platformTransition.attach( length, this );
            length += wallJumpUpDown.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += gapSmall.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += gapMedium.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += gapLarge.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += gapExtraLarge.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += jumpMedium.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += jumpLarge.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += pillars.attach( length, this );
            //length += longTransition.attach( length, this );
            //length += pillarsGap.attach( length, this );
        }
        
        xExit = width - 8;
        yExit = height - 1;
        
        while ( length < width )
        {
            length += longTransition.attach( length, this );
        }
        
    }
}
