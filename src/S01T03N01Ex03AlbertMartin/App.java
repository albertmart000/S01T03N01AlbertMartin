package S01T03N01Ex03AlbertMartin;

import java.io.*;
import java.util.*;

public class App {

    private static User user;
    private static final int NUMBER_OF_QUESTIONS = 10;
    private static final int POINTS_PER_QUESTION = 1;

    public static void main(String[] args) throws IOException {

        //Llegim el fitxer de text i guardem les dades en un HashMap. Des d'aquí fem una List amb el nom dels països.
        //Creem l'usuari que farà el text.
        HashMap<String, String> countriesAndCapitals = buildCountriesAndCapitalsList();
        List<String> countries = buildCountriesList(countriesAndCapitals);
        user = createUser();

        //Fem el text.
        System.out.println(user.getName() + ": Has de contestar en ANGLES a les següents "
                + NUMBER_OF_QUESTIONS + " preguntes:");
        makeTheTest( countriesAndCapitals, countries);
        showResults();

        //Guardem els resultats en un arxiu de text.
        saveDataToTextFile();
    }


    //Per fer el text demanen 10 vegades la capital d'un pais tret de la llista de keys aleatòriament.
    private static void makeTheTest(HashMap<String, String> countriesAndCapitals, List<String> countries) {

        for (int i = 1; i <= NUMBER_OF_QUESTIONS; i++) {
            System.out.print("Pregunta número " + i + ": ");
            String country = getRandomCountry(countries);
            String answer = askTheQuestion(country);
            checkTheAnswer(countriesAndCapitals, country, answer);
        }
    }

    private static String getRandomCountry(List<String> countries) {
        Random intRandom = new Random();
        return countries.get((intRandom.nextInt(1, countries.size())));
    }

    private static String askTheQuestion(String country) {
        System.out.println("Quina ciutat es la capital de " + country + "?");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //Si la resposta és correcta, afegim un punt a la puntuació de l'usuari. Traiem el pais de la llista perquè no es repeteixi.
    private static void checkTheAnswer(HashMap<String, String> countriesAndCapitals, String country, String answer) {
        String capital= countriesAndCapitals.get(country);
        if(capital.equalsIgnoreCase(answer)){
            int currentScore = user.getScore() + POINTS_PER_QUESTION;
            user.setScore(currentScore);
            System.out.println("Resposta correcta!.");

        } else {
            System.out.println("Resposta incorrecta!!! La capital de " + country + " es " + capital + ".");
        }
        countriesAndCapitals.remove(country);

    }

    //Mostrem els resultats en pantalla,
    private static void showResults() {
        System.out.println(user.getName()+": la teva puntuació final es: " +user.getScore() +".");
    }

    //Amb els resultats, fem un i el guardem en un arxiu de text.
    private static void saveDataToTextFile() {
        HashMap<String, Integer> classification = buildClassification();
        buildTextFileClassification(classification);
    }

    private static HashMap<String, Integer> buildClassification() {
        HashMap<String, Integer> classification = new HashMap<>();
        classification.put(user.getName(), user.getScore());
        return classification;
    }

    private static void buildTextFileClassification(HashMap<String, Integer> classification) {
        File file = new File("classification.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, Integer> entry : classification.entrySet()) {
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User createUser() {
        String name = askName();
        user = new User(name);
        return user;
    }

    private static String askName () {
        System.out.println("Introdueix el teu nom.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static List<String> buildCountriesList(HashMap<String, String> countriesAndCapitals) {
        return new ArrayList<>(countriesAndCapitals.keySet());
    }

   private static HashMap<String, String> buildCountriesAndCapitalsList () throws IOException {

       HashMap<String, String> countriesAndCapitals = new HashMap<>();

       FileReader fileReader = new FileReader("src/countries.txt");
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       String line;
       while ((line = bufferedReader.readLine()) != null) {
           String[] parts = line.split("\s");
           String country = parts[0];
           String capital = parts[1];
           countriesAndCapitals.put(country, capital);
       }
       return countriesAndCapitals;
   }


}




