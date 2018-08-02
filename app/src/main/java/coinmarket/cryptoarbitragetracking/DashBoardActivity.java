package coinmarket.cryptoarbitragetracking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import coinmarket.cryptoarbitragetracking.fragments.AllCoinsFragment;
import coinmarket.cryptoarbitragetracking.fragments.FavoriteFragment;

public class DashBoardActivity extends BaseActivity {

    ScreenSlidePagerAdapter pagerAdapter;


    Fragment fragment = null;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.fabBtn)
    FloatingActionButton fabBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);

        initDrawer(true);
        init();
    }

    public void init() {

        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        private String tabTitles[] = new String[]{"ALL COINS", "FAVORITE"};

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new Fragment();
            switch (position) {
                case 0:
                    f = new AllCoinsFragment();
//                    new AllCoinsFragment().getFragmetnInstance("");

                    break;
                case 1:
                    f = new FavoriteFragment();
                    break;
            }

            return f;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
