package xfdingustc.omegasupreme;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    private void init() {
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        getToolbar().setTitle(R.string.app_name);
    }
}
