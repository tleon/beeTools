package ragus.lienty.beetools;

import android.app.Notification;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

import ragus.lienty.beetools.Account;
import ragus.lienty.beetools.Characters;
import ragus.lienty.beetools.NotificationSettings;
import ragus.lienty.beetools.Notifications;
import ragus.lienty.beetools.R;

/**
 * Created by leone on 14/02/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "beetools.db";
    private static final int DATABASE_VERION = 1;

    private Dao<Account, Integer> accountDao;
    private Dao<Characters, Integer> charactersDao;
    private Dao<Notifications, Integer> notificationsDao;
    private Dao<NotificationSettings, Integer> notificationSettingsDao;

    private RuntimeExceptionDao<Account, Integer> accountRuntimeExceptionDao;
    private RuntimeExceptionDao<Characters, Integer> charactersRuntimeExceptionDao;
    private RuntimeExceptionDao<Notifications, Integer> notificationsRuntimeExceptionDao;
    private RuntimeExceptionDao<NotificationSettings, Integer> notificationSettingstimeExceptionDao;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Account.class);
            TableUtils.createTable(connectionSource, Characters.class);
            TableUtils.createTable(connectionSource, Notifications.class);
            TableUtils.createTable(connectionSource, NotificationSettings.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            TableUtils.dropTable(connectionSource, NotificationSettings.class, true);
            TableUtils.dropTable(connectionSource, Notifications.class, true);
            TableUtils.dropTable(connectionSource, Characters.class, true);
            TableUtils.dropTable(connectionSource, Account.class, true);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Dao<Account, Integer> getAccountDao()throws SQLException{
        if (accountDao == null){
            accountDao = getDao(Account.class);
        }
        return accountDao;
    }

    public Dao<Characters, Integer> getCharactersDao()throws SQLException{
        if (charactersDao == null){
            charactersDao = getDao(Characters.class);
        }
        return charactersDao;
    }

    public Dao<Notifications, Integer> getNotificationsDao()throws SQLException{
        if (notificationsDao == null){
            notificationsDao = getDao(Notifications.class);
        }
        return notificationsDao;
    }

    public Dao<NotificationSettings, Integer> getNotificationSettingsDao()throws SQLException{
        if (notificationSettingsDao == null){
            notificationSettingsDao = getDao(NotificationSettings.class);
        }
        return notificationSettingsDao;
    }

    public RuntimeExceptionDao<Account, Integer> getAccountRuntimeExceptionDao(){
        if(accountRuntimeExceptionDao == null){
            accountRuntimeExceptionDao = getRuntimeExceptionDao(Account.class);
        }
        return accountRuntimeExceptionDao;
    }

    public RuntimeExceptionDao<Characters, Integer> getCharactersRuntimeExceptionDao(){
        if(charactersRuntimeExceptionDao == null){
            charactersRuntimeExceptionDao = getRuntimeExceptionDao(Characters.class);
        }
        return charactersRuntimeExceptionDao;
    }

    public RuntimeExceptionDao<Notifications, Integer> getNotificationsRuntimeExceptionDao(){
        if(notificationsRuntimeExceptionDao == null){
            notificationsRuntimeExceptionDao = getRuntimeExceptionDao(Notifications.class);
        }
        return notificationsRuntimeExceptionDao;
    }

    public RuntimeExceptionDao<NotificationSettings, Integer> getNotificationSettingsRuntimeExceptionDao(){
        if(notificationSettingstimeExceptionDao == null){
            notificationSettingstimeExceptionDao = getRuntimeExceptionDao(NotificationSettings.class);
        }
        return notificationSettingstimeExceptionDao;
    }

}
