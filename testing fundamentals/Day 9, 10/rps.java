package org.example;

import java.util.Random;
import java.util.Scanner;

public class rps {

    public static void main(String[] args) {
        int p1 = 0;
        int p2 = 0;
        Scanner obj = new Scanner(System.in);

        for (int i = 0; i <=5; i++) {


            System.out.println("Enter Player 1 selection (Rock=0 or Paper=1 or Scissors=2)==> ");
            int player1 = obj.nextInt();


            Random rand = new Random();
            int p2rand = rand.nextInt(2);
            System.out.println("Player 2 Chose (Rock=0 or Paper=1 or Scissors=2) ==> " + p2rand);

            if (player1 == p2rand) {
                System.out.println("Roll Again");
            } else if (player1 == 0 && p2rand == 1) {
                System.out.println("Player 2 Scored");
                p2++;
            } else if (player1 == 1 && p2rand == 0) {
                System.out.println("Player 1 Scored");
                p1++;
            } else if (player1 == 2 && p2rand == 0) {
                System.out.println("Player 2 Scored");
                p2++;
            } else if (player1 == 0 && p2rand == 2) {
                System.out.println("Player 1 Scored");
                p1++;
            } else if (player1 == 1 && p2rand == 2) {
                System.out.println("Player 2 Scored");
                p2++;
            } else if (player1 == 2 && p2rand == 1) {
                System.out.println("Player 1 Scored");
                p1++;
            }


        }

        System.out.println("Player 1 Score ==> " + p1);
        System.out.println("Player 2 Score ==> " + p2);

        if(p1>p2)
        {
            System.out.println("Player 1 Wins the Game with "+p1+" Points");
        }
        else {
            System.out.println("Player 2 Wins the Game with " + p2 + " Points");
        }

    }

}
