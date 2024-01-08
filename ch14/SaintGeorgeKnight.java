package gr.aueb.cf.OOProjects.ch14;

/**
 * An instance-controlled class.
 * Singleton.
 */
public class SaintGeorgeKnight {
    private static final SaintGeorgeKnight KNIGHT = new SaintGeorgeKnight();

     // private constructor που αποτρέπει την πρόσβαση από έξω, άρα τη δημιουργία instances από
     // άλλες κλάσεις.
    private SaintGeorgeKnight() {}

    // public static factory method, παρέχει πρόσβαση στο μοναδικό instance της κλάσης.
    public static SaintGeorgeKnight getInstance() {
        return KNIGHT;
    }
    public void embarkOnMission() {
        System.out.println("Saint George Knight is embarking on a mission.");
    }
}
