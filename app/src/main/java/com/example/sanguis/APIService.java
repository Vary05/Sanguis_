package com.example.sanguis;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService
{
    @FormUrlEncoded
    @POST("Register.php")
    Call<Result> createUser(@Field("unique_id") String name,
                            @Field("email") String email,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("Login.php")
    Call<Result> userLogin(@Field("unique_id") String unique_id,
                           @Field("password") String password);

}