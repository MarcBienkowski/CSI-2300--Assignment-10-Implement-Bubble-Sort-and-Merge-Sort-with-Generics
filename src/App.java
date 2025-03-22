import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static <T extends Comparable<T>> ArrayList<T> Bubble_Sort(ArrayList<T> array){
        ArrayList<T> sorted_array = new ArrayList<>(array); 
    
        boolean change_made; 
    
        do {
            change_made = false;  
            for (int index = 0; index < sorted_array.size() - 1; index++) {
                if (sorted_array.get(index).compareTo(sorted_array.get(index + 1)) > 0) {
    
                    T temp = sorted_array.get(index);
                    sorted_array.set(index, sorted_array.get(index + 1));
                    sorted_array.set(index + 1, temp);

                    change_made = true;
                }
            }
        } while (change_made);  
    
        return sorted_array;
    }
    public static <T extends Comparable<T>> ArrayList<T> Merge_Sort_Array_Splitter(ArrayList<T> array) {
        
        if (array.size() <= 1){
            return array;
        }

        int element_total = array.size();
        int element_chunk = (int)Math.floor(element_total / 2);
        ArrayList<T> L = new ArrayList<>(array.subList(0, element_chunk));
        ArrayList<T> R = new ArrayList<>(array.subList(element_chunk, element_total));

        L = Merge_Sort_Array_Splitter(L);
        R = Merge_Sort_Array_Splitter(R);

        return Merge_Sort_Merger(L,R);
    }
    public static <T extends Comparable<T>> ArrayList<T> Merge_Sort_Merger(ArrayList<T> array_L, ArrayList<T> array_R) {
        ArrayList<T> sorted = new ArrayList<T>();
        
        int L_index = 0;
        int R_index = 0;
        
        for(; L_index < array_L.size() && R_index < array_R.size() ;) {
            T L_value = array_L.get(L_index);
            T R_value = array_R.get(R_index);
            if(L_value.compareTo(R_value) <= 0){
                sorted.add(L_value);
                L_index++;
            }else {
                sorted.add(R_value);
                R_index++;
            }
        }

        //adds potential L leftover
        for(; L_index < array_L.size() ; L_index++) {
            T L_value = array_L.get(L_index);
            sorted.add(L_value);
        }

        //adds potential R leftover
        for(; R_index < array_R.size() ; R_index++) {
            T R_value = array_R.get(R_index);
            sorted.add(R_value);
        }

        return sorted; 
    }
    public static ArrayList<Integer> Random_Integer_Array() {
        ArrayList<Integer> array = new ArrayList<>();
        for (int index = 0; index < 101 ;index++) {
            int randomInt = (int) (Math.random() * 101);
            array.add(randomInt);
        }
        return array;
    }
    public static ArrayList<Double> Random_Double_Array() {
        ArrayList<Double> array = new ArrayList<>();
        for (int index = 0; index < 101 ;index++) {
            double randomDouble = Math.random() * 101;
            array.add(randomDouble);
        }
        return array;
    }
    public static ArrayList<Character> Random_Char_Array() {
        ArrayList<Character> array = new ArrayList<Character>();
        for (int index = 0; index < 101 ;index++) {
            char randomLetter = (char) ('a' + (int) (Math.random() * 26));
            array.add(randomLetter);
        }
        return array;
    }
    public static ArrayList<String> Random_String_Array() {
        ArrayList<String> array = new ArrayList<String>();
        for (int index = 0; index < 101 ;index++) {
            int string_length = (int) (Math.random() * 10) + 1;
            String string = "";
            for (int index2 = 0; index2 < string_length ; index2++) {
                char randomLetter = (char) ('a' + (int) (Math.random() * 26));
                string += randomLetter;
            }
            
            array.add(string);
        }
        return array;
    }
    // public static <T> ArrayList<T> Random
    

    public static void main(String[] args) throws Exception {
        while(true) {
            String response;
            Scanner scanner = new Scanner(System.in);

            while (true) { // exit code
                System.out.println("\n");
                System.out.println("Type in \"bubble\" to sort a random data type array using bubble sorting or \"merge\" to sort a random data type array using merge sorting");
                response = scanner.nextLine(); // response is a String
                switch (response) { // Switch based on user input
                    case "bubble":
                        int random_data_type1 = (int) (Math.random() * 4); // random_data_type1 is an int
                        switch (random_data_type1) {
                            case 0: // int 
                                System.out.println("Integer has been randomly chosen");
                                ArrayList<Integer> random_array1 = Random_Integer_Array();
                                ArrayList<Integer> sorted_array1 = Bubble_Sort(random_array1);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array1.get(index));
                                }
                                break;
                            case 1: // double
                            System.out.println("Double has been randomly chosen");
                                ArrayList<Double> random_array2 = Random_Double_Array();
                                ArrayList<Double> sorted_array2 = Bubble_Sort(random_array2);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array2.get(index));
                                }
                                break;
                            case 2: // char
                                System.out.println("Character has been randomly chosen");
                                ArrayList<Character> random_array3 = Random_Char_Array();
                                ArrayList<Character> sorted_array3 = Bubble_Sort(random_array3);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array3.get(index));
                                }
                                break;
                            case 3: // string
                                System.out.println("String has been randomly chosen");
                                ArrayList<String> random_array4 = Random_String_Array();
                                ArrayList<String> sorted_array4 = Bubble_Sort(random_array4);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array4.get(index));
                                }
                                break;
                        }
                        break; // Bubble end
                        
                    case "merge":
                        int random_data_type = (int) (Math.random() * 4); // random_data_type is an int
                        switch (random_data_type) {
                            case 0: // int
                                System.out.println("Integer has been randomly chosen"); 
                                ArrayList<Integer> random_array = Random_Integer_Array();
                                ArrayList<Integer> sorted_array = Merge_Sort_Array_Splitter(random_array);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array.get(index));
                                }
                                break;
                            case 1: // double
                                System.out.println("Double has been randomly chosen");
                                ArrayList<Double> random_array2 = Random_Double_Array();
                                ArrayList<Double> sorted_array2 = Merge_Sort_Array_Splitter(random_array2);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array2.get(index));
                                }
                                break;
                            case 2: // char
                                System.out.println("Character has been randomly chosen");
                                ArrayList<Character> random_array3 = Random_Char_Array();
                                ArrayList<Character> sorted_array3 = Merge_Sort_Array_Splitter(random_array3);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array3.get(index));
                                }
                                break;
                            case 3: // string
                                System.out.println("String has been randomly chosen");
                                ArrayList<String> random_array4 = Random_String_Array();
                                ArrayList<String> sorted_array4 = Merge_Sort_Array_Splitter(random_array4);
                                for (int index = 0; index < 100; index++) {
                                    System.out.println(sorted_array4.get(index));
                                }
                                break;
                        }
                        break; // Merge end
                        
                    default:
                        System.out.println("Please enter a valid key word");
                        continue;
                }
            break;
            }
            
            while(true) { //exit code
                System.out.println("Type in \"continue\" to restart the program or type in \"exit\" to close the program");
                response = scanner.nextLine();
                switch(response){
                    case "exit":
                        scanner.close();
                        System.exit(0);
                    case "continue":
                        break;
                    default:
                        System.out.println("Please enter a valid key word");
                        continue;
                }
                break;
            }
        }
    }
}
