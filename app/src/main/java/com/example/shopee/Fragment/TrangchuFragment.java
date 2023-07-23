package com.example.shopee.Fragment;

import android.content.Context;

import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.shopee.Adapter.AdapterMonTC;
import com.example.shopee.Adapter.AdapterQuan;
import com.example.shopee.Model.Mon;
import com.example.shopee.Model.Quan;
import com.example.shopee.Model.QuanModel;
import com.example.shopee.R;
import com.example.shopee.Retrofit.ApiShopeeFood;
import com.example.shopee.Retrofit.RetrofitClient;
import com.example.shopee.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrangchuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrangchuFragment extends Fragment {
    RecyclerView dsQuan,dsMon;
    ViewFlipper viewFlipper;
    ListView listView;
    AdapterQuan adapterQuan;
    CompositeDisposable cd = new CompositeDisposable();
    List<Quan>listquan;
    List<Mon>listmon;
    AdapterMonTC adapterMonTC;
    ApiShopeeFood apiShopeeFood;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrangchuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrangchuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrangchuFragment newInstance(String param1, String param2) {
        TrangchuFragment fragment = new TrangchuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        apiShopeeFood = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiShopeeFood.class);
        viewFlipper = view.findViewById(R.id.quangcao);
        dsQuan = view.findViewById(R.id.dsTopquan);
        dsMon = view.findViewById(R.id.dsbanchay);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        dsMon.setLayoutManager(layoutManager1);
        dsMon.setHasFixedSize(true);
        dsQuan.setLayoutManager(layoutManager);
        dsQuan.setHasFixedSize(true);
        Quangcao();
        getdsQuanTop();
        getdsMon();
        return view;
    }
    private void Quangcao(){
        List<String>quangcao = new ArrayList<>();
        quangcao.add("https://i.ytimg.com/vi/cY0rHIw52kU/maxresdefault.jpg");
        quangcao.add("https://bmdsolutions.vn/wp-content/uploads/2022/10/shopeefood-khuyen-mai-88K-21-1-2022.png");
        quangcao.add("https://cdn.tuoitrethudo.com.vn/stores/news_dataimages/quanngocly/062022/24/15/78665e778df9fb6fae195651ab1604b7.jpg?rt=20220624155154");
        for (int i = 0; i<quangcao.size();i++){
            ImageView imageView = new ImageView(getActivity());
            Glide.with(getActivity()).load(quangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
    }

    private void getdsQuanTop(){
        cd.add(apiShopeeFood.getQuan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        quanModel -> {
                            if (quanModel.isSuccess()){
                                listquan = quanModel.getResult();
                                adapterQuan = new AdapterQuan(getActivity(),listquan);
                                dsQuan.setAdapter(adapterQuan);
                            }
                        }
                ));
    }
    private void getdsMon(){
        cd.add(apiShopeeFood.getMon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        monModel -> {
                            if (monModel.isSuccess()){
                                listmon = monModel.getResult();
                                adapterMonTC = new AdapterMonTC(getActivity(),listmon);
                                dsMon.setAdapter(adapterMonTC);
                            }
                        }
                ));
    }

    @Override
    public void onDestroy() {
        cd.clear();
        super.onDestroy();
    }
}