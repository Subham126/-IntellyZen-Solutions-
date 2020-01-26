package com.templeCal;
import java.util.Arrays;
import java.util.Scanner;

public class MinCostToReachTemple {
	// Function to return the minimum cost 
    static int minimumCost(int price[], int n) 
    { 
        // Sort the price array 
        Arrays.sort(price); 
        int totalCost = 0; 
        // Calculate minimum price 
        // of n-2 most costly person 
        for (int i = n - 1; i > 1; i -= 2) 
        { 
            if (i == 2) 
            { 
                totalCost += price[2] + price[0]; 
            } 
            else
            { 
                // Both the ways as discussed above 
                int price_first = price[i] + price[0] + 2 * price[1]; 
                int price_second = price[i] + price[i - 1] + 2 * price[0]; 
                totalCost += Math.min(price_first, price_second); 
            } 
        } 
      
        // Calculate the minimum price 
        // of the two cheapest person 
        if (n == 1) 
        { 
            totalCost += price[0]; 
        } 
        else
        { 
            totalCost += price[1]; 
        } 
        return totalCost; 
    }
    public static void main(String[] args) {
        int no_of_test_case, no_of_person;
        //Getting input
        Scanner s = new Scanner(System.in);
        no_of_test_case = s.nextInt();
        int min_cost_list[] = new int[no_of_test_case];
        for (int i = 0; i < no_of_test_case; i++) {
        	no_of_person = s.nextInt();
        	int a[] = new int[no_of_person];
            for(int j = 0; j < no_of_person; j++) {
            	a[j] = s.nextInt();
            }
            System.out.println(a);
            System.out.println(no_of_person);
            min_cost_list[i] = minimumCost(a, no_of_person);
        }
        //Print minimum cost
        for(int i = 0; i < min_cost_list.length; i++) {
        	System.out.println(min_cost_list[i]);
        }
    }
}
