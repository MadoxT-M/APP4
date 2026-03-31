package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{


    public CircuitSerie(List<Composant> composants) {
        super(composants);
    }


    @Override
    public double calculerResistance() {
        double resistanceSerie = 0.0;
        for(Composant c : composants) {
            resistanceSerie += c.calculerResistance();
        }
        return resistanceSerie;
    }
}
