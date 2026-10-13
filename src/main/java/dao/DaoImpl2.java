package dao;

/**
 * Deuxieme implementation concrete de l'interface IDao.
 * Simule un capteur IoT ou un service externe.
 */
public class DaoImpl2 implements IDao {

    private final String nomSource;
    private final double valeurStockee;

    public DaoImpl2() {
        this.nomSource = "Capteur IOT V2";
        this.valeurStockee = 150.0;
    }

    public DaoImpl2(String nomSource, double valeurStockee) {
        this.nomSource = nomSource;
        this.valeurStockee = valeurStockee;
    }

    @Override
    public double getValue() {
        System.out.println("[DAO] Lecture depuis " + nomSource + "...");
        return valeurStockee;
    }

    public String getNomSource() {
        return nomSource;
    }

    public double getValeurStockee() {
        return valeurStockee;
    }
}
