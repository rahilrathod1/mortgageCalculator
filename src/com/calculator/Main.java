package com.calculator;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principle ($1k -$1M): ");
        int principle = scanner.nextInt();

        while(!(principle >1000 && principle <=1000000)){
            System.out.println("Enter a number between 1,000 and 1,00,000");
            System.out.print("Principle ($1k -$1M): ");
            principle = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();

        while(!(annualInterestRate>0 && annualInterestRate<30)){
            System.out.println("Enter a value greater than 0 and less than 30");
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
        }
        System.out.print("Period (Years): ");
        int period = scanner.nextInt();
        System.out.print("Mortgage: ");

        //Monthly interest rate
        float monthlyInterestRate = (annualInterestRate/12)/100;

        //Number of payments
        int n = period*12;

        double monthInrWithPow = Math.pow((monthlyInterestRate+1),n);

        double mortgage = principle*(monthlyInterestRate*monthInrWithPow)/(monthInrWithPow-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: "+mortgageFormatted);
    }
}
