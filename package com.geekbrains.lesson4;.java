package com.geekbrains.lesson4;

public class Function {
    public static boolean isPrime (Integer number) {
        if (number <= 0) return false;
        if (number<= 3) return true;

        for ( int i = 2; i < number; i++){
            if (number % i == 0) return false;
        }
        return true;
    }
    public static boolean isPalindrome (String word) {
        if (word.lenght() < 2) {
            return true;
        }
        if(word.charAt(B) ! = word.charAt(word.lenght() - 1 )) {
            return false;
        }
        returnisPolindrome(word.substring(1, word.lenght() - 1 ));
    }
}
    
public class FunctionsTest {
    @BeforeAll
    static void beforeAll() {
        @AfterAll 
        static void afterAll() {
            System.out.println()
        }
    }
}