package com.example.shopee.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shopee.Fragment.DonHangFragment;
import com.example.shopee.Fragment.TaiKhoanFragment;
import com.example.shopee.Fragment.TrangchuFragment;
import com.example.shopee.Fragment.YeuThichFragment;
import com.example.shopee.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TrangChuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.botnav);
        navigation.setOnItemSelectedListener(selectedListener);
        loadFragment(new TrangchuFragment());
        if (isConnected(this)){

            Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "khong co internet", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isConnected(Context context){
        boolean result = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null) {
                NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        result = true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        result = true;
                    }
                }
            }
        } else {
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null) {
                    // connected to the internet
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        result = true;
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private NavigationBarView.OnItemSelectedListener selectedListener
           = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.Home:
                    fragment = new TrangchuFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.DonHang:
                    fragment = new DonHangFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.YT:
                    fragment = new YeuThichFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.TK:
                    fragment = new TaiKhoanFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}