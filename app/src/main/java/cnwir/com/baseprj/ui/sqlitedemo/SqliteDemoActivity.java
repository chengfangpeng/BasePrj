package cnwir.com.baseprj.ui.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cnwir.com.baseprj.R;
import cnwir.com.baseprj.domain.Person;
import cnwir.com.baseprj.ui.BaseActivity;

public class SqliteDemoActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = SqliteDemoActivity.class.getSimpleName();


    private Button add;

    private Button update;

    private Button delete;


    private Button query;

    private TextView showAll;

    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);

//        SQLiteDatabase db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);
//        db.execSQL("DROP TABLE IF EXISTS person");
//        db.execSQL("CREATE TABLE person(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age SMALLINT);");
//
//        Person p1 = new Person();
//        p1.setName("cheng");
//        p1.setAge(24);
//        db.execSQL("INSERT INTO person VALUES(NULL, ?,?);", new Object[]{p1.getName(), p1.getAge()});
//
//
//        p1.setName("fang");
//        p1.setAge(25);
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", p1.getName());
//        contentValues.put("age", p1.getAge());
//        db.insert("person", null, contentValues);
//
//        contentValues.put("age", p1.getAge());
//        db.update("person", contentValues, "name = ?", new String[]{"cheng"});
//
//        Cursor cursor = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"25"});
//        while (cursor.moveToNext()) {
//
//            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
//            String name = cursor.getString(cursor.getColumnIndex("name"));
//            int age = cursor.getInt(cursor.getColumnIndex("age"));
//            Log.d(TAG, "_id = " + _id + "  name = " + name + "   age =  " + age);
//
//        }
//
//        //删除数据
//        db.delete("person", "age < ?", new String[]{"35"});
//        db.close();
//        //删除数据库
////        deleteDatabase("test.db");
        dbManager = new DBManager(this);
        initView();
    }

    private void initView() {

        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        query = (Button) findViewById(R.id.query_all);
        showAll = (TextView) findViewById(R.id.showalldata);
        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        query.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.add:

                List<Person> persons = new ArrayList<Person>();

                for (int i = 0; i < 20; i++) {
                    Person person = new Person();
                    person.setAge(i);
                    person.setName("name-" + i);
                    person.setInfo("hello-" + i);


                    persons.add(person);
                }
                dbManager.add(persons);

                break;

            case R.id.update:


                break;

            case R.id.delete:

                Person person = new Person();
                person.setName("name-" + 10);
                dbManager.deleteOldPerson(person);

                break;

            case R.id.query_all:
                List<Person> queryPersons = new ArrayList<Person>();
                queryPersons = dbManager.queryAll();

                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < queryPersons.size(); i++) {
                    sb.append(queryPersons.get(i).toString());
                }
                showAll.setText(sb);
                break;

            default:
                break;


        }

    }
}
