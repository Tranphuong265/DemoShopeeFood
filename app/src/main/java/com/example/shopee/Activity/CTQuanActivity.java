package com.example.shopee.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopee.Adapter.AdapterMon;
import com.example.shopee.Adapter.AdapterMonTC;
import com.example.shopee.Model.Mon;
import com.example.shopee.Model.Quan;
import com.example.shopee.R;
import com.example.shopee.Retrofit.ApiShopeeFood;
import com.example.shopee.Retrofit.RetrofitClient;
import com.example.shopee.Utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CTQuanActivity extends AppCompatActivity {
    TextView tvQuanName;
    int idQuan;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ImageView imgQuan;
    AdapterMon adapterMon;
    List<Mon> listmon;
    RecyclerView dsmonpb;
    ApiShopeeFood apiShopeeFood;
    CompositeDisposable cd = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctquan);



        tvQuanName = findViewById(R.id.nameQuan);
        imgQuan = findViewById(R.id.imgQuan);
        tabLayout = findViewById(R.id.Tab_ctquan);
        viewPager = findViewById(R.id.vp_ctquan);
        dsmonpb = findViewById(R.id.dspb);

        apiShopeeFood = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiShopeeFood.class);
        Quan quan = (Quan) getIntent().getSerializableExtra("ct");
        idQuan = getIntent().getIntExtra("idq",1);
        tvQuanName.setText(quan.getTENQ());
        Glide.with(getApplicationContext()).load(quan.getIMGQ()).into(imgQuan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        dsmonpb.setLayoutManager(layoutManager);
        dsmonpb.setHasFixedSize(true);
        getdsMonpb();
    }
    private void getdsMonpb(){
        cd.add(apiShopeeFood.getMon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        monModel -> {
                            if (monModel.isSuccess()){
                                listmon = monModel.getResult();
                                adapterMon = new AdapterMon(getApplicationContext(),listmon);
                                dsmonpb.setAdapter(adapterMon);
                            }
                        }
                ));
    }
}