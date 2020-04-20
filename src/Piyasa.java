import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.event.MouseMotionAdapter;





public class Piyasa extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JPanel piyasa;
    private JPanel degisim;
    private JPanel grafik;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public Piyasa() {
        setContentPane(contentPane);
        setModal(true);
        tabbedPane.addMouseMotionListener(new MouseMotionAdapter() {
        });
    }


    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        UserHandler handler = new UserHandler();

        saxParser.parse("http://realtime.paragaranti.com/asp/xml/icpiyasaX.xml", handler);
        Piyasa dialog = new Piyasa();
        dialog.pack();

        dialog.textArea1.setText(handler.deneme);
        dialog.textArea2.setText(handler.deneme);
        dialog.setVisible(true);

        System.exit(0);
    }

}
