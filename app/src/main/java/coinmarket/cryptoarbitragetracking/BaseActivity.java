package coinmarket.cryptoarbitragetracking;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

import coinmarket.cryptoarbitragetracking.Utils.Utils;


public class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        toast = Toast.makeText(getActivity(), "", Toast.LENGTH_LONG);
    }

    Drawer result;

    public void initDrawer(boolean b) {
        if (b) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            result = new DrawerBuilder()
                    .withActivity(this).withCloseOnClick(true).withSelectedItemByPosition(-1)
                    .withHeader(R.layout.nav_header_dash_board)
                    .withHeaderDivider(true)
                    .withDrawerWidthDp(250)
                    .addDrawerItems(
                            new PrimaryDrawerItem().withName("Home").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("Item").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("About").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("Fragrances").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("Profile").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("Service").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("Demo").withSelectable(true).withTypeface(Utils.getPtSansRegular(getActivity())),
                            new PrimaryDrawerItem().withName("Log Out").withSelectable(false).withTypeface(Utils.getPtSansRegular(getActivity()))
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                            if (position == 1) {
                                if (getActivity() instanceof DashBoardActivity) {
                                    hideMenu(true);
                                    Intent intent = new Intent(getActivity(),
                                            DashBoardActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                            | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(intent);
                                    hideMenu(false);
                                    finishActivity();
                                }

                            } else if (position == 2) {
                            } else if (position == 3) {
                            }
                            return true;
                        }
                    })
                    .build();

            ImageView imgMenu = (ImageView) findViewById(R.id.imgMenu);
            if (imgMenu != null) {
                imgMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (result.isDrawerOpen()) {
                            result.closeDrawer();
                        } else {
                            result.openDrawer();
                        }
                    }
                });
            }
        } else {
            ImageView imgMenu = (ImageView) findViewById(R.id.imgMenu);
            imgMenu.setVisibility(View.GONE);
        }
//        initMenuItems();
//        fillProfileData();
    }

    public void initBack(boolean b) {
        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        if (b) {
            initDrawer(false);
            imgBack.setVisibility(View.VISIBLE);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else {
            initDrawer(true);
            imgBack.setVisibility(View.GONE);
        }
    }

    private void hideMenu(boolean b) {
        try {
            if (b) {
                result.closeDrawer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    private BaseActivity getActivity() {
        return BaseActivity.this;
    }

    private void finishActivity() {
        if ((getActivity() instanceof DashBoardActivity)) {

        } else {
            getActivity().finish();
        }

    }

    private TextView tvTitleText;

    public void setTitleText(String text) {
        try {

            if (tvTitleText == null)
                tvTitleText = (TextView) findViewById(R.id.tvTitleText);
            tvTitleText.setText(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean handled = super.onKeyDown(keyCode, event);

        // Eat the long press event so the keyboard doesn't come up.
        if (keyCode == KeyEvent.KEYCODE_MENU && event.isLongPress()) {
            return true;
        }

        return handled;
    }

    Toast toast;

    public void showToast(final String text, final int duration) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                toast.setText(text);
                toast.setDuration(duration);
                toast.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.onDestroy();
    }


    BaseCallback baseCallback;

    public void setBaseCallback(BaseCallback baseCallback) {
        this.baseCallback = baseCallback;
    }

    interface BaseCallback {
        void onMasterDataLoad();
    }


}

