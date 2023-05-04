package com.example.appdoctruyen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appdoctruyen.model.BinhLuan;
import com.example.appdoctruyen.model.Chuong;
import com.example.appdoctruyen.model.LichSuDoc;
import com.example.appdoctruyen.model.Truyen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private Context context;
    private static final String DATABASE_NAME = "app_doctruyen.db";
    private SQLiteDatabase myDatabase;
    private static final String TABLE_TRUYEN = "Truyen";
    private static final String COLUMN_TRUYEN_ID = "id";
    private static final String COLUMN_TRUYEN_TEN = "ten";
    private static final String COLUMN_TRUYEN_TACGIA = "tagGia";

    private static final String COLUMN_TRUYEN_THELOAI = "theLoai";
    private static final String COLUMN_TRUYEN_SOCHUONG = "soChuong";
    private static final String COLUMN_TRUYEN_NOIDUNG = "noiDung";
    private static final String COLUMN_TRUYEN_IMAGE = "image";

    private static final String TABLE_CHUONG = "Chuong";
    private static final String COLUMN_CHUONG_ID = "id";
    private static final String COLUMN_CHUONG_TRUYEN_ID = "idTruyen";
    private static final String COLUMN_CHUONG_SO = "soThuTu";

    private static final String COLUMN_CHUONG_TEN = "ten";
    private static final String COLUMN_CHUONG_NOIDUNG = "noiDung";

    private static final String TABLE_BINHLUAN = "BinhLuan";
    private static final String COLUMN_BINHLUAN_ID = "id";
    private static final String COLUMN_BINHLUAN_TRUYEN_ID = "truyen_id";
    private static final String COLUMN_BINHLUAN_TEN_ND = "tenND";
    private static final String COLUMN_BINHLUAN_NOIDUNG = "noiDung";

    private static final String TABLE_LICH_SU_DOC = "LichSuDoc";
    private static final String COLUMN_LICH_SU_DOC_ID = "id";
    private static final String COLUMN_LICH_SU_DOC_TEN_NGUOI_DUNG = "tenNguoiDung";
    private static final String COLUMN_LICH_SU_DOC_ID_TRUYEN = "idTruyen";
    private static final String COLUMN_LICH_SU_DOC_TEN_TRUYEN = "tenTruyen";
    private static final String COLUMN_LICH_SU_DOC_TEN_CHAPTER = "tenChapter";
    private static final String COLUMN_LICH_SU_DOC_CHAPTER_NUMBER = "chapterNumber";
    private static final String COLUMN_LICH_SU_DOC_READ_TIME = "readTime";
    private static final String COLUMN_LICH_SU_DOC_IMAGE = "image";
    private static String DATABASE_PATH = "";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

        DATABASE_PATH = context.getDatabasePath(DATABASE_NAME).toString();
        createDatabase();
    }


//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        String CREATE_TRUYEN_TABLE = "CREATE TABLE " + TABLE_TRUYEN + "("
//                + COLUMN_TRUYEN_ID + " INTEGER PRIMARY KEY,"
//                + COLUMN_TRUYEN_TEN + " TEXT,"
//                + COLUMN_TRUYEN_TACGIA + " TEXT,"
//                + COLUMN_TRUYEN_THELOAI + "TEXT,"
//                + COLUMN_TRUYEN_SOCHUONG + " INTEGER,"
//                + COLUMN_TRUYEN_NOIDUNG + " TEXT,"
//                + COLUMN_TRUYEN_IMAGE + " TEXT" + ")";
//        db.execSQL(CREATE_TRUYEN_TABLE);
//
//        String CREATE_CHUONG_TABLE = "CREATE TABLE " + TABLE_CHUONG + "("
//                + COLUMN_CHUONG_ID + " INTEGER PRIMARY KEY,"
//                + COLUMN_CHUONG_TRUYEN_ID + " INTEGER,"
//                + COLUMN_CHUONG_SO + " INTEGER,"
//                + COLUMN_CHUONG_TEN + " TEXT,"
//                + COLUMN_CHUONG_NOIDUNG + " TEXT,"
//                + " FOREIGN KEY (" + COLUMN_CHUONG_TRUYEN_ID + ") REFERENCES " + TABLE_TRUYEN + "(" + COLUMN_TRUYEN_ID + ")"
//                + ")";
//        db.execSQL(CREATE_CHUONG_TABLE);
//
//        String CREATE_BINHLUAN_TABLE = "CREATE TABLE " + TABLE_BINHLUAN + "("
//                + COLUMN_BINHLUAN_ID + " INTEGER PRIMARY KEY,"
//                + COLUMN_BINHLUAN_TRUYEN_ID + " INTEGER,"
//                + COLUMN_BINHLUAN_TEN_ND + " TEXT,"
//                + COLUMN_BINHLUAN_NOIDUNG + " TEXT,"
//                + " FOREIGN KEY (" + COLUMN_BINHLUAN_TRUYEN_ID + ") REFERENCES " + TABLE_TRUYEN + "(" + COLUMN_TRUYEN_ID + ")"
//                + ")";
//        db.execSQL(CREATE_BINHLUAN_TABLE);
//    }

//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRUYEN);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHUONG);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BINHLUAN);
//
//        // Create tables again
//        onCreate(db);
//    }



    public void addTruyen(Truyen truyen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TRUYEN_TEN, truyen.getTen());
        values.put(COLUMN_TRUYEN_TACGIA, truyen.getTacGia());
        values.put(COLUMN_TRUYEN_THELOAI, truyen.getTheLoai());
        values.put(COLUMN_TRUYEN_SOCHUONG, truyen.getSoChuong());
        values.put(COLUMN_TRUYEN_NOIDUNG, truyen.getNoiDung());
        values.put(COLUMN_TRUYEN_IMAGE, truyen.getImage());
        db.insert(TABLE_TRUYEN, null, values);
        db.close();
    }

    public Truyen getTruyen(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TRUYEN, new String[]{COLUMN_TRUYEN_ID,
                        COLUMN_TRUYEN_TEN, COLUMN_TRUYEN_TACGIA, COLUMN_TRUYEN_THELOAI, COLUMN_TRUYEN_SOCHUONG, COLUMN_TRUYEN_NOIDUNG, COLUMN_TRUYEN_IMAGE}, COLUMN_TRUYEN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Truyen truyen = new Truyen(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)), cursor.getString(5), cursor.getString(6));
        return truyen;
    }

    public List<Truyen> getAllTruyen() {
        List<Truyen> truyenList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_TRUYEN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Truyen truyen = new Truyen();
                truyen.setId(Integer.parseInt(cursor.getString(0)));
                truyen.setTen(cursor.getString(1));
                truyen.setTacGia(cursor.getString(2));
                truyen.setTheLoai(cursor.getString(3));
                truyen.setSoChuong(Integer.parseInt(cursor.getString(4)));
                truyen.setNoiDung(cursor.getString(5));
                truyen.setImage(cursor.getString(6));
                truyenList.add(truyen);
            } while (cursor.moveToNext());
        }
        return truyenList;
    }

    public List<Truyen> searchTruyenByName(String tenTruyen) {
        List<Truyen> truyenList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TRUYEN, new String[] {COLUMN_TRUYEN_ID,
                        COLUMN_TRUYEN_TEN, COLUMN_TRUYEN_TACGIA, COLUMN_TRUYEN_THELOAI,
                        COLUMN_TRUYEN_SOCHUONG, COLUMN_TRUYEN_NOIDUNG, COLUMN_TRUYEN_IMAGE}, COLUMN_TRUYEN_TEN + " LIKE ?",
                new String[] { "%" + tenTruyen + "%" }, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Truyen truyen = new Truyen();
                truyen.setId(Integer.parseInt(cursor.getString(0)));
                truyen.setTen(cursor.getString(1));
                truyen.setTacGia(cursor.getString(2));
                truyen.setTheLoai(cursor.getString(3));
                truyen.setSoChuong(Integer.parseInt(cursor.getString(4)));
                truyen.setNoiDung(cursor.getString(5));
                truyen.setImage(cursor.getString(6));
                truyenList.add(truyen);
            } while (cursor.moveToNext());
        }
        return truyenList;
    }

    public Chuong getChuong(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CHUONG, new String[] { COLUMN_CHUONG_ID,
                        COLUMN_CHUONG_TRUYEN_ID, COLUMN_CHUONG_SO, COLUMN_CHUONG_TEN, COLUMN_CHUONG_NOIDUNG }, COLUMN_CHUONG_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Chuong chuong = new Chuong(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                cursor.getString(3), cursor.getString(4));

        cursor.close();

        return chuong;
    }

    public int getNextChapterId(int currentChapterSoThuTu, int idTruyen) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHUONG, new String[] { COLUMN_CHUONG_ID },
                COLUMN_CHUONG_TRUYEN_ID + "=? AND " + COLUMN_CHUONG_SO + ">?",
                new String[] { String.valueOf(idTruyen), String.valueOf(currentChapterSoThuTu) },
                null, null, COLUMN_CHUONG_SO + " ASC", "1");

        if (cursor != null && cursor.moveToFirst()) {
            int nextChapterId = Integer.parseInt(cursor.getString(0));
            cursor.close();
            return nextChapterId;
        } else {
            return -1; // Không tìm thấy chương tiếp theo
        }
    }


    public List<Chuong> getChuongListByIdTruyen(int idTruyen) {
        List<Chuong> chuongList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CHUONG + " WHERE " + COLUMN_CHUONG_TRUYEN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(idTruyen)});

        if (cursor.moveToFirst()) {
            do {
                Chuong chuong = new Chuong();
                chuong.setId(Integer.parseInt(cursor.getString(0)));
                chuong.setIdTruyen(Integer.parseInt(cursor.getString(1)));
                chuong.setSoThuTu(Integer.parseInt(cursor.getString(2)));
                chuong.setTen(cursor.getString(3));
                chuong.setNoiDung(cursor.getString(4));
                chuongList.add(chuong);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return chuongList;
    }


    // Add new comment
    public void addBinhLuan(BinhLuan binhLuan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_BINHLUAN_TRUYEN_ID, binhLuan.getIdTruyen());
        values.put(COLUMN_BINHLUAN_TEN_ND, binhLuan.getTenNguoiDung());
        values.put(COLUMN_BINHLUAN_NOIDUNG, binhLuan.getNoiDung());

        db.insert(TABLE_BINHLUAN, null, values);
        db.close();
    }

    // Get all comments of a story
    public List<BinhLuan> getAllBinhLuan(int idTruyen) {
        List<BinhLuan> binhLuanList = new ArrayList<BinhLuan>();

        String selectQuery = "SELECT * FROM " + TABLE_BINHLUAN + " WHERE " + COLUMN_BINHLUAN_TRUYEN_ID + " = " + idTruyen;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BinhLuan binhLuan = new BinhLuan();
                binhLuan.setId(cursor.getInt(0));
                binhLuan.setIdTruyen(cursor.getInt(1));
                binhLuan.setTenNguoiDung(cursor.getString(2));
                binhLuan.setNoiDung(cursor.getString(3));

                binhLuanList.add(binhLuan);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return binhLuanList;
    }


    public void addOrUpdateLichSuDoc(int idTruyen, String tenNguoiDung, String tenTruyen, String tenChapter, int chapterNumber, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LICH_SU_DOC_TEN_NGUOI_DUNG, tenNguoiDung);
        values.put(COLUMN_LICH_SU_DOC_TEN_TRUYEN, tenTruyen);
        values.put(COLUMN_LICH_SU_DOC_TEN_CHAPTER, tenChapter);
        values.put(COLUMN_LICH_SU_DOC_CHAPTER_NUMBER, chapterNumber);
        values.put(COLUMN_LICH_SU_DOC_IMAGE, image);
        Date date = new Date(); // Đối tượng Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()); // Định dạng ngày/tháng/năm
        String dateString = sdf.format(new Date().getTime()); // Chuyển đổi thành chuỗi ngày/tháng/năm
        values.put(COLUMN_LICH_SU_DOC_READ_TIME,dateString ); // Thêm giá trị cho trường read_time

        String query = "SELECT * FROM " + TABLE_LICH_SU_DOC + " WHERE " + COLUMN_LICH_SU_DOC_ID_TRUYEN + " = " + idTruyen;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            // Update existing record
            db.update(TABLE_LICH_SU_DOC, values, COLUMN_LICH_SU_DOC_ID_TRUYEN + " = " + idTruyen, null);
        } else {
            // Add new record
            values.put(COLUMN_LICH_SU_DOC_ID_TRUYEN, idTruyen);
            db.insert(TABLE_LICH_SU_DOC, null, values);
        }
        cursor.close();
        db.close();
    }


    public List<LichSuDoc> getAllLichSuByIdUser(String tenNguoiDung) {
        List<LichSuDoc> lichSuList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_LICH_SU_DOC +
                " WHERE " + COLUMN_LICH_SU_DOC_TEN_NGUOI_DUNG + " = '" + tenNguoiDung+ "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                LichSuDoc lichSu = new LichSuDoc();
                lichSu.setId(Integer.parseInt(cursor.getString(0)));
                lichSu.setTenNguoiDung(cursor.getString(1));
                lichSu.setIdTruyen(Integer.parseInt(cursor.getString(2)));
                lichSu.setTenTruyen(cursor.getString(3));
                lichSu.setTenChapter(cursor.getString(4));
                lichSu.setChapterNumber(Integer.parseInt(cursor.getString(5)));
                lichSu.setReadTime(cursor.getString(6));
                lichSu.setImage(cursor.getString(7));
                lichSuList.add(lichSu);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lichSuList;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDatabase() {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            try {
                copyDataBase();
            } catch (IOException e) {
                System.out.println("Error copying database");
            }
        }
    }

    //Check database already exist or not
    private boolean checkDataBase() {
        boolean checkDB = false;
        try {
            String myPath = DATABASE_PATH;
            File dbfile = new File(myPath);
            checkDB = dbfile.exists();
        } catch(SQLiteException e) {
            System.out.println("Error checkDatabase");
        }
        return checkDB;
    }

    private void copyDataBase() throws IOException{
        String outFileName = DATABASE_PATH;
        OutputStream myOutput = new FileOutputStream(outFileName);
        InputStream myInput = context.getAssets().open(DATABASE_NAME);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0)
        {
            myOutput.write(buffer, 0, length);
        }
        myInput.close();
        myOutput.flush();
        myOutput.close();
    }
}
