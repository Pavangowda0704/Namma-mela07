package com.nammamela.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile SeatDao _seatDao;

  private volatile FanCommentDao _fanCommentDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `seats` (`seatNumber` INTEGER NOT NULL, `isBooked` INTEGER NOT NULL, `bookedBy` TEXT, PRIMARY KEY(`seatNumber`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `fan_comments` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fanName` TEXT, `comment` TEXT, `timestamp` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2a91880fade31efc3d1628721c27099a')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `seats`");
        db.execSQL("DROP TABLE IF EXISTS `fan_comments`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsSeats = new HashMap<String, TableInfo.Column>(3);
        _columnsSeats.put("seatNumber", new TableInfo.Column("seatNumber", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeats.put("isBooked", new TableInfo.Column("isBooked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSeats.put("bookedBy", new TableInfo.Column("bookedBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSeats = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSeats = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSeats = new TableInfo("seats", _columnsSeats, _foreignKeysSeats, _indicesSeats);
        final TableInfo _existingSeats = TableInfo.read(db, "seats");
        if (!_infoSeats.equals(_existingSeats)) {
          return new RoomOpenHelper.ValidationResult(false, "seats(com.nammamela.data.model.Seat).\n"
                  + " Expected:\n" + _infoSeats + "\n"
                  + " Found:\n" + _existingSeats);
        }
        final HashMap<String, TableInfo.Column> _columnsFanComments = new HashMap<String, TableInfo.Column>(4);
        _columnsFanComments.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFanComments.put("fanName", new TableInfo.Column("fanName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFanComments.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFanComments.put("timestamp", new TableInfo.Column("timestamp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFanComments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFanComments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFanComments = new TableInfo("fan_comments", _columnsFanComments, _foreignKeysFanComments, _indicesFanComments);
        final TableInfo _existingFanComments = TableInfo.read(db, "fan_comments");
        if (!_infoFanComments.equals(_existingFanComments)) {
          return new RoomOpenHelper.ValidationResult(false, "fan_comments(com.nammamela.data.model.FanComment).\n"
                  + " Expected:\n" + _infoFanComments + "\n"
                  + " Found:\n" + _existingFanComments);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "2a91880fade31efc3d1628721c27099a", "c38ecd01dc1f0da32afabfce8cf8ff52");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "seats","fan_comments");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `seats`");
      _db.execSQL("DELETE FROM `fan_comments`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SeatDao.class, SeatDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FanCommentDao.class, FanCommentDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public SeatDao seatDao() {
    if (_seatDao != null) {
      return _seatDao;
    } else {
      synchronized(this) {
        if(_seatDao == null) {
          _seatDao = new SeatDao_Impl(this);
        }
        return _seatDao;
      }
    }
  }

  @Override
  public FanCommentDao fanCommentDao() {
    if (_fanCommentDao != null) {
      return _fanCommentDao;
    } else {
      synchronized(this) {
        if(_fanCommentDao == null) {
          _fanCommentDao = new FanCommentDao_Impl(this);
        }
        return _fanCommentDao;
      }
    }
  }
}
