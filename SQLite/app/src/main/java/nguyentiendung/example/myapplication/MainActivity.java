package nguyentiendung.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create database todolist
        database = new Database(this, "todolist.sqlite", null, 1);
        //Create table todo
        database.QueryData("CREATE TABLE IF NOT EXISTS TodoTest(Id INTEGER PRIMARY KEY AUTOINCREMENT, Title VARCHAR(200), Content VARCHAR(200), Finished BOOLEAN)");

        //insert data
        //database.QueryData("INSERT INTO Todo VALUES(null, 'build a todo list app', '19/05/2021')");

        //select data
        Cursor dataTodoList = database.GetData("SELECT * FROM TodoTest");
        while (dataTodoList.moveToNext()) {
            String Title = dataTodoList.getString(1);
            String Content = dataTodoList.getString(2);
            Toast.makeText(MainActivity.this, Title + "\n" + Content, Toast.LENGTH_SHORT).show();
        }
    }
}