package java14;

import java5.enumExamples.Season;

public class SwitchExpressions {
    public static void main(String[] args) {
        int numOfCharacters = 0;
        Season season = Season.FALL;
        switch (season) {
            case FALL:
                numOfCharacters = 4;
                break;
            case SPRING, SUMMER, WINTER:
                numOfCharacters = 6;
                break;
            default:
                throw new IllegalStateException(("Invalid season " + season));
        }
        System.out.println(numOfCharacters);


        //java 14
        //switch with arrow notation
        numOfCharacters = 0;
        Season aSeason = Season.FALL;
        switch (aSeason) {
            case SPRING, SUMMER, WINTER -> System.out.println(6);
            case FALL                   ->  System.out.println((int) Math.pow(2, 2));
            default                     ->
                throw new IllegalStateException(("Invalid season: " + aSeason));
        }

        //Switch expression with return value using yield keyword
        Season nextSeason = Season.SPRING;
        numOfCharacters = switch (nextSeason) {
            case SPRING, SUMMER, WINTER :  yield 6;
            case FALL                   : yield (int) Math.pow(2, 2);
            default                     :
                    throw new IllegalStateException(("Invalid season: " + nextSeason));
        };
        System.out.println("nextSeason " + nextSeason);

        //Switch with arrow notation and return value with yield keyword
        Season newSeason = Season.WINTER;
        numOfCharacters = switch (newSeason) {
            case SPRING, SUMMER, WINTER -> { yield 6; }
            case FALL                   -> {yield (int) Math.pow(2, 2);}
            default                     ->
                throw new IllegalStateException(("Invalid season: " + newSeason));
        };
        System.out.println("nextSeason " + newSeason);

        //Switch with arrow notation and return value without yield keyword
        Season nextNewSeason = Season.SUMMER;
        numOfCharacters = switch (newSeason) {
            case SPRING, SUMMER, WINTER -> 6;
            case FALL                   -> (int) Math.pow(2, 2);
            default                     ->
                    throw new IllegalStateException(("Invalid season: " + newSeason));
        };
        System.out.println("nextSeason " + nextNewSeason);
    }

}
