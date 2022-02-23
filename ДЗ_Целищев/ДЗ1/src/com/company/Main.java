package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int players;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число игроков: ");
        do{
            players = in.nextInt();
            if(players<2) System.out.println("Игроков не может быть меньше двух");
            if(players>10) System.out.println("Игроков не может быть больше 10");
        } while (players<2 || players > 13);

        //Создали и инициализировали массив объектов заданого класса
        PlayingCard[] deck = new PlayingCard[PlayingCard.RANK_LIST.length*PlayingCard.SUITS_LIST.length];
        DeckBuilder(deck);

        final Random random = new Random();

        //Раздача рук путем "удаления" из колоды сыгранных карт
        for(int i = 1; i<=players; i++){
            System.out.print("Рука игрока "+i+" : ");
            for (int j=0; j < 5; j++){
                int randomNum;
                do{
                    randomNum = random.nextInt(deck.length);
                } while (deck[randomNum]==null);
                System.out.print(deck[randomNum].toString());
                deck[randomNum]=null;
                if(j<4) System.out.print(", ");
            }
            System.out.println();
        }
    }

    //Метод создания колоды
    static void DeckBuilder(PlayingCard[] deck){
        for (int i =0; i< PlayingCard.SUITS_LIST.length; i++){
            for(int j=0; j<PlayingCard.RANK_LIST.length;j++){
                PlayingCard pc = new PlayingCard(PlayingCard.SUITS_LIST[i],PlayingCard.RANK_LIST[j]);
                deck[i*PlayingCard.RANK_LIST.length+j]=pc;
            }
        }
    }
}

class PlayingCard {
    public static final String[] SUITS_LIST = {
            "Пик", "Бубен", "Черв", "Треф"
    };
    public static final String[] RANK_LIST = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Валет", "Королева", "Король", "Туз"
    };
    private String suit = null;
    private String rank = null;
    public PlayingCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString() {
        return rank+" "+suit;
    }
}
