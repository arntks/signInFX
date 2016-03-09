package klasser;

/**
 * Created by ArntKristoffer on 09.03.2016.
 */
public class runSignIn {

    public static void main(String[] args){
        String nokkel = lesKort() + ".txt";
        Splitt splitt = new Splitt(nokkel);
        File fil = splitt.getFile();
        splitt.dele(fil);
        ArrayList<Skilt> skilt = splitt.getSkiltGruppe();

        for (int i = 0; i < skilt.size(); i++){
            String print = "Skiltgruppe: " + skilt.get(i).getSkiltgruppe() +
                    ", Skiltnummer: " + skilt.get(i).getSkiltnr();
            if (skilt.get(i).getSkiltgruppe() == 2){
                print = print + ", Skilttekst: " +((Skilt_med_tekst) skilt.get(i)).hentTekst();
            }
            System.out.println(print);
        }
    }

    private static String lesKort(){
        Scanner scanner = new Scanner(System.in);
        String kortnr = scanner.next();
        scanner.close();
        return kortnr;
    }
}
