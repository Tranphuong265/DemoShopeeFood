package com.example.shopee.Retrofit;


import com.example.shopee.Model.MonModel;
import com.example.shopee.Model.QuanModel;
import com.example.shopee.Model.TaiKhoanModel;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiShopeeFood {
    @GET("gettaikhoan.php")
    Observable<TaiKhoanModel> getTaiKhoan();
    @GET("getquan.php")
    Observable<QuanModel> getQuan();
    @GET("getmon.php")
    Observable<MonModel> getMon();
    @GET("getmontheoquan.php")
    Observable<MonModel> getMontheoQuan();
}
