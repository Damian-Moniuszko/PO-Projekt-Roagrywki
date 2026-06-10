import java.util.*;

public class PucharPolski extends SezonPilkarski{
    private List<Klub> klubyPozostaleWGrze = new ArrayList<>();

    public PucharPolski(String nazwaSezonu){
        super(nazwaSezonu);
    }
    @Override
    public void generujTerminarzSezonu(){
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
    }

    @Override
    public void generujTabele(){
        System.out.println("+----------------------------+");
        System.out.println("|===KLUBY POZOSTALE W GRZE===|");
        System.out.println("+----------------------------+");
        for(Klub kluby : klubyPozostaleWGrze){
            System.out.printf("| %-26s |\n", kluby.pobierzNazwe());
        }
        System.out.println("+----------------------------+");
    }    

}
