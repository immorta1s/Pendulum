/**
 * Created by Kyrie Xia on 2018-07-11.
 */
import java.text.NumberFormat;

/**
 * compares the values of a simple pendulum using the harmonic motion equation
 * versus the Euler algorithm approximation
 */
public class PendulumRunner {

    public static final double G= 9.80665;
    public static final double jupiter = 25;

    public static void main (String [] args) {
        NumberFormat nf = NumberFormat.getInstance ();
        nf.setMaximumFractionDigits (3);

        double delta = (args.length == 0) ? .1 : Double.parseDouble (args[0]);
        double sLen = 10, pMass = 10, theta0 = Math.PI/30;

        GravityConstant inG = new GravityConstant(G);
        GravityConstant jupiterG=new GravityConstant(jupiter);

        RegularPendulum rp = new RegularPendulum (sLen, pMass, theta0,  delta,inG);
        SimplePendulum sp = new SimplePendulum (sLen, pMass, theta0,inG);
        RegularPendulum rp1 = new RegularPendulum (sLen, pMass, theta0,  delta,jupiterG);
        SimplePendulum sp1 = new SimplePendulum (sLen, pMass, theta0,jupiterG);
        RegularPendulum rpCoarse =
                new RegularPendulum (sLen, pMass, theta0, .1,inG);
        RegularPendulum rpCoarse1=
                new RegularPendulum (sLen, pMass, theta0, .1,jupiterG);

        // print out difference in displacement in 1 second intervals
        // for 20 seconds
        int iterations = (int) (1/delta);
        System.out.println ("analytical vs. numerical displacement (fine, coarse)");
        for (int second = 1; second <= 20; second++) {
            if (second <=10) {
                for (int i = 0; i < iterations; i++) rp.step ();
                for (int i = 0; i < 10; i++) rpCoarse.step ();
                System.out.println ("t=" + second + "s: \t" +
                        nf.format (Math.toDegrees (sp.getTheta (second)))
                        + "\t" +
                        nf.format (Math.toDegrees (rp.getLastTheta ()))
                        + "\t" +
                        nf.format (Math.toDegrees (rpCoarse.getLastTheta ())));
            }
            else
            {
                for (int i = 0; i < iterations; i++) rp1.step ();
                for (int i = 0; i < 10; i++) rpCoarse1.step ();
                System.out.println ("t=" + second + "s: \t" +
                        nf.format (Math.toDegrees (sp1.getTheta (second)))
                        + "\t" +
                        nf.format (Math.toDegrees (rp1.getLastTheta ()))
                        + "\t" +
                        nf.format (Math.toDegrees (rpCoarse1.getLastTheta ())));
            }
        }


    }
}

