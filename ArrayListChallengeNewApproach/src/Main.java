import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("input the operation to be executed");
        System.out.println("0- Quit a program");
        System.out.println("1- Add an item to the list");
        System.out.println("2- Remove an item from the list");


        boolean flag = true;
        while(flag){
            int switchValue=scanner.nextInt();

            switch (switchValue) {

                case 0:
                    flag = false;
                    System.out.println("Quitting the program");
                    break;
                case 1:
                    System.out.println("Add item");
                    String[] itemInQuestion = scanner2.nextLine().split(",");
                    if(searchDuplicate(itemList, Arrays.toString(itemInQuestion))){
                        System.out.println("Inserted item is a duplicate");
                        break;
                    }
                    addItem(itemList,itemInQuestion);
                    sortArrayList(itemList);
                    break;
                case 2:
                    System.out.println("remove an item");
                    String itemInQuestion2 = scanner2.next();
                    if(searchDuplicate(itemList,itemInQuestion2)){
                    removeItem(itemList,itemInQuestion2);
                    }
                    sortArrayList(itemList);
                    break;
            }
        }
    }
    public static boolean searchDuplicate(ArrayList<String> list,String enteredItem){
        for (String s : list) {
            if (s.equals(enteredItem)) {
                return true;
            }
        }
        return false;
    }
    public static void addItem(ArrayList<String> list, String[] itemToAdd){
        list.add(Arrays.toString(itemToAdd));
    }
    public static void removeItem(ArrayList<String> list, String itemToRemove){
        list.remove(itemToRemove);
    }
    public static void sortArrayList (ArrayList<String> list){
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

    }
}