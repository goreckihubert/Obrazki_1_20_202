import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FtpClient {

    public static void ftpWikoDownload(String outputFileName) throws FileNotFoundException, UnsupportedEncodingException {
        FTPClient client = new FTPClient();
        String date = date();
        String remoteFile1 = date + "_wiko_stany.csv";
        Reader reader = new BufferedReader( new InputStreamReader( new FileInputStream(remoteFile1), "UTF8"));
        try {
            client.connect("ftp.regedit.pl", 21);
            boolean login = client.login("wiko@regedit.pl", "w4taDcsG");
            System.out.println(login);
            String remoteFile1 = date + "_wiko_stany.csv";
            File downloadFile1 = new File("C:\\Users\\HUBERT\\Downloads\\" + outputFileName + ".csv");
            OutputStream outputStream1 =
                    new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = client.retrieveFile(remoteFile1, outputStream1);
            System.out.println(success);
            outputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String date(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        Date todaysDate = new Date();
        String date;
        date = dateFormat.format(todaysDate);

        return date;
    }
}