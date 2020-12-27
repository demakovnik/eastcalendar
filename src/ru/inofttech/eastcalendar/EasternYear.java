package ru.inofttech.eastcalendar;

import java.util.ArrayList;

public class EasternYear {
    private int year = 0;
    private Animal animal;
    private Color color;
    private Material material;

    public EasternYear(int year) {
       setYear(year);
    }

    private static int getEasternOrder(int year) {
        int result = 0;
        if (year>=1984) {
            result = (year - 1984) % 10;
            if (result % 2 == 0)
            {
                result /= 2;
            }
            else {
                result = (result - 1)/2;
            }
        } else {
            result = (10 - ((1984 - year)%10)) % 10;
            if (result % 2 == 0)
            {
                result /= 2;
            }
            else {
                result = (result - 1)/2;
            }
        }
        return result;
    }



    private static int getEasternAnimal(int year) {
        int result = 0;
        if (year>=1984) {
            result = (year - 1984) % 12;
        } else {
            result = (12 - ((1984 - year)%12)) % 12;
        }
        return result;
    }

    public Color getColor() {
        return color;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Material getMaterial() {
        return material;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        for (Animal a: Animal.values()
        ) {
            if (a.ordinal() == getEasternAnimal(year)) {
                animal = a;
                break;
            }
        }
        for (Color c: Color.values()) {
            if (c.ordinal()==getEasternOrder(year)) {
                color =c;
                break;
            }
        }
        for (Material m: Material.values()) {
            if (m.ordinal()==getEasternOrder(year)) {
                material = m;
                break;
            }
        }
    }

    public static ArrayList<Integer> getYearsofCriterial(Animal animal, Color color, int min, int max) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            EasternYear y = new EasternYear(i);
            if (y.getAnimal()==animal && y.getColor()==color) {
                res.add(i);
                count++;
            }
        }
        if (count==0)
            return null;
        return res;

    }

    public static ArrayList<Integer> getYearsofCriterial(Animal animal, Material material, int min, int max) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            EasternYear y = new EasternYear(i);
            if (y.getAnimal()==animal && y.getMaterial()== material) {
                res.add(i);
                count++;
            }
        }
        if (count==0)
            return null;
        return res;

    }

    public static ArrayList<Integer> getYearsofCriterial(Animal animal, int min, int max) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            EasternYear y = new EasternYear(i);
            if (y.getAnimal()==animal) {
                res.add(i);
                count++;
            }
        }
        if (count==0)
            return null;
        return res;
    }

    public static ArrayList<Integer> getYearsofCriterial(Color color, int min, int max) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            EasternYear y = new EasternYear(i);
            if (y.getColor()==color) {
                res.add(i);
                count++;
            }
        }
        if (count==0)
            return null;
        return res;
    }

    public static ArrayList<Integer> getYearsofCriterial(Material material, int min, int max) {
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            EasternYear y = new EasternYear(i);
            if (y.getMaterial() == material) {
                res.add(i);
                count++;
            }
        }
        if (count==0)
            return null;
        return res;
    }
	public enum Color {
    Green, Red, Yellow, White, Black
	}
	public enum Material {
    Wood, Fire, Earth, Metal, Water
	}
}
