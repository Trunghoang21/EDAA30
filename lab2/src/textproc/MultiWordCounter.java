package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {
    
    
    private Map<String,Integer> myMap;
    // myMap är det enda attribut som klassen har.
    // man måste se till att skapa en new obj of type Map  


    public MultiWordCounter(String[] words){
        myMap = new HashMap<String,Integer>();
        for(int i = 0; i < words.length; i++){
            myMap.put( words[i].toLowerCase(), 0);
        }
    }

    public void process(String s){
        if( myMap.containsKey(s)){
            // checka om ordet s finns i Mappen 
            myMap.replace(s, myMap.get(s)+1);
            // öka value med 1 om det händer. 
        }
    }

    public void report(){
        
        myMap.forEach((k, v) -> System.out.println(k + ":" + v));
        // används en lambda utrryck och forEach metod som finns i 
        // HashMap för att skriva ut ord och antal gånger de sökta orden förekommer;
    }

}
