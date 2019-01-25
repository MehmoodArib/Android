package com.example.mehmood.retrofitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mButtonPost;
    private Button mButtonComment;
    private EditText mEditText;
    private Button mButtonSearchComments;
    private Button getmButtonPostQuery;
    private Button mButtonPostRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIds();
        buttonPost();
        buttonPostQuery();
        buttonComment();
        buttonSearchComments();
        createPost();

    }

    public void setIds() {
        mTextView = findViewById(R.id.textView);
        mButtonPost = findViewById(R.id.button);
        mButtonComment = findViewById(R.id.button2);
        getmButtonPostQuery = findViewById(R.id.button1);
        mEditText = findViewById(R.id.editText);
        mButtonSearchComments = findViewById(R.id.button3);
        mButtonPostRequest=findViewById(R.id.button4);

    }

    public void buttonPost() {
        mButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
                Call<List<Post>> call = jsonPlaceHolder.getPosts();

                call.enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                        if (!response.isSuccessful()) {
                            mTextView.setText("CODE :" + response.code());
                            return;
                        }
                        List<Post> posts = response.body();
                        for (Post post : posts) {
                            String content = "";
                            content += "I.D : " + post.getId() + "\nUSER I.D: " + post.getUserId() + "\nTitle :" + post.getTitle() + "\nText: " + post.getText() + "\n\n";
                            mTextView.append(content);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        mTextView.setText(t.getMessage());
                    }
                });
            }

        });
    }
    public void buttonPostQuery() {
        getmButtonPostQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("");
                int id = Integer.parseInt(mEditText.getText().toString());
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
                Call<List<Post>> call = jsonPlaceHolder.getPosts(id,"id","desc");

                call.enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                        if (!response.isSuccessful()) {
                            mTextView.setText("CODE :" + response.code());
                            return;
                        }
                        List<Post> posts = response.body();
                        for (Post post : posts) {
                            String content = "";
                            content += "I.D : " + post.getId() + "\nUSER I.D: " + post.getUserId() + "\nTitle :" + post.getTitle() + "\nText: " + post.getText() + "\n\n";
                            mTextView.append(content);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        mTextView.setText(t.getMessage());
                    }
                });
            }

        });
    }


    public void buttonComment() {
        mButtonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
                Call<List<Comment>> call = jsonPlaceHolder.getComment();

                call.enqueue(new Callback<List<Comment>>() {
                    @Override
                    public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                        if (!response.isSuccessful()) {
                            mTextView.setText("CODE :" + response.code());
                            return;
                        }
                        List<Comment> comments = response.body();
                        for (Comment comment : comments) {
                            String content = "";
                            content += "I.D : " + comment.getId() + "\nPost I.D: " + comment.getmPostId() + "\nE-mail :" + comment.getEmail() + "\nName :" + comment.getName() + "\nText: " + comment.getText() + "\n\n";
                            mTextView.append(content);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Comment>> call, Throwable t) {
                        mTextView.setText(t.getMessage());
                    }
                });
            }

        });
    }


    public void buttonSearchComments() {
        mButtonSearchComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(mEditText.getText().toString());
                mTextView.setText("");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
                Call<List<Comment>> call = jsonPlaceHolder.getComments(id);

                call.enqueue(new Callback<List<Comment>>() {
                    @Override
                    public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                        if (!response.isSuccessful()) {
                            mTextView.setText("CODE :" + response.code());
                            return;
                        }
                        List<Comment> comments = response.body();
                        for (Comment comment : comments) {
                            String content = "";
                            content += "I.D : " + comment.getId() + "\nPost I.D: " + comment.getmPostId() + "\nE-mail :" + comment.getEmail() + "\nName :" + comment.getName() + "\nText: " + comment.getText() + "\n\n";
                            mTextView.append(content);
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Comment>> call, Throwable t) {
                        mTextView.setText(t.getMessage());
                    }
                });
            }

        });
    }
private void createPost(){
        mButtonPostRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            mTextView.setText("");
        final Post post = new Post(23,"Xyz","abc");
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
    Call<Post> call = jsonPlaceHolder.createPost(post);

    call.enqueue(new Callback<Post>() {
        @Override
        public void onResponse(Call<Post> call, Response<Post> response) {
            if (!response.isSuccessful()) {
                mTextView.setText("CODE :" + response.code());
                return;
            }
            Post postresponse = response.body();
            String content = "";
            content +="Code: "+ response.code() +"\n";
            content += "I.D : " + postresponse.getId() + "\nUSER I.D: " + postresponse.getUserId() + "\nTitle :" + postresponse.getTitle() + "\nText: " + postresponse.getText() + "\n\n";
            mTextView.append(content);


        }

        @Override
        public void onFailure(Call<Post> call, Throwable t) {
            mTextView.setText(t.getMessage());
        }
    });
            }
        });
}
}