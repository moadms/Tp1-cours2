package dao;

/**
 * Implementation concrete de l'interface IDao.
 * Simule une recuperation de donnees depuis une source externe.
 */
public class DaoImpl implements IDao {

    private final String nomSource;
    private final double valeurStockee;

    public DaoImpl() {
        this.nomSource = "Source memoire TP";
        this.valeurStockee = 100.0;
    }

    public DaoImpl(String nomSource, double valeurStockee) {
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
