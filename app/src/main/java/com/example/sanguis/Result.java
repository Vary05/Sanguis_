package com.example.sanguis;

import com.google.gson.annotations.SerializedName;

public class Result
{
    @SerializedName("error")
    private Boolean error;

    @SerializedName("user")
    private User user;

    public Result(Boolean error, User user) {
        this.error = error;
        this.user = user;
    }

    public Boolean getError() {
        return error;
    }

    public User getUser() {
        return user;
    }
}
