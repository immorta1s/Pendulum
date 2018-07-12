/**
 * Created by Kyrie on 2018-07-11.
 */

/**
 * Represents a pendulum on the planet Earth
 */
public abstract class AbstractEarthPendulum extends AbstractPendulum {

    /** gravitational constant */
    public static final double GRAVITY = 9.80665;

    /**
     * Creates a new Pendulum instance using
     * inLength: the string length (>0)
     * inMass: the point mass (>0)
     * inTheta0: angular displacement at t=0 (0<=theta0)
     */
    public AbstractEarthPendulum (double inLength, double inMass, double inTheta0) {
        super (inLength, inMass, inTheta0, GRAVITY);
    }

}


