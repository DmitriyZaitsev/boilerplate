package boilerplate.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import boilerplate.R;
import boilerplate.presentation.view.flow.MyKeyChanger;
import flow.Flow;
import flow.KeyDispatcher;

public class MainActivity extends AppCompatActivity {

  @Override protected void attachBaseContext(final Context newBase) {
    super.attachBaseContext(Flow.configure(newBase, this)
        .dispatcher(KeyDispatcher.configure(this, new MyKeyChanger(this))
            .build())
        .install());
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
