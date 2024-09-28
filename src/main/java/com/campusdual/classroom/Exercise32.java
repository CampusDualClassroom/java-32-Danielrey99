package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;

public class Exercise32 {

    public static void main(String[] args) {
        printToFile(null);
    }

    public static String generateStringToSave(String string) {
        if(string != null){
            return string;
        }else {
            return generateUserInputToSave();
        }
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        File file = new File("src/main/resources/data.txt");
        PrintWriter pw = null;
        try {

            pw= new PrintWriter(new FileWriter(file));
            String saveText = generateStringToSave(string);
            pw.println(saveText);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pw.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }


}
