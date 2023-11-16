package Java.atividade2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atividade2 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        
        pessoas.add(new Pessoa("Carlos", new Date(), "123.345.657.89"));
        pessoas.add(new Pessoa("Victor", new Date(), "123.345.657.89"));
        pessoas.add(new Pessoa("Will", new Date(), "123.345.657.89"));

        

        pessoas.forEach(p -> {
            
        });

    }
}
