package klasser;

/**
 * Created by ArntKristoffer on 09.03.2016.
 */
public class Skilt_med_tekst extends Skilt{

    private String tekst;

    public Skilt_med_tekst(int skiltnr, String tekst){
        this.skiltnr = skiltnr;
        this.skiltgruppe = 2;
        this.tekst = tekst;
    }

    public String hentTekst(){
        return this.tekst;
    }

}
