package ru.inofttech.eastcalendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.print("Введите Ваш год рождения (q - Выход): ");
        String string = "";

        while (!(string = (new BufferedReader(new
                InputStreamReader(System.in))).readLine()).equals("q")) {
            try {
                int year = Integer.parseInt(string);
                EasternYear easternYear = new EasternYear(year);
                System.out.println(easternYear.getColor() + " " + "(" + easternYear.getMaterial() +
                        ")" + " " + easternYear.getAnimal());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод! Попробуйте еще!");
            }




        }
    }

}




