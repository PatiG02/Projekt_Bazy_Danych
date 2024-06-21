package report;

import dao.PosrednikUmowaDAO;
import model.PosrednikUmowa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PosrednikUmowaReportFile {
    public static void savePosrednikUmowaReport() throws IOException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String formattedDate = dateFormatter.format(new Date());
        String path = "C:\\temp\\PosrednikUmowaReport_" + formattedDate + ".txt";
        BufferedWriter b = new BufferedWriter(new FileWriter(path));

        PosrednikUmowaDAO dao = new PosrednikUmowaDAO();
        List<PosrednikUmowa> reportList = dao.getPosrednikUmowaReport();

        // Write the column names
        b.write("ID Pośrednika, Pośrednik Nazwa, Email, Nr Telefonu, NIP, Umowa Count");
        b.newLine();

        // Write each row of the report
        for (PosrednikUmowa entry : reportList) {
            b.write(entry.getIdPosrednika() + ", " +
                    entry.getPosrednikNazwa() + ", " +
                    entry.getEmail() + ", " +
                    entry.getNrTelefonu() + ", " +
                    entry.getNip() + ", " +
                    entry.getUmowaCount());
            b.newLine();
        }

        b.close();
    }
}
