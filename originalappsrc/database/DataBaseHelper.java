package bih.p003in.forestdept.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import bih.p003in.forestdept.entity.Block;
import bih.p003in.forestdept.entity.District;
import bih.p003in.forestdept.entity.VillageListEntity;
import bih.p003in.forestdept.entity.ward;
import bih.p003in.forestdept.model.F_YearModel;
import bih.p003in.forestdept.model.GeoFencing;
import bih.p003in.forestdept.model.PanchayatList;
import bih.p003in.forestdept.model.PlantationDetailList;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import bih.p003in.forestdept.model.PlantationSiteList;
import bih.p003in.forestdept.model.UserDetail;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "PACSDB1";
    private static String DB_PATH = "/data/data/app.bih.in.nic.epacsmgmt/databases/";

    /* renamed from: db */
    SQLiteDatabase f164db;
    private final Context myContext;
    private SQLiteDatabase myDataBase;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 2);
        if (Build.VERSION.SDK_INT >= 4.2d) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.myContext = context;
    }

    public static String Array__Location(ArrayList<GeoFencing> list) {
        Gson serializer = new Gson();
        return serializer.toJson(list);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (!dbExist) {
            getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, 16);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = this.myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        getReadableDatabase().close();
        byte[] buffer = new byte[1024];
        while (true) {
            int length = myInput.read(buffer);
            if (length > 0) {
                myOutput.write(buffer, 0, length);
            } else {
                myOutput.flush();
                myOutput.close();
                myInput.close();
                return;
            }
        }
    }

    public void openDataBase() throws SQLException {
        getReadableDatabase();
        String myPath = DB_PATH + DB_NAME;
        this.myDataBase = SQLiteDatabase.openDatabase(myPath, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        SQLiteDatabase sQLiteDatabase = this.myDataBase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void modifyTable() {
        if (!isColumnExists("Ward", "AreaType")) {
            AlterTable("Ward", "AreaType");
        }
    }

    public void AlterManregTable(String tableName) {
        this.f164db = getReadableDatabase();
        try {
            if (!isColumnExists(tableName, "Work_Structure_Type_Name")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN Work_Structure_Type_Name TEXT");
                Log.e("ALTER Done", tableName + "- Work_Structure_Type_Name");
            }
            if (!isColumnExists(tableName, "Other_Name")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN Other_Name TEXT");
                Log.e("ALTER Done", tableName + "-Other_Name");
            }
            if (!isColumnExists(tableName, "Work_Structure_Type_Other_Name")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN Work_Structure_Type_Other_Name TEXT");
                Log.e("ALTER Done", tableName + "-Work_Structure_Type_Other_Name");
            }
            if (!isColumnExists(tableName, "VillageID")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN VillageID TEXT");
                Log.e("ALTER Done", tableName + "-VillageID");
            }
            if (!isColumnExists(tableName, "isUpdated")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN isUpdated TEXT");
                Log.e("ALTER Done", tableName + " - isUpdated");
            }
            if (!isColumnExists(tableName, "Types_OfSarchnaId")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN Types_OfSarchnaId TEXT");
                Log.e("ALTER Done", tableName + " - Types_OfSarchnaId");
            }
            if (!isColumnExists(tableName, "Types_OfSarchnaName")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN Types_OfSarchnaName TEXT");
                Log.e("ALTER Done", tableName + " - Types_OfSarchnaName");
            }
            if (!isColumnExists(tableName, "IsPhase1Inspected")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1Inspected TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase1Inspected");
            }
            if (!isColumnExists(tableName, "IsPhase1InspBy")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspBy TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase1InspBy");
            }
            if (!isColumnExists(tableName, "IsPhase1InspDate")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspDate TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase1InspDate");
            }
            if (!isColumnExists(tableName, "IsPhase1InspPhoto1")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspPhoto1 BLOB");
                Log.e("ALTER Done", tableName + " - IsPhase1InspPhoto1");
            }
            if (!isColumnExists(tableName, "IsPhase1InspPhoto2")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspPhoto2 BLOB");
                Log.e("ALTER Done", tableName + " - IsPhase1InspPhoto2");
            }
            if (!isColumnExists(tableName, "IsPhase1InspLatitude")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspLatitude TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase1InspLatitude");
            }
            if (!isColumnExists(tableName, "IsPhase1InspLongitude")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspLongitude TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase1InspLongitude");
            }
            if (!isColumnExists(tableName, "IsPhase1InspRemarks")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase1InspRemarks TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase1InspRemarks");
            }
            if (!isColumnExists(tableName, "IsPhase2Inspected")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2Inspected TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase2Inspected");
            }
            if (!isColumnExists(tableName, "IsPhase2InspBy")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspBy TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase2InspBy");
            }
            if (!isColumnExists(tableName, "IsPhase2InspDate")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspDate TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase2InspDate");
            }
            if (!isColumnExists(tableName, "IsPhase2InspPhoto1")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspPhoto1 BLOB");
                Log.e("ALTER Done", tableName + " - IsPhase2InspPhoto1");
            }
            if (!isColumnExists(tableName, "IsPhase2InspPhoto2")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspPhoto2 BLOB");
                Log.e("ALTER Done", tableName + " - IsPhase2InspPhoto2");
            }
            if (!isColumnExists(tableName, "IsPhase2InspLatitude")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspLatitude TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase2InspLatitude");
            }
            if (!isColumnExists(tableName, "IsPhase2InspLongitude")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspLongitude TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase2InspLongitude");
            }
            if (!isColumnExists(tableName, "IsPhase2InspRemarks")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase2InspRemarks TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase2InspRemarks");
            }
            if (!isColumnExists(tableName, "IsPhase3Inspected")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3Inspected TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase3Inspected");
            }
            if (!isColumnExists(tableName, "IsPhase3InspBy")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspBy TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase3InspBy");
            }
            if (!isColumnExists(tableName, "IsPhase3InspDate")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspDate TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase3InspDate");
            }
            if (!isColumnExists(tableName, "IsPhase3InspPhoto1")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspPhoto1 BLOB");
                Log.e("ALTER Done", tableName + " - IsPhase3InspPhoto1");
            }
            if (!isColumnExists(tableName, "IsPhase3InspPhoto2")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspPhoto2 BLOB");
                Log.e("ALTER Done", tableName + " - IsPhase3InspPhoto2");
            }
            if (!isColumnExists(tableName, "IsPhase3InspLatitude")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspLatitude TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase3InspLatitude");
            }
            if (!isColumnExists(tableName, "IsPhase3InspLongitude")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspLongitude TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase3InspLongitude");
            }
            if (!isColumnExists(tableName, "IsPhase3InspRemarks")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsPhase3InspRemarks TEXT");
                Log.e("ALTER Done", tableName + " - IsPhase3InspRemarks");
            }
            if (!isColumnExists(tableName, "IsFinalInspected")) {
                this.f164db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN IsFinalInspected TEXT");
                Log.e("ALTER Done", tableName + " - IsFinalInspected");
            }
        } catch (Exception e) {
            Log.e("ALTER Failed", "Menrega_Rural_Dev_Dept");
        }
    }

    public void AlterTable(String tableName, String columnName) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.f164db = readableDatabase;
        try {
            readableDatabase.execSQL("ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " TEXT");
            Log.e("ALTER Done", tableName + "-" + columnName);
        } catch (Exception e) {
            Log.e("ALTER Failed", tableName + "-" + columnName);
        }
    }

    public boolean isColumnExists(String table, String column) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.f164db = readableDatabase;
        Cursor cursor = readableDatabase.rawQuery("PRAGMA table_info(" + table + ")", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                if (column.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        cursor.close();
        return false;
    }

    public long insertUserDetails(UserDetail result) {
        long c = 0;
        try {
            SQLiteDatabase db = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("UserID", result.getUserId().toLowerCase());
            values.put("UserName", result.getName());
            values.put("UserPassword", "");
            values.put("Role", result.getUserrole());
            values.put("MobileNo", result.getMobileNo());
            values.put("IsMobileUpdated", result.getIsMobileUpdated());
            values.put("Email", result.getEmail());
            values.put("DeptName", result.getDepartment());
            values.put("DistCode", result.getDistrictCode());
            values.put("DistName", result.getDistName());
            values.put("BlockCode", result.getBlockCode());
            values.put("BlockName", result.getBlockName());
            values.put("PanchayatCode", result.getPanchayatCode());
            values.put("PanchayatName", result.getPanchayatName());
            values.put("LastVisitedDate", result.getLastVisitedOn());
            String[] whereArgs = {result.getUserId()};
            c = db.update("UserDetail", values, "UserID=? ", whereArgs);
            if (c <= 0) {
                c = db.insert("UserDetail", null, values);
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public UserDetail getUserDetails(String userId, String pass) {
        UserDetail userInfo = null;
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] params = {userId.toLowerCase().trim(), ""};
            Cursor cur = db.rawQuery("Select UserID,UserName,UserPassword,Role,MobileNo,Email,DeptName,DistCode,DistName,BlockCode,BlockName,PanchayatCode,PanchayatName,LastVisitedDate from UserDetail WHERE UserID=? and UserPassword=?", params);
            cur.getCount();
            while (cur.moveToNext()) {
                userInfo = new UserDetail();
                userInfo.setUserId(cur.getString(cur.getColumnIndex("UserID")));
                userInfo.setName(cur.getString(cur.getColumnIndex("UserName")));
                userInfo.setUserrole(cur.getString(cur.getColumnIndex("Role")));
                userInfo.setMobileNo(cur.getString(cur.getColumnIndex("MobileNo")));
                userInfo.setEmail(cur.getString(cur.getColumnIndex("Email")));
                userInfo.setDepartment(cur.getString(cur.getColumnIndex("DeptName")));
                userInfo.setDistrictCode(cur.getString(cur.getColumnIndex("DistCode")));
                userInfo.setDistName(cur.getString(cur.getColumnIndex("DistName")));
                userInfo.setBlockCode(cur.getString(cur.getColumnIndex("BlockCode")));
                userInfo.setBlockName(cur.getString(cur.getColumnIndex("BlockName")));
                userInfo.setPanchayatCode(cur.getString(cur.getColumnIndex("PanchayatCode")));
                userInfo.setPanchayatName(cur.getString(cur.getColumnIndex("PanchayatName")));
                userInfo.setLastVisitedOn(cur.getString(cur.getColumnIndex("LastVisitedDate")));
            }
            cur.close();
            db.close();
            return userInfo;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<F_YearModel> getFYearList() {
        ArrayList<F_YearModel> pdetail = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            try {
                String[] columns = {"FYID", "FYName"};
                Cursor cur = db.query("FYEAR", columns, null, null, null, null, "FYName");
                while (cur.moveToNext()) {
                    F_YearModel vl = new F_YearModel();
                    vl.set_FYear(cur.getString(cur.getColumnIndex("FYID")));
                    vl.set_FYearNameEng(cur.getString(cur.getColumnIndex("FYName")));
                    pdetail.add(vl);
                }
                cur.close();
                if (db != null) {
                    db.close();
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdetail;
    }

    public long UpdatePlantationInspectionDetail(PlantationInspDetails_Request entity, ArrayList<GeoFencing> list_saved_gps) {
        try {
            SQLiteDatabase db = getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("isUpdated", "1");
            values.put("AppVersion", entity.getAppVersion());
            values.put("verifiedBy", entity.getVerifiedBy());
            values.put("verifiedDate", entity.getVerifiedDate());
            values.put("IsInspectedBy", entity.getVerifiedBy());
            values.put("IsInspectedDate", entity.getIsInspectedDate());
            values.put("userRole", entity.getUserrole());
            values.put("Fyear", entity.getFyear());
            values.put("BhumiType", entity.getBhumiType());
            values.put("Ropit_PlantNo", entity.getRopit_PlantNo());
            values.put("Utarjibit_PlantNo", entity.getUtarjibit_PlantNo());
            values.put("UtarjibitaPercent", entity.getUtarjibitaPercent());
            values.put("Plantation_Site_Id", entity.getPlantation_Site_Id());
            values.put("Plantation_Site_Name", entity.getPlantation_Site_Name());
            values.put("Van_Posako_No", entity.getVan_Posako_No());
            values.put("Posak_bhugtaanMonth", entity.getPosak_bhugtaanMonth());
            values.put("Posak_bhugtaanYear", entity.getPosak_bhugtaanYear());
            values.put("gavyan_percentage", entity.getGavyan_percentage());
            values.put("Average_height_Plant", entity.getAverage_height_Plant());
            values.put("PlantAgainstDeadPlnt", entity.getPlantAgainstDeadPlnt());
            values.put(feedEntry.Remark, entity.getRemarks());
            String[] whereArgs = {String.valueOf(entity.getInspectionID())};
            long c = db.update("PlantationDetail", values, "InspectionID=? ", whereArgs);
            if (c > 0) {
                c = InsertOfficeLatLongs(db, list_saved_gps, entity.getInspectionID());
            }
            db.close();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long InsertOfficeLatLongs(SQLiteDatabase db1, ArrayList<GeoFencing> list, String isnpection_id) {
        long c = -1;
        ContentValues values = new ContentValues();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                try {
                    values.put("GeoSeqID", list.get(i).getGeoSeqID());
                    values.put("GeoFenLatitude", list.get(i).getGeoFenLatitude());
                    values.put("GeoFenLongitude", list.get(i).getGeoFenLongitude());
                    values.put("Insp_Id", isnpection_id);
                    String[] whereArgs = {String.valueOf(isnpection_id), list.get(i).getGeoSeqID()};
                    c = db1.update("Plantation_Lat_Lng", values, "Insp_Id=? AND GeoSeqID=?", whereArgs);
                    if (c != 1) {
                        c = db1.insert("Plantation_Lat_Lng", null, values);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return c;
                }
            }
        }
        return c;
    }

    public ArrayList<GeoFencing> getPlantation_Lat_Lng(String INS_ID) {
        ArrayList<GeoFencing> geoFencings = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        try {
            String[] params = {INS_ID};
            Cursor cur = db.rawQuery("SELECT * from Plantation_Lat_Lng WHERE Insp_Id=?", params);
            cur.getCount();
            while (cur.moveToNext()) {
                GeoFencing geoFencing = new GeoFencing();
                geoFencing.setGeoSeqID(cur.getString(cur.getColumnIndex("GeoSeqID")));
                geoFencing.setGeoFenLatitude(cur.getString(cur.getColumnIndex("GeoFenLatitude")));
                geoFencing.setGeoFenLongitude(cur.getString(cur.getColumnIndex("GeoFenLongitude")));
                geoFencings.add(geoFencing);
            }
            cur.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return geoFencings;
    }

    public long resetWellInspectionUpdatedData(String insepectionId) {
        long c = -1;
        try {
            SQLiteDatabase db = getWritableDatabase();
            String[] DeleteWhere = {String.valueOf(insepectionId)};
            c = db.delete("WellInspectionDetail", "id=?", DeleteWhere);
            db.close();
            return c;
        } catch (Exception e) {
            return c;
        }
    }

    public long deleteAllPlantationRecord() {
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("delete from PlantationDetail");
            db.close();
            return -1L;
        } catch (Exception e) {
            return -1L;
        }
    }

    public long resetPlantationInspectionUpdatedData(String insepectionId) {
        long c = -1;
        try {
            SQLiteDatabase db = getWritableDatabase();
            String[] DeleteWhere = {String.valueOf(insepectionId)};
            c = db.delete("PlantationDetail", "InspectionID=?", DeleteWhere);
            db.close();
            return c;
        } catch (Exception e) {
            return c;
        }
    }

    public long setPlantationDataToLocal(ArrayList<PlantationDetailList> list) {
        long c = -1;
        if (list != null) {
            try {
                SQLiteDatabase db = getReadableDatabase();
                ContentValues values = new ContentValues();
                for (int i = 0; i < list.size(); i++) {
                    values.put("DistID", list.get(i).getDistID());
                    values.put("DistName", list.get(i).getDistName());
                    values.put("BlockID", list.get(i).getBlockID());
                    values.put("BlockName", list.get(i).getBlockName());
                    values.put("PanchayatID", list.get(i).getPanchayatID());
                    values.put("PanchayatName", list.get(i).getPanchayatName());
                    values.put("WorkStateFyear", list.get(i).getWorkStateFyear());
                    values.put("WorkName", list.get(i).getWorkName());
                    values.put("WorkCode", list.get(i).getWorkCode());
                    values.put("Worktype", list.get(i).getWorktype());
                    values.put("AgencyName", list.get(i).getAgencyName());
                    values.put("SanctionAmtLabourCom", list.get(i).getSanctionAmtLabourCom());
                    values.put("SanctionAmtMaterialCom", list.get(i).getSanctionAmtMaterialCom());
                    values.put("InspectionID", list.get(i).getInspectionID());
                    values.put("IsInspectedByDSTAE", list.get(i).getIsInspectedByDSTAE());
                    values.put("IsInspectedByDSTEE", list.get(i).getIsInspectedByDSTEE());
                    values.put("IsInspectedByDSTDRDA", list.get(i).getIsInspectedByDSTDRDA());
                    values.put("IsInspectedByDSTDDC", list.get(i).getIsInspectedByDSTDDC());
                    values.put("isUpdated", "0");
                    values.put("LastInspectionDetails", list.get(i).getLastInspectionDetails());
                    String[] whereArgs = {String.valueOf(list.get(i).getInspectionID())};
                    c = db.update("PlantationDetail", values, "InspectionID=?", whereArgs);
                    if (c < 1) {
                        c = db.insert("PlantationDetail", null, values);
                    }
                }
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
                return c;
            }
        }
        return c;
    }

    public long setWardDataToLocal(ArrayList<ward> list) {
        long c = -1;
        DataBaseHelper dh = new DataBaseHelper(this.myContext);
        try {
            dh.createDataBase();
            if (list != null) {
                try {
                    SQLiteDatabase db = getReadableDatabase();
                    ContentValues values = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        values.put("WardName", list.get(i).getWardname());
                        values.put("WardCode", list.get(i).getWardCode());
                        values.put("PanchayatCode", list.get(i).getPanchayatCode());
                        values.put("AreaType", list.get(i).getAreaType());
                        String[] whereArgs = {String.valueOf(list.get(i).getWardCode())};
                        c = db.update("Ward", values, "WardCode=?", whereArgs);
                        if (c != 1) {
                            c = db.insert("Ward", null, values);
                        }
                    }
                    db.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return c;
                }
            }
            return c;
        } catch (IOException e1) {
            e1.printStackTrace();
            return -1L;
        }
    }

    public long setPlantationSiteDataToLocal(ArrayList<PlantationSiteList> list) {
        long c = -1;
        DataBaseHelper dh = new DataBaseHelper(this.myContext);
        try {
            dh.createDataBase();
            if (list != null) {
                try {
                    SQLiteDatabase db = getReadableDatabase();
                    ContentValues values = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        values.put("id", list.get(i).getId());
                        values.put("Site_Name", list.get(i).getPlantationNameEng());
                        values.put("Site_NameHin", list.get(i).getPlantationNameHindi());
                        String[] whereArgs = {String.valueOf(list.get(i).getId())};
                        c = db.update("PlantationSiteDetail", values, "id=?", whereArgs);
                        if (c != 1) {
                            c = db.insert("PlantationSiteDetail", null, values);
                        }
                    }
                    db.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return c;
                }
            }
            return c;
        } catch (IOException e1) {
            e1.printStackTrace();
            return -1L;
        }
    }

    public long setVillageDataToLocal(ArrayList<VillageListEntity> list) {
        long c = -1;
        DataBaseHelper dh = new DataBaseHelper(this.myContext);
        try {
            dh.createDataBase();
            if (list != null) {
                try {
                    SQLiteDatabase db = getReadableDatabase();
                    ContentValues values = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        values.put("VillageCode", list.get(i).getVillCode());
                        values.put("VillageName", list.get(i).getVillName());
                        values.put("PanchayatCode", list.get(i).getPanchayatCode());
                        values.put("BLOCKCODE", list.get(i).getBlockCode());
                        String[] whereArgs = {String.valueOf(list.get(i).getVillCode()), String.valueOf(list.get(i).getPanchayatCode())};
                        c = db.update("VillageList", values, "VillageCode=? AND PanchayatCode=?", whereArgs);
                        if (c != 1) {
                            c = db.insert("VillageList", null, values);
                        }
                        Log.e("Panchayat", list.get(i).getPanchayatCode());
                        Log.e("VillageCode", list.get(i).getVillCode());
                        Log.e("C", String.valueOf(c));
                    }
                    db.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return c;
                }
            }
            return c;
        } catch (IOException e1) {
            e1.printStackTrace();
            return -1L;
        }
    }

    public long setPanchayatDataToLocal(UserDetail userInfo, ArrayList<PanchayatList> list) {
        long c = -1;
        DataBaseHelper dh = new DataBaseHelper(this.myContext);
        try {
            dh.createDataBase();
            if (list != null) {
                try {
                    SQLiteDatabase db = getReadableDatabase();
                    ContentValues values = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        values.put("PanchayatCode", list.get(i).getPanchayat_Code());
                        values.put("PanchayatName", list.get(i).getPanchayat());
                        values.put("PACName", list.get(i).getAreaType());
                        values.put("BlockCode", userInfo.getBlockCode());
                        values.put("DistrictCode", userInfo.getDistrictCode());
                        values.put("DistrictName", userInfo.getDistName());
                        values.put("PartNo", ExifInterface.GPS_MEASUREMENT_2D);
                        String[] whereArgs = {String.valueOf(list.get(i).getPanchayat_Code())};
                        c = db.update("Panchayat", values, "PanchayatCode=?", whereArgs);
                        if (c != 1) {
                            c = db.insert("Panchayat", null, values);
                        }
                    }
                    db.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return c;
                }
            }
            return c;
        } catch (IOException e1) {
            e1.printStackTrace();
            return -1L;
        }
    }

    public String getPlantationUpdatedDataCount(String user_) {
        String[] params = {user_};
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor curPond = db.rawQuery("Select * from PlantationDetail WHERE verifiedBy=?", params);
            String pondCount = String.valueOf(curPond.getCount());
            return pondCount;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public ArrayList<PlantationInspDetails_Request> getPlantationInspectionUpdatedDetail(String user_ID) {
        ArrayList<PlantationInspDetails_Request> infoList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] params = {user_ID};
            Cursor cur = db.rawQuery("Select id,DistID,DistName,BlockID,BlockName,PanchayatID,PanchayatName,WorkStateFyear,WorkName,WorkCode,Worktype,AgencyName,SanctionAmtLabourCom,SanctionAmtMaterialCom,InspectionID,IsInspectedDate,IsInspectedBy,isUpdated,AppVersion,verifiedBy,verifiedDate,userRole,Fyear,BhumiType,Ropit_PlantNo,Utarjibit_PlantNo,UtarjibitaPercent,Utarjibit_90PercentMore,Utarjibit_75_90Percent,Utarjibit_50_75Percent,Utarjibit_25PercentLess,Remarks,Latitude_Mob,Longitude_Mob,Plantation_Site_Id,Plantation_Site_Name,Van_Posako_No,Posak_bhugtaanMonth,Posak_bhugtaanYear,gavyan_percentage,Average_height_Plant,PlantAgainstDeadPlnt,LastInspectionDetails,photo,photo1 from PlantationDetail WHERE verifiedBy=?", params);
            cur.getCount();
            while (cur.moveToNext()) {
                PlantationInspDetails_Request info = new PlantationInspDetails_Request();
                info.setId(cur.getInt(cur.getColumnIndex("id")));
                info.setDistCode(cur.getString(cur.getColumnIndex("DistID")));
                info.setDistName(cur.getString(cur.getColumnIndex("DistName")));
                info.setBlockCode(cur.getString(cur.getColumnIndex("BlockID")));
                info.setBlockName(cur.getString(cur.getColumnIndex("BlockName")));
                info.setPanchayatCode(cur.getString(cur.getColumnIndex("PanchayatID")));
                info.setPanchayatName(cur.getString(cur.getColumnIndex("PanchayatName")));
                info.setWorkStateFyear(cur.getString(cur.getColumnIndex("WorkStateFyear")));
                info.setWorkName(cur.getString(cur.getColumnIndex("WorkName")));
                info.setWorkCode(cur.getString(cur.getColumnIndex("WorkCode")));
                info.setWorktype(cur.getString(cur.getColumnIndex("Worktype")));
                info.setAgencyName(cur.getString(cur.getColumnIndex("AgencyName")));
                info.setSanctionAmtLabourCom(cur.getString(cur.getColumnIndex("SanctionAmtLabourCom")));
                info.setSanctionAmtMaterialCom(cur.getString(cur.getColumnIndex("SanctionAmtMaterialCom")));
                info.setInspectionID(cur.getString(cur.getColumnIndex("InspectionID")));
                info.setIsInspectedDate(cur.getString(cur.getColumnIndex("IsInspectedDate")));
                info.setIsInspectedBy(cur.getString(cur.getColumnIndex("IsInspectedBy")));
                info.setIsUpdated(cur.getString(cur.getColumnIndex("isUpdated")));
                info.setAppVersion(cur.getString(cur.getColumnIndex("AppVersion")));
                info.setVerifiedBy(cur.getString(cur.getColumnIndex("verifiedBy")));
                info.setVerifiedDate(cur.getString(cur.getColumnIndex("verifiedDate")));
                info.setUserrole(cur.getString(cur.getColumnIndex("userRole")));
                info.setFyear(cur.getString(cur.getColumnIndex("Fyear")));
                info.setBhumiType(cur.getString(cur.getColumnIndex("BhumiType")));
                info.setRopit_PlantNo(cur.getString(cur.getColumnIndex("Ropit_PlantNo")));
                info.setUtarjibit_PlantNo(cur.getString(cur.getColumnIndex("Utarjibit_PlantNo")));
                info.setUtarjibitaPercent(cur.getString(cur.getColumnIndex("UtarjibitaPercent")));
                info.setUtarjibit_90PercentMore(cur.getString(cur.getColumnIndex("Utarjibit_90PercentMore")));
                info.setUtarjibit_75_90Percent(cur.getString(cur.getColumnIndex("Utarjibit_75_90Percent")));
                info.setUtarjibit_50_75Percent(cur.getString(cur.getColumnIndex("Utarjibit_50_75Percent")));
                info.setUtarjibit_25PercentLess(cur.getString(cur.getColumnIndex("Utarjibit_25PercentLess")));
                info.setRemarks(cur.getString(cur.getColumnIndex(feedEntry.Remark)));
                info.setLatitude_Mob(cur.getString(cur.getColumnIndex("Latitude_Mob")));
                info.setLongitude_Mob(cur.getString(cur.getColumnIndex("Longitude_Mob")));
                info.setPlantation_Site_Id(cur.getString(cur.getColumnIndex("Plantation_Site_Id")));
                info.setPlantation_Site_Name(cur.getString(cur.getColumnIndex("Plantation_Site_Name")));
                info.setVan_Posako_No(cur.getString(cur.getColumnIndex("Van_Posako_No")));
                info.setPosak_bhugtaanMonth(cur.getString(cur.getColumnIndex("Posak_bhugtaanMonth")));
                info.setPosak_bhugtaanYear(cur.getString(cur.getColumnIndex("Posak_bhugtaanYear")));
                info.setGavyan_percentage(cur.getString(cur.getColumnIndex("gavyan_percentage")));
                info.setAverage_height_Plant(cur.getString(cur.getColumnIndex("Average_height_Plant")));
                info.setPlantAgainstDeadPlnt(cur.getString(cur.getColumnIndex("PlantAgainstDeadPlnt")));
                info.setLastInspectionDetails(cur.getString(cur.getColumnIndex("LastInspectionDetails")));
                if (!cur.isNull(cur.getColumnIndex("photo"))) {
                    byte[] imgData = cur.getBlob(cur.getColumnIndex("photo"));
                    Bitmap bmp = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
                    String encodedImg1 = Base64.encodeToString(outputStream.toByteArray(), 0);
                    info.setPhoto(encodedImg1);
                }
                if (!cur.isNull(cur.getColumnIndex(feedEntry.Phtot1))) {
                    byte[] imgData2 = cur.getBlob(cur.getColumnIndex(feedEntry.Phtot1));
                    Bitmap bmp2 = BitmapFactory.decodeByteArray(imgData2, 0, imgData2.length);
                    ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
                    bmp2.compress(Bitmap.CompressFormat.JPEG, 50, outputStream2);
                    String encodedImg12 = Base64.encodeToString(outputStream2.toByteArray(), 0);
                    info.setPhoto1(encodedImg12);
                }
                info.setPlantationGeoTaging_obj(Array__Location(getPlantation_Lat_Lng(info.getInspectionID())));
                infoList.add(info);
            }
            cur.close();
            db.close();
        } catch (Exception e) {
        }
        return infoList;
    }

    public ArrayList<PlantationInspDetails_Request> getPlantationDetail(String panchayatId) {
        ArrayList<PlantationInspDetails_Request> infoList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] params = {"0", panchayatId};
            Cursor cur = db.rawQuery("Select id,DistID,DistName,BlockID,BlockName,PanchayatID,PanchayatName,WorkStateFyear,WorkName,WorkCode,Worktype,AgencyName,SanctionAmtLabourCom,SanctionAmtMaterialCom,InspectionID,IsInspectedDate,IsInspectedBy,isUpdated,AppVersion,verifiedBy,verifiedDate,userRole,IsInspectedByDSTAE,IsInspectedByDSTEE,IsInspectedByDSTDRDA,IsInspectedByDSTDDC,Plantation_Site_Id,Plantation_Site_Name,Van_Posako_No,Posak_bhugtaanMonth,Posak_bhugtaanYear,gavyan_percentage,Average_height_Plant,PlantAgainstDeadPlnt,LastInspectionDetails from PlantationDetail WHERE isUpdated=? AND PanchayatID=?", params);
            cur.getCount();
            while (cur.moveToNext()) {
                if (cur.getString(cur.getColumnIndex("verifiedBy")) == null) {
                    PlantationInspDetails_Request info = new PlantationInspDetails_Request();
                    info.setId(cur.getInt(cur.getColumnIndex("id")));
                    info.setDistCode(cur.getString(cur.getColumnIndex("DistID")));
                    info.setDistName(cur.getString(cur.getColumnIndex("DistName")));
                    info.setBlockCode(cur.getString(cur.getColumnIndex("BlockID")));
                    info.setBlockName(cur.getString(cur.getColumnIndex("BlockName")));
                    info.setPanchayatCode(cur.getString(cur.getColumnIndex("PanchayatID")));
                    info.setPanchayatName(cur.getString(cur.getColumnIndex("PanchayatName")));
                    info.setWorkStateFyear(cur.getString(cur.getColumnIndex("WorkStateFyear")));
                    info.setWorkName(cur.getString(cur.getColumnIndex("WorkName")));
                    info.setWorkCode(cur.getString(cur.getColumnIndex("WorkCode")));
                    info.setWorktype(cur.getString(cur.getColumnIndex("Worktype")));
                    info.setAgencyName(cur.getString(cur.getColumnIndex("AgencyName")));
                    info.setSanctionAmtLabourCom(cur.getString(cur.getColumnIndex("SanctionAmtLabourCom")));
                    info.setSanctionAmtMaterialCom(cur.getString(cur.getColumnIndex("SanctionAmtMaterialCom")));
                    info.setInspectionID(cur.getString(cur.getColumnIndex("InspectionID")));
                    info.setIsInspectedDate(cur.getString(cur.getColumnIndex("IsInspectedDate")));
                    info.setIsInspectedBy(cur.getString(cur.getColumnIndex("IsInspectedBy")));
                    info.setIsUpdated(cur.getString(cur.getColumnIndex("isUpdated")));
                    info.setAppVersion(cur.getString(cur.getColumnIndex("AppVersion")));
                    info.setVerifiedBy(cur.getString(cur.getColumnIndex("verifiedBy")));
                    info.setVerifiedDate(cur.getString(cur.getColumnIndex("verifiedDate")));
                    info.setUserrole(cur.getString(cur.getColumnIndex("userRole")));
                    info.setIsInspectedByDSTAE(cur.getString(cur.getColumnIndex("IsInspectedByDSTAE")));
                    info.setIsInspectedByDSTEE(cur.getString(cur.getColumnIndex("IsInspectedByDSTEE")));
                    info.setIsInspectedByDSTDRDA(cur.getString(cur.getColumnIndex("IsInspectedByDSTDRDA")));
                    info.setIsInspectedByDSTDDC(cur.getString(cur.getColumnIndex("IsInspectedByDSTDDC")));
                    info.setPlantation_Site_Id(cur.getString(cur.getColumnIndex("Plantation_Site_Id")));
                    info.setPlantation_Site_Name(cur.getString(cur.getColumnIndex("Plantation_Site_Name")));
                    info.setVan_Posako_No(cur.getString(cur.getColumnIndex("Van_Posako_No")));
                    info.setPosak_bhugtaanMonth(cur.getString(cur.getColumnIndex("Posak_bhugtaanMonth")));
                    info.setPosak_bhugtaanYear(cur.getString(cur.getColumnIndex("Posak_bhugtaanYear")));
                    info.setGavyan_percentage(cur.getString(cur.getColumnIndex("gavyan_percentage")));
                    info.setAverage_height_Plant(cur.getString(cur.getColumnIndex("Average_height_Plant")));
                    info.setPlantAgainstDeadPlnt(cur.getString(cur.getColumnIndex("PlantAgainstDeadPlnt")));
                    info.setLastInspectionDetails(cur.getString(cur.getColumnIndex("LastInspectionDetails")));
                    infoList.add(info);
                }
            }
            cur.close();
            db.close();
            getReadableDatabase().close();
        } catch (Exception e) {
        }
        return infoList;
    }

    public ArrayList<PanchayatList> getPanchayt(String blockCode) {
        ArrayList<PanchayatList> panchayatList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] params = {blockCode};
            Cursor cur = db.rawQuery("SELECT PanchayatCode,PanchayatName,DistrictCode,BlockCode,PACName from Panchayat WHERE BlockCode = ? ORDER BY PanchayatName", params);
            cur.getCount();
            while (cur.moveToNext()) {
                PanchayatList panchayat = new PanchayatList();
                panchayat.setPanchayat_Code(cur.getString(cur.getColumnIndex("PanchayatCode")));
                panchayat.setPanchayat(cur.getString(cur.getColumnIndex("PanchayatName")));
                panchayat.setAreaType(cur.getString(cur.getColumnIndex("PACName")));
                panchayatList.add(panchayat);
            }
            cur.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return panchayatList;
    }

    public ArrayList<PlantationSiteList> getPlantationSiteDetail() {
        ArrayList<PlantationSiteList> infoList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT id,Site_Name,Site_NameHin from PlantationSiteDetail ORDER BY id", null);
            cur.getCount();
            while (cur.moveToNext()) {
                PlantationSiteList info = new PlantationSiteList();
                info.setId(cur.getString(cur.getColumnIndex("id")));
                info.setPlantationNameEng(cur.getString(cur.getColumnIndex("Site_Name")));
                info.setPlantationNameHindi(cur.getString(cur.getColumnIndex("Site_NameHin")));
                infoList.add(info);
            }
            cur.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoList;
    }

    public ArrayList<District> getDistrict() {
        ArrayList<District> districtList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT DistCode,DistName from Districts ORDER BY DistName", null);
            cur.getCount();
            while (cur.moveToNext()) {
                District district = new District();
                district.set_DistCode(cur.getString(cur.getColumnIndex("DistCode")));
                district.set_DistName(cur.getString(cur.getColumnIndex("DistName")));
                districtList.add(district);
            }
            cur.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districtList;
    }

    public ArrayList<Block> getBlock(String distCode) {
        ArrayList<Block> blockList = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String[] params = {distCode};
            Cursor cur = db.rawQuery("SELECT BlockCode,DistCode,BlockName from Blocks WHERE DistCode = ? ORDER BY BlockName ", params);
            cur.getCount();
            while (cur.moveToNext()) {
                Block block = new Block();
                block.setBlockCode(cur.getString(cur.getColumnIndex("BlockCode")));
                block.setBlockName(cur.getString(cur.getColumnIndex("BlockName")));
                block.setDistCode(cur.getString(cur.getColumnIndex("DistCode")));
                blockList.add(block);
            }
            cur.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blockList;
    }
}