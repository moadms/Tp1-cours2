package dao;

/**
 * Interface de persistance.
 * Definit le contrat pour recuperer une valeur numerique.
 */
public interface IDao {
    /**
     * Recupere la valeur depuis la source de donnees.
     * @return La valeur double recuperee.
     */
    double getValue();
}
