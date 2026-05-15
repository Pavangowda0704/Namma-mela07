package com.nammamela.data.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammamela.data.model.Seat;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SeatDao_Impl implements SeatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Seat> __insertionAdapterOfSeat;

  private final EntityDeletionOrUpdateAdapter<Seat> __updateAdapterOfSeat;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SeatDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSeat = new EntityInsertionAdapter<Seat>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `seats` (`seatNumber`,`isBooked`,`bookedBy`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Seat entity) {
        statement.bindLong(1, entity.seatNumber);
        final int _tmp = entity.isBooked ? 1 : 0;
        statement.bindLong(2, _tmp);
        if (entity.bookedBy == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.bookedBy);
        }
      }
    };
    this.__updateAdapterOfSeat = new EntityDeletionOrUpdateAdapter<Seat>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `seats` SET `seatNumber` = ?,`isBooked` = ?,`bookedBy` = ? WHERE `seatNumber` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Seat entity) {
        statement.bindLong(1, entity.seatNumber);
        final int _tmp = entity.isBooked ? 1 : 0;
        statement.bindLong(2, _tmp);
        if (entity.bookedBy == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.bookedBy);
        }
        statement.bindLong(4, entity.seatNumber);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM seats";
        return _query;
      }
    };
  }

  @Override
  public void insertSeat(final Seat seat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSeat.insert(seat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSeat(final Seat seat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSeat.handle(seat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Seat> getAllSeats() {
    final String _sql = "SELECT * FROM seats ORDER BY seatNumber ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSeatNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "seatNumber");
      final int _cursorIndexOfIsBooked = CursorUtil.getColumnIndexOrThrow(_cursor, "isBooked");
      final int _cursorIndexOfBookedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "bookedBy");
      final List<Seat> _result = new ArrayList<Seat>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Seat _item;
        final int _tmpSeatNumber;
        _tmpSeatNumber = _cursor.getInt(_cursorIndexOfSeatNumber);
        final boolean _tmpIsBooked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsBooked);
        _tmpIsBooked = _tmp != 0;
        final String _tmpBookedBy;
        if (_cursor.isNull(_cursorIndexOfBookedBy)) {
          _tmpBookedBy = null;
        } else {
          _tmpBookedBy = _cursor.getString(_cursorIndexOfBookedBy);
        }
        _item = new Seat(_tmpSeatNumber,_tmpIsBooked,_tmpBookedBy);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAvailableCount() {
    final String _sql = "SELECT COUNT(*) FROM seats WHERE isBooked = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
