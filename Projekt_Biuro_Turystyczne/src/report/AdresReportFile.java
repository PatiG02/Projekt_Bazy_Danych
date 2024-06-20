package report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.AdresDAO;

public class AdresReportFile {
	public static void saveAdresList() throws IOException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String formattedDate = dateFormatter.format(new Date());
		String path = "C:\\temp\\AdresList" + formattedDate + ".txt" ;
		BufferedWriter b = new BufferedWriter(new FileWriter(path));
		try {
			ResultSet rs = AdresDAO.getAllAdres();
			int columnCount = rs.getMetaData().getColumnCount();
	
	        // Write the column names
	        for (int i = 1; i <= columnCount; i++) {
	            b.write(rs.getMetaData().getColumnName(i));
	            if (i < columnCount) {
	                b.write(", ");
	            }
	        }
	        b.newLine();
	        // Iterate through the rs and write each row to the file
	        while (rs.next()) {
	            for (int i = 1; i <= columnCount; i++) {
	            	if (rs.getString(i)!=null) {
	                b.write(rs.getString(i));
	                }else {
	                	b.write("");
	                }
	                if (i < columnCount) {
	                    b.write(", ");
	                }
	            }
	            b.newLine();
	        }
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
		b.close();
    }
}
