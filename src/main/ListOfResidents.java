package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ListOfResidents {

    public void startApp(String file) {
        Interactions interactions = new Interactions();
        List<UserData> listOfResidents = new ArrayList<UserData>();
        List<String> pesels = new ArrayList<String>();

        boolean canContinue = true;
        while (canContinue) {
            //UserData answers = interactions.getAnswers();
            Scanner input = new Scanner((System.in));
            System.out.println("Podaj Miasto: ");
            String town = input.nextLine();
            System.out.println("Podaj Imię: ");
            String name = input.nextLine();
            System.out.println("Podaj Nazwisko: ");
            String surname = input.nextLine();
            System.out.println("Podaj PESEL: ");
            String user_pesel = input.nextLine();
            UserData userData = new UserData(town,name,surname,user_pesel);

            String actualPesel = user_pesel;

            Pesel pesel = new Pesel();
            if (!pesel.isCorrect(actualPesel)) {
                System.err.println("Podany numer PESEL jest niepoprawny.");
                //canContinue = interactions.askYorN("Czy kontynuować?", "y", "n");
                canContinue = isCanContinue(canContinue);
                continue;
            }

            if (pesels.contains(actualPesel)) {
                for (int i = 0; i < listOfResidents.size(); i++) {
                    UserData userData = listOfResidents.get(i);
                    if (userData.Pesel.equals(actualPesel)) {
                        System.out.println(userData.Town);
                        userData.Town = answers.Town;
                        System.out.println(userData.Town);
                        userData.Name = answers.Name;
                        userData.Surname = answers.Surname;
                    }
                }
            } else {
                pesels.add(actualPesel);
                listOfResidents.add(answers);
            }
            //canContinue = interactions.askYorN("Czy kontynuować?", "y", "n");
            canContinue = isCanContinue(canContinue);
        }

        FileWithData fileWithData = new FileWithData();
        fileWithData.write(file, listOfResidents);
    }

    private boolean isCanContinue(boolean canContinue) {
        Scanner input = new Scanner((System.in));
        System.out.println("Czy kontynuowac");
        String repeat = input.nextLine();
        if (repeat.toLowerCase(Locale.ROOT).equals("y"))
            canContinue = true;
        if (repeat.toLowerCase(Locale.ROOT).equals("n"))
            canContinue = false;
        return canContinue;
    }
}
