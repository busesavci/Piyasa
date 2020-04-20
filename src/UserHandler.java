import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class UserHandler extends DefaultHandler {

    boolean sembol = false;
    boolean desc = false;
    boolean son = false;
    boolean pernc = false;
    boolean pernc_sayisi = false;
    boolean son_degisim = false;
    String deneme = "";

    @Override
    public void startElement(String uri, String localName,String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("SYMBOL")) {
            sembol = true;
        }

        if (qName.equalsIgnoreCase("DESC")) {
            desc = true;
        }

        if (qName.equalsIgnoreCase("LAST")) {
            son = true;
        }

        if (qName.equalsIgnoreCase("PERNC")) {
            pernc = true;
        }

        if (qName.equalsIgnoreCase("PERNC_NUMBER")) {
            pernc_sayisi = true;
        }
        if (qName.equalsIgnoreCase("LAST_MOD")) {
            son_degisim = true;
        }

    }


    public void characters(char ch[], int start, int length) throws SAXException {

        if (sembol) {
            deneme = deneme + " \nSembol : " + new String(ch, start, length);

            sembol = false;
        }

        if (desc) {

            deneme = deneme + " \nDesc : " + new String(ch, start, length);
            desc = false;

        }

        if (son) {
            deneme = deneme + " \nSon : " + new String(ch, start, length);

            son = false;
        }

        if (pernc) {
            deneme = deneme + " \nPernc : " + new String(ch, start, length);
            pernc = false;
        }
        if (pernc_sayisi) {
            deneme = deneme + " \nPernc Sayisi : " + new String(ch, start, length);

            pernc_sayisi = false;
        }
        if (son_degisim) {
            deneme = deneme + " \nSon Guncelleme : " + new String(ch, start, length);

            son_degisim = false;
        }

    }
}