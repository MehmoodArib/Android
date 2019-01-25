package com.example.mehmood.retrofitapp;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("postId")
    private int mPostId;
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("body")
    private String mText;

    public int getmPostId() {
        return mPostId;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getText() {
        return mText;
    }

}
