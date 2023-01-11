/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semestralproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import semestralproject.Colors.Color;

/**
 * 15. Program creates spirale matrix based on given matrix size.
 *
 * @author Jan Smutný
 * @version 0.1 20/12/2022
 */
public class SemestralProject {

    // Main driver method
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        UserInputManager userInputManager = new UserInputManager(System.in);
        TextCreator txtCreator = new TextCreator();
        txtCreator.writeText("vesele vanoce");

        boolean userWantsToContinue = true;
        do {
            int taskChoice = userInputManager.userNumberInput("Vyber úlohu (1 - Semestrální práce 15, 2 - vánoční úloha): ", "Zadej 1 nebo 2!", x -> x == 1 || x == 2);
            if (taskChoice == 1) {
                int matrixWidth;
                int matrixHeight;
                while (true) {
                    matrixHeight = userInputManager.userNumberInput("Zadej počet řádků matice: ", "", null);
                    if (matrixHeight <= 0) {
                        break;
                    }
                    matrixWidth = userInputManager.userNumberInput("Zadej počet sloupců matice: ", "", null);
                    int[][] spiralMatrix = MatrixTool.spirale(matrixWidth, matrixHeight); // zadání semetrální úlohy

                    MatrixTool.printMatrix(spiralMatrix);

                }

            } else {

                BuildingDrawer bd = new BuildingDrawer();
                int numberOfHouses = userInputManager.userNumberInput("Zadej počet domků: ", "Zadej kladné číslo!", x -> x > 0);
                int snowChance = userInputManager.userNumberInput("Zadej procentuální výskyt sněhu: ", "Zadej číslo mezi 0 - 100!", x -> x >= 0 && x <= 100);
                Color[] colorsValues = Colors.Color.values();
                String colorsListString = "Možné barvy:\n";
                for (int j = 0; j < colorsValues.length - 1; j++) {
                    colorsListString += j + " : " + colorsValues[j] + "\n";
                }
                for (int i = 0; i < numberOfHouses; i++) {
                    int sizeOfHouse = userInputManager.userNumberInput("Zadej velikost domu: ", "Zadej kladné číslo!", x -> x > 0);
                    char roofChar = userInputManager.userCharInput("Zadej znak střechy: ");
                    char wallChar = userInputManager.userCharInput("Zadej znak stěny: ");

                    Colors.Color roofColor = colorsValues[userInputManager.userNumberInput("Zadej barvu znaků střechy: \n" + colorsListString, "Zadej kladné číslo v rozmezí 0-" + (colorsValues.length - 2) + "!", x -> x < colorsValues.length - 1 && x >= 0)];
                    Colors.Color roofBackgroundColor = colorsValues[userInputManager.userNumberInput("Zadej barvu pozadí střechy: \n" + colorsListString, "Zadej kladné číslo v rozmezí 0-" + (colorsValues.length - 2) + "!", x -> x < colorsValues.length - 1 && x >= 0)];
                    Colors.Color wallColor = colorsValues[userInputManager.userNumberInput("Zadej barvu znaků stěny: \n" + colorsListString, "Zadej kladné číslo v rozmezí 0-" + (colorsValues.length - 2) + "!", x -> x < colorsValues.length - 1 && x >= 0)];
                    Colors.Color wallBackgroundColor = colorsValues[userInputManager.userNumberInput("Zadej barvu pozadí stěny: \n" + colorsListString, "Zadej kladné číslo v rozmezí 0-" + (colorsValues.length - 2) + "!", x -> x < colorsValues.length - 1 && x >= 0)];

                    bd.addDemand(sizeOfHouse, wallChar, roofChar, roofColor, roofBackgroundColor, wallColor, wallBackgroundColor, snowChance);
                    System.out.println("-------------------------------------------------------------------");

                }
                bd.execute(snowChance);
            }
            int userChoice = userInputManager.userNumberInput("Chceš zadat znovu? 1 = ano,2 = ne: ", "Zadej 1 pro „Ano“ nebo 2 pro „Ne“!", x -> x == 1 || x == 2);
            if (userChoice == 2) {
                userWantsToContinue = false;
            }
        } while (userWantsToContinue);

        URL joke = new URL("https://v2.jokeapi.dev/joke/christmas");
        URLConnection jokeConnection = joke.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(jokeConnection.getInputStream()));
        String inputLine;
        String delivery = "";
        String setup = "";
        int iterator = 0;
        //4 5
        while ((inputLine = in.readLine()) != null) {
            if (iterator == 4) {
                setup = inputLine.split(":")[1].substring(0, inputLine.split(":")[1].length() - 1);
            } else if (iterator == 5) {
                delivery = inputLine.split(":")[1].substring(0, inputLine.split(":")[1].length() - 1);
            }
            iterator++;
        }
        in.close();

        System.out.println();
        System.out.println("Vtípek k pokukání na závěr: ");
        System.out.println(setup);
        System.out.println(delivery);

        //Testování
        /*MatrixTool.PrintMatrix(MatrixTool.Spirale(5, 5));
        System.out.println();
        MatrixTool.PrintMatrix(MatrixTool.Spirale(6, 7));
        System.out.println();
        MatrixTool.PrintMatrix(MatrixTool.Spirale(10, 15));
        System.out.println();
        MatrixTool.PrintMatrix(MatrixTool.Spirale(8, 2));*/
    }

}
