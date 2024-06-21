package report;

import dao.KoloniaUmowaDAO;
import model.KoloniaUmowa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class KoloniaUmowaReportFile {
    public static void saveKoloniaUmowaReport() throws IOException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String formattedDate = dateFormatter.format(new Date());
        String path = "C:\\temp\\KoloniaUmowaReport_" + formattedDate + ".txt";
        BufferedWriter b = new BufferedWriter(new FileWriter(path));

        KoloniaUmowaDAO dao = new KoloniaUmowaDAO();
        List<KoloniaUmowa> reportList = dao.getKoloniaUmowaReport();

        // Write the column names
        b.write("ID Umowy, Umowa Nazwa, ID Kolonii, Ilość Miejsc, Data Rozpoczęcia, Data Zakończenia, Cena");
        b.newLine();

        // Write each row of the report
        for (KoloniaUmowa entry : reportList) {
            b.write(entry.getIdUmowy() + ", " +
                    entry.getUmowaNazwa() + ", " +
                    entry.getIdKolonii() + ", " +
                    entry.getIloscMiejsc() + ", " +
                    entry.getDataRozpoczecia() + ", " +
                    entry.getDataZakonczenia() + ", " +
                    entry.getCena());
            b.newLine();
        }

        b.close();
    }
}
