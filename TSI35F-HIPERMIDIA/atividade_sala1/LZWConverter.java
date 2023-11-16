import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LZWConverter {

    public static String convert(String palavra){
        int lenth = palavra.length();

        Map<String, Integer> dicionario = new HashMap<>();
        
        // Passo 1: Adicionar todas as letras ao mapa
    
        char[] letras = palavra.toCharArray();
        Arrays.sort(letras);
        String palavraOrdenada = new String(letras); 

        int temp = 1;
        for(int i = 0; i < lenth; i++){
            Integer put = dicionario.put(String.valueOf(palavraOrdenada.charAt(i)), temp);
            if(put == null){
                temp++;
            }
        }
        // S = S + C

        StringBuilder cod = new StringBuilder();

        String s = "";
        for(int i = 0; i < lenth; i++){

            

            String c = String.valueOf(palavra.charAt(i));
            String combined = String.valueOf(s+c);

            System.out.println("S: "+ s+" C: "+ c);
            
            Integer v = dicionario.put(combined, temp);
            
            if (v == null){
                cod.append(temp);
                temp++;
                s = combined.substring(0, combined.length());
            }else{
                cod.append(v);
                s = new String(c);
            }
            
        }
        return cod.toString();
    }

}