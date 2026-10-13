package metier;

/**
 * Interface metier.
 * Definit le contrat pour effectuer un calcul base sur des donnees.
 */
public interface IMetier {
    /**
     * Effectue le calcul metier.
     * @return Le resultat du calcul.
     */
    double calcul();
}
