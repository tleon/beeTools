package ragus.lienty.asynctask;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Slivo on 04/03/2017.
 */

public class StorageManager {

    protected static String filename = "processedNotifications.txt";

    public static void saveNotificationId(Context context, String notificationId) {

        FileOutputStream outputStream;

        String notificationIdString = String.format(notificationId + "%n");

        try {
            outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(notificationIdString.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNotificationNew (Context context, String notificationId) {

        StorageManager.checkDataFile(context);

        String storedNotifications = readFileAsString(context);

        return storedNotifications.contains(notificationId);
    }

    protected static void checkDataFile(Context context) {

        File file = new File(context.getFilesDir(), filename);

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readFileAsString(Context context) {

        String result = "";
        File file = new File(context.getFilesDir(), filename);

        if ( file.exists() ) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                char current;
                while (fis.available() > 0) {
                    current = (char) fis.read();
                    result = result + String.valueOf(current);
                }

            } catch (Exception e) {
                Log.d("TourGuide", e.toString());
            } finally {
                if (fis != null)
                    try {
                        fis.close();
                    } catch (IOException ignored) {
                    }
            }
        }
        return result;
    }
}
