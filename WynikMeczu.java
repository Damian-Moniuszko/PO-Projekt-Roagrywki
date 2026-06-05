public class WynikMeczu {
    private int goleGospodarz;
    private int goleGosc;
    public WynikMeczu(int goleGospodarz, int goleGosc){
        this.goleGospodarz = goleGospodarz;
        this.goleGosc = goleGosc;
    }
    public int pobierzGoleGospodarz(){
        return goleGospodarz;
    }
    public int pobierzGoleGosc(){
        return goleGosc;
    }
    //public boolean czyRemis(){}

    //public int pobierzRozniceGoli(){}
}
