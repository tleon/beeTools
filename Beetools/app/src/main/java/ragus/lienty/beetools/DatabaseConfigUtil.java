package ragus.lienty.beetools;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by leone on 14/02/2017.
 */

public class DatabaseConfigUtil extends OrmLiteConfigUtil {

    private static final Class<?>[] classes = new Class[]{
            Account.class, Characters.class, Notifications.class, NotificationSettings.class
    };
    public static void main(String[] args) throws SQLException, IOException {

        // Provide the name of .txt file which you have already created and kept in res/raw directory
        writeConfigFile(new File("E:\\Projects\\Beetools\\app\\src\\main\\res\\raw\\ormlite_config.txt"));
    }
}