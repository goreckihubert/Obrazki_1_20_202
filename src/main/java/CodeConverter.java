import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CodeConverter {

    public static Map loadFileToMap() throws IOException {

        File file = new File("C:\\Users\\HUBERT\\Downloads\\myac.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Map finalMap = new TreeMap();
        String temp;
        while((temp = br.readLine())!=null){
            temp.replace("  ", " ");
            String code = temp.substring(0,temp.indexOf(";"));
            String quantity = temp.substring(temp.indexOf(";") + 1, temp.length() - 1);

            String codePart1 = code.substring(0, code.indexOf(" "));
            codePart1 = code.replace("+", "");
            String codePart2 = code.substring(code.indexOf(" ")+1);
            codePart2 = codePart2.substring(0, codePart2.indexOf(" "));
            System.out.println(codePart1 + " ----- " + codePart2);
            String finalCode;
            if(codePart2.length()<=4) {
                finalCode = codePart1 + " " + codePart2;
            }
            else{
                finalCode = codePart1;
            }
            finalCode = finalCode.replace("\"", "");
            finalCode = finalCode.replace(" ", "");
            finalCode = finalCode.replace("FOTO", "");
            finalCode = finalCode.replace("ŚW.", "");
            finalCode = finalCode.replace("RAMKA", "");
            finalCode = finalCode.replace("OBRAZ", "");
            finalCode = finalCode.replace("ALBUM", "");
            finalCode = finalCode.replace("RAM", "");
            finalCode = finalCode.replace("KRZYŻ", "");
            finalCode = "OB" + finalCode;

            System.out.println(finalCode);

            finalMap.put(finalCode, quantity);

        }

        return finalMap;
    }

    public static void mapToFile(Map<String, Integer> mapa) throws IOException {

        File file = new File("C:\\Users\\HUBERT\\Downloads\\obrazki.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (Map.Entry<String, Integer> entry : mapa.entrySet()){
            System.out.println(entry.getKey() + ";" + entry.getValue() + "\n");
                bw.append(entry.getKey() + ";" + entry.getValue() + "\n");
        }
        bw.close();

    }
}
