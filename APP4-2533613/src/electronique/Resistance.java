package electronique;

public class Resistance extends Composant {

    private double valResistance;

    public Resistance(double resistance) {
        super();
        setValResistance(resistance);
    }

    public double getValResistance() {
        return valResistance;
    }

    public double setValResistance(double valResistance) {
        if(!validerResistance()) {
            throw new IllegalArgumentException("Resistance n'est pas valide.");
        }
        return this.valResistance= valResistance;
    }

    public boolean validerResistance() {
        return !(valResistance < 0);
    }


    @Override
    public double calculerResistance() {
        return setValResistance(valResistance);
    }
}
