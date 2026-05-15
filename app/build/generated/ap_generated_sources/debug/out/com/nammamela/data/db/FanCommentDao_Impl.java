package com.nammamela.data.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammamela.data.model.FanComment;
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
public final class FanCommentDao_Impl implements FanCommentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FanComment> __insertionAdapterOfFanComment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FanCommentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFanComment = new EntityInsertionAdapter<FanComment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `fan_comments` (`id`,`fanName`,`comment`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final FanComment entity) {
        statement.bindLong(1, entity.id);
        if (entity.fanName == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.fanName);
        }
        if (entity.comment == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.comment);
        }
        if (entity.timestamp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.timestamp);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM fan_comments";
        return _query;
      }
    };
  }

  @Override
  public void insertComment(final FanComment comment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFanComment.insert(comment);
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
  public List<FanComment> getAllComments() {
    final String _sql = "SELECT * FROM fan_comments ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFanName = CursorUtil.getColumnIndexOrThrow(_cursor, "fanName");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final List<FanComment> _result = new ArrayList<FanComment>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final FanComment _item;
        final String _tmpFanName;
        if (_cursor.isNull(_cursorIndexOfFanName)) {
          _tmpFanName = null;
        } else {
          _tmpFanName = _cursor.getString(_cursorIndexOfFanName);
        }
        final String _tmpComment;
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _tmpComment = null;
        } else {
          _tmpComment = _cursor.getString(_cursorIndexOfComment);
        }
        final String _tmpTimestamp;
        if (_cursor.isNull(_cursorIndexOfTimestamp)) {
          _tmpTimestamp = null;
        } else {
          _tmpTimestamp = _cursor.getString(_cursorIndexOfTimestamp);
        }
        _item = new FanComment(_tmpFanName,_tmpComment,_tmpTimestamp);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
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
