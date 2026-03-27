package electronique;

public class Resistance extends Composant {

    private double resistance;

    public Resistance(double resistance) {
        super();
        setResistance(resistance);
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        if(!validerResistance()) {
            throw new IllegalArgumentException("Resistance n'est pas valide.");
        }
        this.resistance = resistance;
    }

    public boolean validerResistance() {
        return !(resistance < 0);
    }


    @Override
    public double calculerResistance() {
        return getResistance();
    }
}
