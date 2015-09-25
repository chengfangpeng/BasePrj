package cnwir.com.baseprj.ui.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cnwir.com.baseprj.domain.Person;

/**
 * Created by cfp on 15-9-25.
 */
public class DBManager {

    private DBHelper dbHelper;

    private SQLiteDatabase db;

    public DBManager(Context context) {

        dbHelper = new DBHelper(context);
        //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = dbHelper.getWritableDatabase();

    }

    /**
     * 添加persons
     *
     * @param persons
     */
    public void add(List<Person> persons) {


        try {

            db.beginTransaction();

            for (Person person : persons) {

                db.execSQL("INSERT INTO person VALUES(NULL, ?,?,?)", new Object[]{person.getName(), person.getAge(), person.getInfo()});
            }
            //设置事物成功完成
            db.setTransactionSuccessful();
        } finally {

            //结束事物
            db.endTransaction();
        }


    }

    /**
     * update person's age
     *
     * @param person
     */
    public void updatePersonAge(Person person) {

        ContentValues cv = new ContentValues();
        cv.put("age", person.getAge());
        db.update("person", cv, "name = ?", new String[]{person.getName()});


    }

    /**
     * delete old person
     *
     * @param person
     */
    public void deleteOldPerson(Person person) {
        db.delete("person", "name = ?", new String[]{person.getName()});
    }

    /**
     *查询所有数据
     * @return
     */
    public List<Person> queryAll(){
        List<Person> persons = new ArrayList<Person>();
        Cursor cursor = db.rawQuery("SELECT * FROM person", null);
        while (cursor.moveToNext()){
            Person person = new Person();
            person.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
            person.setName(cursor.getString(cursor.getColumnIndex("name")));
            person.setAge(cursor.getInt(cursor.getColumnIndex("age")));
            person.setInfo(cursor.getString(cursor.getColumnIndex("info")));
        persons.add(person);
        }
        return persons;

    }

    public void closeDB(){

        if(db != null){

            db.close();
        }
    }
}
