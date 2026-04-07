package electronique;

import java.util.List;

public class CircuitParallele extends Circuit {

    public CircuitParallele(List<Composant> composants) {super(composants);}

    @Override
    public double calculerResistance() {
        double resistanceParallelle = 0.0;
        for (Composant c : composants) {
            double r =  c.calculerResistance();
            if(r==0){throw new ArithmeticException("Division par cero");}

            resistanceParallelle += 1/r;
        }
        return 1/ resistanceParallelle;
    }

}
