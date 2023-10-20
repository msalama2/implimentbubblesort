package implimentbubblesort;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class bubble {

         static void welcome(){
        System.out.println("\nHello and welcome to my app! Below is an application that reads input of integer array and\nprocesses,it assigning random values to the array length.\nThen sorts the values from least to greatest.");

    }

    public static int[] createRandomArray(int arrayLength) {
            Random random = new Random();
            
            int[] randomArray = new int[arrayLength];
       
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(101);
        }
        
        return randomArray;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            
        for (int n : array) {
                writer.println(n); 
            }
            
        } 
        catch (IOException e) {
            
            System.err.println("Error:\n " + e.getMessage());
        }
    }

    public static int[] readFileToArray(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
        return reader.lines().mapToInt(Integer::parseInt).toArray();
        }
         
        catch (IOException e) {
            
            System.err.println("Error:\n " + e.getMessage());
        }
        
        return new int[0]; 
    }

    public static void bubbleSort(int[] array) {
        Arrays.sort(array);
        
    }

    public static void main(String[] args) {
        welcome();
            Scanner scanner = new Scanner(System.in);
        
            System.out.println("\nEnter Desired length of array: ");
        
            int arrayLength = scanner.nextInt();

            int[] randomArray = createRandomArray(arrayLength);
        
            System.out.println("\nRandom Array:\n " + Arrays.toString(randomArray));

            String filename = "output.txt";

                writeArrayToFile(randomArray, filename);

            int[] readArray = readFileToArray(filename);
       
                bubbleSort(readArray);
        
            System.out.println("\nBubble Sort Array:\n " + Arrays.toString(readArray));

        scanner.close();
    }
}



