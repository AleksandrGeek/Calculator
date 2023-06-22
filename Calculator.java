package Kata.Calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.println("Input: ");
        String exp = scn.nextLine();

        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }

        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }


        String[] data = exp.split(regexActions[actionIndex]);

        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

        boolean isRoman = converter.isRoman(data[0]);
        if(isRoman) {

            a = converter.romanToInt(data[0]);
            b = converter.romanToInt(data[1]);

        }else{



            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);

        }
            //выполняем с числами арифметическое действие
            int result;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if(isRoman) {
                System.out.println(converter.intToRoman(result));
            }else if(a > 10 || b > 10 ) {
                System.out.println("Числа принимаються от 1 до 10");
            }
            else {

                System.out.println("Output: " + "\n " +  result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");


        }



    }
}