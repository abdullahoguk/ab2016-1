package tr.org.ab.deneme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button buttonLogin;

    private String mUsername;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsername = username.getText().toString();
                mPassword = password.getText().toString();
                if (mUsername.equals("ali") &&
                    mPassword.equals("123")) {
                    openDashboard();
                }
            }
        });

    }

    private void openDashboard() {
        Intent dashboardIntent = new Intent(
                MainActivity.this,
                Dashboard.class
        );
        dashboardIntent.putExtra("username", mUsername);
        startActivity(dashboardIntent);
    }

    private void init() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.button_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
