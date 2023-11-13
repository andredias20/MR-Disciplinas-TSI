package atividade1;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


class Atividade1 {

    private static List<String> chaves = Arrays.asList("-","1990","1990-1995","1995","1995-2000","1999-2001","2000","2000-2002","2000-2005","2001","2001-2003","2002","2002-2004","2003","2003-2005","2004","2004-2006","2005","2005-2007","2005-2010","2006","2006-2008","2007","2007-2009","2008","2008-2010","2009","2009-2011","2010","2010-2012","2010-2015","2011","2011-2013","2012","2012-2014","2013","2013-2015","2014","2014-2016","2015","2015-2017","2015-2020","2016","2016-2018","2017","2017-2019","2018","2018-2020","2019","2020","2021");

    private Map<String, List<Indicador>> listagemIndicadores = new TreeMap<>();

    public static void main(String[] args) throws Exception{
        
        var request =  HttpRequest.newBuilder()
                            .uri(new URI("https://servicodados.ibge.gov.br/api/v1/paises/BR%7CRU%7CIN%7CCN%7CZA/indicadores/77844"))
                            .GET()
                            .build();

        var json = HttpClient.newHttpClient()
                                .send(request, BodyHandlers.ofString())
                                .body();
       Gson gson = new Gson();
       Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();

       List<Map<String, Object>> lista = gson.fromJson(json,type );

       Map<String, Object> map = lista.get(0);

       List<Map<String, Object>> paises = (List<Map<String, Object>>) map.get("series");
       
        for(Map<String, Object> pais : paises){
            Map<String, String> paisDados = (Map<String, String>) pais.get("pais");

            String idPais = paisDados.get("id");

            List<Map<String, Object>> indicadores  = (List<Map<String, Object>>) pais.get("serie");
            Map<String, Object> listaAgrupada = new TreeMap<>();
            
            indicadores.forEach(a -> listaAgrupada.putAll(a));
            
            chaves.forEach(c -> {
                listagemIndicadores.put(c, listaAgrupada.get(c));
            });

            System.out.println(listaAgrupada);

        }
    }
}
