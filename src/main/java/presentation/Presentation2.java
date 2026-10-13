package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Presentation2 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = openConfig()) {
            String daoClassName = readRequiredLine(reader, "classe DAO");
            String metierClassName = readRequiredLine(reader, "classe metier");

            Class<?> daoClass = Class.forName(daoClassName);
            IDao dao = (IDao) daoClass.getDeclaredConstructor().newInstance();
            System.out.println("[CONTAINER] DAO instancie : " + daoClass.getName());

            Class<?> metierClass = Class.forName(metierClassName);
            IMetier metier = (IMetier) metierClass.getDeclaredConstructor().newInstance();
            System.out.println("[CONTAINER] Metier instancie : " + metierClass.getName());

            Method setDaoMethod = metierClass.getMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier, dao);
            System.out.println("[CONTAINER] Injection du DAO terminee.");

            System.out.println("Resultats = " + metier.calcul());
        }
    }

    private static BufferedReader openConfig() throws IOException {
        File file = new File("config.txt");
        if (file.exists()) {
            return new BufferedReader(new FileReader(file));
        }
        InputStream is = Presentation2.class.getClassLoader().getResourceAsStream("config.txt");
        if (is != null) {
            return new BufferedReader(new InputStreamReader(is));
        }
        throw new IOException("Fichier config.txt introuvable");
    }

    private static String readRequiredLine(BufferedReader reader, String label) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty() && !line.startsWith("#")) {
                return line;
            }
        }
        throw new IOException("Ligne manquante pour " + label + " dans config.txt");
    }
}
