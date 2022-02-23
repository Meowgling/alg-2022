package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину маршрута: ");
        int length = in.nextInt();
        System.out.print("Введите максимальную высоту: ");
        int high = in.nextInt();
        System.out.print("Введите максимальный перепад высот: ");
        int dif = in.nextInt();
	    int[] travel = new int[length];
        TravelMaker(travel, dif, high);
        ShowTravel(travel,high);

    }

    static void TravelMaker(int[] travel, int dif, int high) {
        Random random = new Random();
        for(int i=0; i< travel.length; i++){
            if (i==0) travel[i]= random.nextInt(dif);
            else {
                do{
                    travel[i]= random.nextInt(high);
                } while ((travel[i]-travel[i-1])>dif ||(travel[i-1]-travel[i])>dif);
            }
        }
    }

    static void ShowTravel(int[] travel, int high){
        for (int i = high; i>0; i--){
            for (int j = 0; j < travel.length; j++){
                if (travel[j]>=i) System.out.print('*');
                else if (travel[j]==0 && i==1) System.out.print('_');
                else System.out.print(' ');
            }
            System.out.println();
        }
        for (int j = 0; j < travel.length; j++)
            System.out.print(travel[j]);
    }
}
