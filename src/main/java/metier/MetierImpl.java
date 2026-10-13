package metier;

import dao.IDao;

/**
 * Implementation concrete de l'interface IMetier.
 * Depend d'une instance d'IDao (couplage faible).
 */
public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    /**
     * Methode d'injection de la dependance (setter).
     * @param dao L'instance de IDao a injecter.
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        if (dao == null) {
            throw new IllegalStateException("Le DAO n'a pas ete injecte.");
        }

        double valeurBase = dao.getValue();
        double resultat = valeurBase * 3;

        System.out.println("[METIER] Calcul bonus microservice effectue. Resultat : " + resultat);
        return resultat;
    }

    public IDao getDao() {
        return dao;
    }
}
