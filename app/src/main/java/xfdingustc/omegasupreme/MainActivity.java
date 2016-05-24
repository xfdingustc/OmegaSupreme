package xfdingustc.omegasupreme;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

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
        setupViewPager();
    }


    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        getToolbar().setTitle(R.string.app_name);
    }

    private void setupViewPager() {
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        List<FunctionCategory> mCategoryList = FunctionCategory.getCategories();
        for (FunctionCategory category : mCategoryList) {
            FunctionFragment fragment = FunctionFragment.newInstance(category);
            adapter.addFragment(fragment, category.categoryName);
        }

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
