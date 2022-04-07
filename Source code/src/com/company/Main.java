package com.company;

import java.util.*;

public class Main {
    static List<Child> children;
    static List<Present> presents;

    public static void main(String[] args) {
        children = new ArrayList<Child>();
        presents = new ArrayList<Present>();

        System.out.println("Welcome to LAPLAND 2022 system!!!");
        children.add(new Child("Diane", "Ameter"));
        children.add(new Child("Bodrum", "Salvador"));
        children.add(new Child("Hilary", "Ouse"));
        children.add(new Child("Indigo", "Violet"));
        children.add(new Child("Hans", "Down"));
        children.add(new Child("Shequondolisa", "Bivouac"));
        children.add(new Child("Ingredia", "Nutrisha"));
        children.add(new Child("Fig", "Nelson"));
        children.add(new Child("Benjamin", "Evalent"));
        children.add(new Child("Shequondolisa", "Bivouac"));
        children.add(new Child("Gustav", "Purpleson"));
        children.add(new Child("Elon", "Gated"));
        children.add(new Child("Gootsy", "Porkins"));
        children.add(new Child("Cornbread", "Stevens"));
        children.add(new Child("Slaps", "Guster"));

        presents.add(new Present("Compass"));
        presents.add(new Present("Banana"));
        presents.add(new Present("Joystick"));
        presents.add(new Present("Tamagotchi"));
        presents.add(new Present("Drone"));
        presents.add(new Present("Basketball ball"));
        presents.add(new Present("Pear Watch"));
        presents.add(new Present("Glasses"));
        presents.add(new Present("Scooter"));
        presents.add(new Present("Digimon"));
        presents.add(new Present("Lego kit"));
        presents.add(new Present("Visma internship"));
        presents.add(new Present("Football ball"));
        presents.add(new Present("Karaoke set"));
        printMenu();

    }

    public static void printMenu() {
        for (int i = 0; i < 3; i++) System.out.println("");
        System.out.println("~~~ MENU ~~~");
        System.out.println("[1] Print all children and all presents");
        System.out.println("[2] Print children with presents already assigned");
        System.out.println("[3] Print children without presents assigned");
        System.out.println("[4] Print all unassigned presents");
        System.out.println("[5] Create new child");
        System.out.println("[6] Create new present");
        System.out.println("[7] Randomly assign present to child");
        System.out.println("[8] Assign present to particular child");
        System.out.println("[9] Quit system");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("Please select an option: ");
        int selectedMenuOption;
        while (true) {
            try {
                Scanner S = new Scanner(System.in);
                selectedMenuOption = S.nextInt();
                break;
            } catch (InputMismatchException error) {
                System.out.println("Invalid symbol, please write a NUMBER");
            }
        }
        if (selectedMenuOption == 1) {
            System.out.println("~~~~ Children list ~~~~");
            for (int i = 0; i < children.size(); i++) {
                System.out.println(children.get(i));
            }
            System.out.println("~~~~ Present list ~~~~");
            for (int i = 0; i < presents.size(); i++) {
                if (presents.get(i).isAssigned()) System.out.println(presents.get(i) + " [ASSIGNED]");
                else System.out.println(presents.get(i));
            }
        } else if (selectedMenuOption == 2) {
            System.out.println("Children with presents assigned: ");
            int count = 0;
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getPresent() != null) {
                    count++;
                    System.out.println(children.get(i) + " [Assigned: " + children.get(i).getPresent() + "] ");
                }
            }
            System.out.println("Amount of children with assigned presents: " + count);
        } else if (selectedMenuOption == 3) {
            System.out.println("Children without presents assigned: ");
            int count = 0;
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getPresent() == null) {
                    count++;
                    System.out.println(children.get(i));
                }
            }
            System.out.println("Amount of children without assigned presents: " + count);
        } else if (selectedMenuOption == 4) {
            System.out.println("Unassigned presents: ");
            int count = 0;
            for (int i = 0; i < presents.size(); i++) {
                if (presents.get(i).isAssigned() == false) {
                    count++;
                    System.out.println(presents.get(i));
                }
            }
            System.out.println("Amount of unassigned presents: " + count);
        } else if (selectedMenuOption == 5) {
            System.out.println("~~~ New child creation ~~~");
            System.out.println("Enter child's name");
            Scanner S = new Scanner(System.in);
            String name = S.nextLine();
            System.out.println("Enter child's surname");
            String surname = S.nextLine();

            boolean childAlreadyExists = false;
            for (int i = 0; i < children.size(); i++) {
                if (name.equals(children.get(i).getName()) && surname.equals(children.get(i).getSurname())) {
                    childAlreadyExists = true;
                }
            }
            if (childAlreadyExists == true) {
                System.out.println("This child already exists.");

            } else {
                children.add(new Child(name, surname));
                System.out.println("New child successfully added.");
            }
        } else if (selectedMenuOption == 6) {
            System.out.println("New present creation");
            System.out.println("Enter present's name:");
            Scanner S = new Scanner(System.in);
            String name = S.nextLine();
            presents.add(new Present(name));
            System.out.println("Present added successfully!");
        } else if (selectedMenuOption == 7) {
            List<Present> unassignedPresents = getUnassignedPresents(presents);
            List<Child> unassignedChildren = filterChildList(children);
            if (unassignedPresents.size() == 0) {
                System.out.println("No presents left. Go make some :)");
            } else if (unassignedChildren.size() == 0) {
                System.out.println("No children without a gift left!");
            } else {

                System.out.println("Pick a number of present to assign:");
                int selectedPresentIndex = selectFromList(unassignedPresents);

                Present present = unassignedPresents.get(selectedPresentIndex - 1);
                Random randomNumber = new Random();
                int index = randomNumber.nextInt(unassignedChildren.size());
                unassignedChildren.get(index).setPresent(present);
                present.setAssigned(true);
                System.out.println(present + " has been assigned to " + unassignedChildren.get(index));
            }
        } else if (selectedMenuOption == 8) {
            List<Present> unassignedPresents = getUnassignedPresents(presents);
            List<Child> unassignedChildren = filterChildList(children);
            if (unassignedPresents.size() == 0) {
                System.out.println("No presents left. Go make some :)");
            } else if (unassignedChildren.size() == 0) {
                System.out.println("No children without a present left!");
            } else {
                System.out.println("Pick a present you want to gift:");
                int selectedPresent = selectFromList(unassignedPresents);
                Present present = unassignedPresents.get(selectedPresent - 1);
                System.out.println("Pick a child to whom you want to give " + present);
                int selectedChild = selectFromList(unassignedChildren);

                unassignedChildren.get(selectedChild - 1).setPresent(present);
                present.setAssigned(true);
                System.out.println(present + " has been assigned to " + unassignedChildren.get(selectedChild - 1));
            }
        } else if (selectedMenuOption == 9) {
            exit();
        }
        System.out.println("Do you want to go back to menu? Y/N");
        Scanner S = new Scanner(System.in);
        String answer = S.nextLine();
        if (answer.toLowerCase(Locale.ROOT).equals("y")) {
            printMenu();
        } else exit();

    }

    public static void exit() {
        System.out.println("Merry Christmas, see you next year!~~");
        System.exit(0);
    }

    public static List<Child> filterChildList(List<Child> fullChildList) {
        List<Child> childrenWithoutPresent = new ArrayList<Child>();
        for (int i = 0; i < fullChildList.size(); i++) {
            if (fullChildList.get(i).getPresent() == null) {
                childrenWithoutPresent.add(fullChildList.get(i));
            }
        }
        return childrenWithoutPresent;
    }

    public static List<Present> getUnassignedPresents(List<Present> fullPresentsList) {
        List<Present> unassignedPresentsList = new ArrayList<Present>();
        for (int i = 0; i < fullPresentsList.size(); i++) {
            if (fullPresentsList.get(i).isAssigned() == false) {
                unassignedPresentsList.add(fullPresentsList.get(i));
            }
        }
        return unassignedPresentsList;
    }

    public static int selectFromList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + list.get(i));
        }
        int selectedValue;
        Scanner S = new Scanner(System.in);
        while (true) {
            try {
                selectedValue = S.nextInt();
                if (selectedValue <= list.size() && selectedValue > 0) {
                    break;
                } else
                    System.out.println("Invalid value!");

            } catch (InputMismatchException error) {
                System.out.println("Invalid symbol, please write a NUMBER");
            }
        }
        return selectedValue;
    }
}


