import java.util.*;

public class PucharPolski extends SezonPilkarski{
    private List<Klub> klubyPozostaleWGrze = new ArrayList<>();

    public PucharPolski(String nazwaSezonu){
        super(nazwaSezonu);
    }
    @Override
    public void generujTerminarzSezonu() throws GenerujTerminarzException{
        if(listaKlubow.isEmpty()){
            throw new GenerujTerminarzException("BŁĄD, BRAK KLUBÓW W ZAWODACH!");
        }
        try{
            if(klubyPozostaleWGrze.isEmpty()) {
                klubyPozostaleWGrze = new ArrayList<>(listaKlubow);
            }
            int nrRundy = terminarz.size()+1;
            List<Klub> klubyDoLosowania = new ArrayList<>(klubyPozostaleWGrze);
            KolejkaLigowa k = new KolejkaLigowa(nrRundy);
            Random rand = new Random();
            while(klubyDoLosowania.size()>1){
                int losGosp = rand.nextInt(klubyDoLosowania.size());
                Klub gosp = klubyDoLosowania.remove(losGosp);
                int losGosc = rand.nextInt(klubyDoLosowania.size());
                Klub gosc = klubyDoLosowania.remove(losGosc);
                Spotkanie sp = new Spotkanie(gosp, gosc);
                k.dodajMecz(sp);
            }
            terminarz.add(k);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void generujTabele() throws GenerujTabeleException{
        if(listaKlubow.isEmpty()){
            throw new GenerujTabeleException("BŁĄD, BRAK KLUBÓW W ZAWODACH!");
        }
        if(klubyPozostaleWGrze.isEmpty()){
            throw new GenerujTabeleException("BRAK WYGENEROWANEGO TERMINARZA!");
        }
        try{
            System.out.println("+----------------------------+");
            System.out.println("|===KLUBY POZOSTALE W GRZE===|");
            System.out.println("+----------------------------+");
            for(Klub kluby : klubyPozostaleWGrze){
                System.out.printf("| %-26s |\n", kluby.pobierzNazwe());
            }
            System.out.println("+----------------------------+");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }    

}
