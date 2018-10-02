package nl.groningen.lveekhout;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        if(args.length!=1){
            System.out.println("Eén parameter is vereist! Niet meer, niet minder");
        } else {
            File dir = new File(args[0]);
            if (!dir.exists()) System.out.println(String.format("Directory %s bestaan niet", args[0]));
            else new Main().zoekStart(dir);
        }
    }

    private void zoekStart(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) zoekStart(file);
            else if (file.getAbsolutePath().endsWith("-app\\src\\build\\docker\\start.sh")) System.out.println(file.getAbsolutePath());
        }
    }
}