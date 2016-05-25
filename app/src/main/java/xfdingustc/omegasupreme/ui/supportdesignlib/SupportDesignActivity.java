package xfdingustc.omegasupreme.ui.supportdesignlib;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import butterknife.BindView;
import xfdingustc.omegasupreme.BaseActivity;
import xfdingustc.omegasupreme.R;

/**
 * Created by Xiaofei on 2016/5/25.
 */
public class SupportDesignActivity extends BaseActivity{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_support_design);
        setSupportActionBar(getToolbar());

        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setupDrawerContent(navigationView);

    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        getToolbar().setTitle("Android Support Design Library");
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
    }
}
