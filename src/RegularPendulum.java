/**
 * Created by Kyrie Xia on 2018-07-11.
 */
/**
 * Represents a pendulum
 */
public class RegularPendulum extends AbstractPendulum {
    private double delta, iterations = 0;
    private double dissipation;
    private double lastTheta, lastVel, lastAccel;

    /**
     * Creates a new Pendulum instance
     */
    public RegularPendulum (double inLength, double inMass, double inTheta0,
                            double inDelta, double inDiss, GravityModel g) {
        super (inLength, inMass, inTheta0, g);
        delta=inDelta;
        dissipation = inDiss;
        lastVel = 0;
        lastTheta = this.getMaxAngularDisplacement ();
        lastAccel = -(this.getGravitationalField () / this.getStringLength ())*Math.sin (lastTheta);
    }

    public RegularPendulum (double inLength, double inMass, double inTheta0,
                            double inDelta,GravityModel g) {
        this (inLength, inMass, inTheta0, inDelta, 0, g);//refactoring
    }

    public void step () {
        iterations++;
        lastTheta = lastTheta + lastVel*delta;
        lastVel = lastVel + lastAccel*delta;
        lastAccel = - dissipation*lastVel - this.getGravitationalField () / this.getStringLength () * Math.sin (lastTheta);
    }

    public double getLastTheta () { return lastTheta; }
    public double getLastVelocity () { return lastVel; }
    public double getLastAcceleration () { return lastAccel; }
    public double getLastTime () { return iterations*delta; }
    public double getDissipationConstant () { return dissipation; }


}
