package nl.tkp.pas;

public class NatuurlijkPersoon {
    public String psn_id;
    public String sofinummer;
    public String gbanummer;
    public String naam;
    public String voorletters;
    public String voornamen;
    public String voorvoegsel;
    public String naamgebruik;
    public String titels;
    public String geboortedatum;
    public String overlijdensdatum;
    public String geslacht;

    public NatuurlijkPersoon(String psn_id, String sofinummer, String gbanummer, String naam, String voorletters, String voornamen, String voorvoegsel, String naamgebruik, String titels, String geboortedatum, String overlijdensdatum, String geslacht) {
        this.psn_id = psn_id;
        this.sofinummer = sofinummer;
        this.gbanummer = gbanummer;
        this.naam = naam;
        this.voorletters = voorletters;
        this.voornamen = voornamen;
        this.voorvoegsel = voorvoegsel;
        this.naamgebruik = naamgebruik;
        this.titels = titels;
        this.geboortedatum = geboortedatum;
        this.overlijdensdatum = overlijdensdatum;
        this.geslacht = geslacht;
    }
}
