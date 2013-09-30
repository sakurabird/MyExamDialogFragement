
package sakura.example.myexamdialogfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment01 frag = new Fragment01();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main, frag, "Fragment01");
        ft.commit();
    }
}
