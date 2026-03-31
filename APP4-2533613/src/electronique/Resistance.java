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

    public void setValResistance(double valResistance) {
        if(!validerResistance()) {
            throw new IllegalArgumentException("Resistance n'est pas valide.");
        }
        this.valResistance = valResistance;
    }

    public boolean validerResistance() {
        return !(valResistance < 0);
    }


    @Override
    public double calculerResistance() {
        return valResistance;
    }
}
