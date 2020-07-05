package com.example.instantgroup;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asksira.bsimagepicker.BSImagePicker;
import com.asksira.bsimagepicker.Utils;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.iceteck.silicompressorr.FileUtils;
import com.iceteck.silicompressorr.SiliCompressor;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class Uploadinstant extends AppCompatActivity implements View.OnClickListener , BSImagePicker.OnSingleImageSelectedListener,  BSImagePicker.ImageLoaderDelegate,BSImagePicker.OnSelectImageCancelledListener{
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    Uri urimain1;
    Uri urimain2;
    Uri urimain3;
    Uri urimain4;
    Uri urimain5;
    Uri urimain6;
    Uri urimain7;
    Uri urimain8;
    Uri urimain9;
    Uri urimain10;
    Uri comurimain1=null;
    Uri comurimain2=null;
    Uri comurimain3=null;
    Uri comurimain4=null;
    Uri comurimain5=null;
    Uri comurimain6=null;
    Uri comurimain7=null;
    Uri comurimain8=null;
    Uri comurimain9=null;
    Uri comurimain10=null;
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    File file6;
    File file7;
    File file8;
    File file9;
    File file10;
    FloatingActionButton mButtonUpload;
    EditText mEditTextFileName;
    ProgressBar mProgressBar;
    StorageReference mStorageRef;
    DatabaseReference mDatabaseRef;
    StorageTask mUploadTask;
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;
    CardView cardView5;
    CardView cardView6;
    CardView cardView7;
    CardView cardView8;
    CardView cardView9;
    CardView cardView10;
    String cardimaheuri1=null;
    String cardimaheuri2=null;
    String  cardimaheuri3=null;
    String cardimaheuri4=null;
    String cardimaheuri5=null;
    String cardimaheuri6=null;
    String cardimaheuri7=null;
    String cardimaheuri8=null;
    String cardimaheuri9=null;
    String cardimaheuri10=null;
    String cardusername1=null;
    String cardusername2=null;
    String cardusername3=null;
    String cardusername4=null;
    String cardusername5=null;
    String cardusername6=null;
    String cardusername7=null;
    String cardusername8=null;
    String cardusername9=null;
    String cardusername10=null;
    CircleImageView circleImageView1;
    CircleImageView circleImageView2;
    CircleImageView circleImageView3;
    CircleImageView circleImageView4;
    CircleImageView circleImageView5;
    CircleImageView circleImageView6;
    CircleImageView circleImageView7;
    CircleImageView circleImageView8;
    CircleImageView circleImageView9;
    CircleImageView circleImageView10;
    TextView usertextname1;
    TextView usertextname2;
    TextView usertextname3;
    TextView usertextname4;
    TextView usertextname5;
    TextView usertextname6;
    TextView usertextname7;
    TextView usertextname8;
    TextView usertextname9;
    TextView usertextname10;
    RecyclerView lRecyclerView;
    FirebaseDatabase lFirebaseDatabase;
    DatabaseReference lRef;


    private DatabaseReference hDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadinstant);

        FirebaseAuth.getInstance();
        mButtonUpload = findViewById(R.id.floatingActionButton2);
        mProgressBar = findViewById(R.id.progressBar);
        mEditTextFileName = findViewById(R.id.edit);
        mEditTextFileName.setVisibility(View.INVISIBLE);
        imageView1 = findViewById(R.id.main1);
        imageView2 = findViewById(R.id.main2);
        imageView3 = findViewById(R.id.main3);
        imageView4 = findViewById(R.id.main4);
        imageView5 = findViewById(R.id.main5);
        imageView6 = findViewById(R.id.main6);
        imageView7 = findViewById(R.id.main7);
        imageView8 = findViewById(R.id.main8);
        imageView9 = findViewById(R.id.main9);
        imageView10 = findViewById(R.id.main10);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);
        imageView10.setOnClickListener(this);
        mProgressBar.setVisibility(View.INVISIBLE);
        cardView1=findViewById(R.id.card1);
        cardView2=findViewById(R.id.card2);
        cardView3=findViewById(R.id.card3);
        cardView4=findViewById(R.id.card4);
        cardView5=findViewById(R.id.card5);
        cardView6=findViewById(R.id.card6);
        cardView7=findViewById(R.id.card7);
        cardView8=findViewById(R.id.card8);
        cardView9=findViewById(R.id.card9);
        cardView10=findViewById(R.id.card10);
        cardView1.setVisibility(View.INVISIBLE);
        cardView2.setVisibility(View.INVISIBLE);
        cardView3.setVisibility(View.INVISIBLE);
        cardView4.setVisibility(View.INVISIBLE);
        cardView5.setVisibility(View.INVISIBLE);
        cardView6.setVisibility(View.INVISIBLE);
        cardView7.setVisibility(View.INVISIBLE);
        cardView8.setVisibility(View.INVISIBLE);
        cardView9.setVisibility(View.INVISIBLE);
        cardView10.setVisibility(View.INVISIBLE);
       circleImageView1=findViewById(R.id.image_view_upload);
       circleImageView2=findViewById(R.id.image_view_upload2);
       circleImageView3=findViewById(R.id.image_view_upload3);
       circleImageView4=findViewById(R.id.image_view_upload4);
       circleImageView5=findViewById(R.id.image_view_upload5);
       circleImageView6=findViewById(R.id.image_view_upload6);
       circleImageView7=findViewById(R.id.image_view_upload7);
       circleImageView8=findViewById(R.id.image_view_upload8);
       circleImageView9=findViewById(R.id.image_view_upload9);
       circleImageView10=findViewById(R.id.image_view_upload10);
       usertextname1=findViewById(R.id.text_view_name);
       usertextname2=findViewById(R.id.text_view_name2);
       usertextname3=findViewById(R.id.text_view_name3);
       usertextname4=findViewById(R.id.text_view_name4);
       usertextname5=findViewById(R.id.text_view_name5);
       usertextname6=findViewById(R.id.text_view_name6);
       usertextname7=findViewById(R.id.text_view_name7);
       usertextname8=findViewById(R.id.text_view_name8);
       usertextname9=findViewById(R.id.text_view_name9);
       usertextname10=findViewById(R.id.text_view_name10);





       mStorageRef = FirebaseStorage.getInstance().getReference("instant");
       mDatabaseRef = FirebaseDatabase.getInstance().getReference("instant");
       mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress()) {
                    Toast.makeText(Uploadinstant.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                } else {
                    uploadFile();
                }
            }
        });


        SearchView searchView=findViewById(R.id.search_field);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText);
                return false;
            }
        });
        lRecyclerView = findViewById(R.id.usersrec);
        lRecyclerView.setHasFixedSize(true);
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        lFirebaseDatabase = FirebaseDatabase.getInstance();
        lRef = lFirebaseDatabase.getReference("users");
        hDatabase = FirebaseDatabase.getInstance().getReference().child("usertags");

    }




    private void firebaseSearch(String searchText) {
        String query = searchText.toLowerCase();
        Query firebaseSearchQuery = lRef.orderByChild("name").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.instacard,
                        ViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getName(), model.getImageUrl());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mTitleTv = view.findViewById(R.id.text_view_name);
                                ImageView mImageView = view.findViewById(R.id.image_view_upload);
                                String name = getItem(position).getName();
                                String imageuri=getItem(position).getImageUrl();
                                if (cardimaheuri1==null)
                                {
                                    cardView1.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView1);
                                    cardimaheuri1=imageuri;
                                    cardusername1=name;
                                    usertextname1.setText(name);
                                } else if(cardimaheuri1!=null&&cardimaheuri2==null)
                                {
                                    cardView2.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView2);
                                    cardimaheuri2=imageuri;
                                    cardusername2=name;
                                    usertextname2.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3==null)
                                {
                                    cardView3.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView3);
                                    cardimaheuri3=imageuri;
                                    cardusername3=name;
                                    usertextname3.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4==null)
                                {
                                    cardView4.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView4);
                                    cardimaheuri4=imageuri;
                                    cardusername4=name;
                                    usertextname4.setText(name);
                                }

                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5==null)
                                {
                                    cardView5.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView5);
                                    cardimaheuri5=imageuri;
                                    cardusername5=name;
                                    usertextname5.setText(name);
                                }



                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6==null)
                                {
                                    cardView6.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView6);
                                    cardimaheuri6=imageuri;
                                    cardusername6=name;
                                    usertextname6.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6!=null&&cardimaheuri7==null)
                                {
                                    cardView7.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView7);
                                    cardimaheuri7=imageuri;
                                    cardusername7=name;
                                    usertextname7.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6!=null&&cardimaheuri7!=null&&cardimaheuri8==null)
                                {
                                    cardView8.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView8);
                                    cardimaheuri8=imageuri;
                                    cardusername8=name;
                                    usertextname8.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6!=null&&cardimaheuri7!=null&&cardimaheuri8!=null&&cardimaheuri9==null)
                                {
                                    cardView9.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView9);
                                    cardimaheuri9=imageuri;
                                    cardusername9=name;
                                    usertextname9.setText(name);
                                }
                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6!=null&&cardimaheuri7!=null&&cardimaheuri8!=null&&cardimaheuri9!=null&&cardimaheuri10==null)
                                {
                                    cardView10.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView10);
                                    cardimaheuri10=imageuri;
                                    cardusername10=name;
                                    usertextname10.setText(name);
                                }
                                else{
                                    Toast.makeText(Uploadinstant.this, "Max Users Taged", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onItemLongClick(View view, int position) {
                                //TODO do your own implementaion on long item click
                            }
                        });
                        return viewHolder;
                    }
                };
        lRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.instacard,
                        ViewHolder.class,
                        lRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getName(),  model.getImageUrl());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView mTitleTv = view.findViewById(R.id.text_view_name);
                                ImageView mImageView = view.findViewById(R.id.image_view_upload);
                                String name = getItem(position).getName();
                                String imageuri=getItem(position).getImageUrl();
                                if (cardimaheuri1==null)
                                {
                                    cardView1.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView1);
                                    cardimaheuri1=imageuri;
                                    cardusername1=name;
                                    usertextname1.setText(name);
                                } else if(cardimaheuri1!=null&&cardimaheuri2==null)
                                {
                                    cardView2.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView2);
                                    cardimaheuri2=imageuri;
                                    cardusername2=name;
                                    usertextname2.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&
                                        cardimaheuri3==null)
                                {
                                    cardView3.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView3);
                                    cardimaheuri3=imageuri;
                                    cardusername3=name;
                                    usertextname3.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null
                                        &&cardimaheuri3!=null&&cardimaheuri4==null)
                                {
                                    cardView4.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView4);
                                    cardimaheuri4=imageuri;
                                    cardusername4=name;
                                    usertextname4.setText(name);
                                }

                                else if(cardimaheuri1!=null&&cardimaheuri2!=null
                                        &&cardimaheuri3!=null&&cardimaheuri4!=null&&
                                        cardimaheuri5==null)
                                {
                                    cardView5.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView5);
                                    cardimaheuri5=imageuri;
                                    cardusername5=name;
                                    usertextname5.setText(name);
                                }



                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&
                                        cardimaheuri3!=null&&cardimaheuri4!=null&&
                                        cardimaheuri5!=null&&cardimaheuri6==null)
                                {
                                    cardView6.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView6);
                                    cardimaheuri6=imageuri;
                                    cardusername6=name;
                                    usertextname6.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&
                                        cardimaheuri3!=null&&cardimaheuri4!=null&&
                                        cardimaheuri5!=null&&cardimaheuri6!=null&&
                                        cardimaheuri7==null)
                                {
                                    cardView7.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView7);
                                    cardimaheuri7=imageuri;
                                    cardusername7=name;
                                    usertextname7.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&
                                        cardimaheuri3!=null&&cardimaheuri4!=null&&
                                        cardimaheuri5!=null&&cardimaheuri6!=null&&
                                        cardimaheuri7!=null&&cardimaheuri8==null)
                                {
                                    cardView8.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView8);
                                    cardimaheuri8=imageuri;
                                    cardusername8=name;
                                    usertextname8.setText(name);
                                }


                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6!=null&&cardimaheuri7!=null&&cardimaheuri8!=null&&cardimaheuri9==null)
                                {
                                    cardView9.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView9);
                                    cardimaheuri9=imageuri;
                                    cardusername9=name;
                                    usertextname9.setText(name);
                                }
                                else if(cardimaheuri1!=null&&cardimaheuri2!=null&&cardimaheuri3!=null&&cardimaheuri4!=null&&cardimaheuri5!=null&&cardimaheuri6!=null&&cardimaheuri7!=null&&cardimaheuri8!=null&&cardimaheuri9!=null&&cardimaheuri10==null)
                                {
                                    cardView10.setVisibility(View.VISIBLE);
                                    Picasso.get().load(imageuri).into(circleImageView10);
                                    cardimaheuri10=imageuri;
                                    cardusername10=name;
                                    usertextname10.setText(name);
                                }
                                else{
                                    Toast.makeText(Uploadinstant.this, "Max Users Taged", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onItemLongClick(View view, int position) {
                                //TODO do your own implementaion on long item click
                            }
                        });
                        return viewHolder;
                    }
                };
        lRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private void openFileChooser() {
        BSImagePicker singleSelectionPicker = new BSImagePicker.Builder("com.example.filepicker.fileprovider")
                .setMaximumDisplayingImages(23)
                .setSpanCount(3)
                .setGridSpacing(Utils.dp2px(2))
                .setPeekHeight(Utils.dp2px(360))
                .hideCameraTile()
                .build();
        singleSelectionPicker.show(getSupportFragmentManager(), "hey");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main1:
            case R.id.main2:
            case R.id.main3:
            case R.id.main4:
            case R.id.main5:
            case R.id.main6:
            case R.id.main7:
            case R.id.main8:
            case R.id.main9:
            case R.id.main10:
                openFileChooser();
                break;
        }
    }


    @Override
    public void loadImage(Uri imageUri, ImageView ivImage) {
        Picasso.get().load(imageUri).into(ivImage);
    }

    @Override
    public void onCancelled(boolean isMultiSelecting, String tag) {
        Toast.makeText(this, "No Image Selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSingleImageSelected(Uri urix, String tag) {

        Uri uri= urix ;
        if(urimain1==null&&urimain2==null&&urimain3==null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView1.setImageURI(uri);
            urimain1=uri;
            comurimain1=urimain1;

        }
        else if (urimain1!=null&&urimain2==null&&urimain3==null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView2.setImageURI(uri);
            urimain2=uri;
            comurimain2=urimain2;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3==null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView3.setImageURI(uri);
            urimain3=uri;
            comurimain3=urimain3;


        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView4.setImageURI(uri);
            urimain4=uri;
            comurimain4=urimain4;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView5.setImageURI(uri);
            urimain5=uri;
            comurimain5=urimain5;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView6.setImageURI(uri);
            urimain6=uri;
            comurimain6=urimain6;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView7.setImageURI(uri);
            urimain7=uri;
            comurimain7=urimain7;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7!=null&&urimain8==null&&urimain9==null&&urimain10==null)
        {
            imageView8.setImageURI(uri);
            urimain8=uri;
            comurimain8=urimain8;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7!=null&&urimain8!=null&&urimain9==null&&urimain10==null)
        {
            imageView9.setImageURI(uri);
            urimain9=uri;
            comurimain9=urimain9;

        }
        else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7!=null&&urimain8!=null&&urimain9!=null&&urimain10==null)
        {
            imageView10.setImageURI(uri);
            urimain10=uri;
            comurimain10=urimain10;

        }
        else {
            Toast toast = Toast.makeText(Uploadinstant.this, "Max limit Reached", Toast.LENGTH_LONG); toast.show();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult( data );
            if (resultCode == RESULT_OK) {
                Uri uri= result.getUri();
                if(urimain1==null&&urimain2==null&&urimain3==null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView1.setImageURI(uri);
                    urimain1=uri;
                    comurimain1=urimain1;

                }
                else if (urimain1!=null&&urimain2==null&&urimain3==null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView2.setImageURI(uri);
                    urimain2=uri;
                    comurimain2=urimain2;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3==null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView3.setImageURI(uri);
                    urimain3=uri;
                    comurimain3=urimain3;


                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4==null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView4.setImageURI(uri);
                    urimain4=uri;
                    comurimain4=urimain4;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5==null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView5.setImageURI(uri);
                    urimain5=uri;
                    comurimain5=urimain5;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6==null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView6.setImageURI(uri);
                    urimain6=uri;
                    comurimain6=urimain6;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7==null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView7.setImageURI(uri);
                    urimain7=uri;
                    comurimain7=urimain7;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7!=null&&urimain8==null&&urimain9==null&&urimain10==null)
                {
                    imageView8.setImageURI(uri);
                    urimain8=uri;
                    comurimain8=urimain8;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7!=null&&urimain8!=null&&urimain9==null&&urimain10==null)
                {
                    imageView9.setImageURI(uri);
                    urimain9=uri;
                    comurimain9=urimain9;

                }
                else if (urimain1!=null&&urimain2!=null&&urimain3!=null&&urimain4!=null&&urimain5!=null&&urimain6!=null&&urimain7!=null&&urimain8!=null&&urimain9!=null&&urimain10==null)
                {
                    imageView10.setImageURI(uri);
                    urimain10=uri;
                    comurimain10=urimain10;
                  
                }
                else {
                    Toast toast = Toast.makeText(Uploadinstant.this, "Max limit Reached", Toast.LENGTH_LONG); toast.show();
                }
            }
            else
            { Toast toast = Toast.makeText(Uploadinstant.this, "No Image selected", Toast.LENGTH_LONG); toast.show(); }
            if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(Uploadinstant.this, "Error : " + error, Toast.LENGTH_LONG).show();
            }
        }
    }

    private void uploadFile() {
        mDatabaseRef.removeValue();
        if(cardimaheuri1!=null) {
           uploadtags();
           if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null && urimain5 != null && urimain6 != null && urimain7 != null && urimain8 != null && urimain9 != null && urimain10 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null && comurimain5 != null && comurimain6 != null && comurimain7 != null && comurimain8 != null && comurimain9 != null && comurimain10 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain5));
                   mUploadTask = fileReference.putFile(comurimain5)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain6));
                   mUploadTask = fileReference.putFile(comurimain6)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain7));
                   mUploadTask = fileReference.putFile(comurimain7)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain8));
                   mUploadTask = fileReference.putFile(comurimain8)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain9));
                   mUploadTask = fileReference.putFile(comurimain9)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain10));
                   mUploadTask = fileReference.putFile(comurimain10)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

               }

           } else if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null && urimain5 != null && urimain6 != null && urimain7 != null && urimain8 != null && urimain9 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null && comurimain5 != null && comurimain6 != null && comurimain7 != null && comurimain8 != null && comurimain9 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain5));
                   mUploadTask = fileReference.putFile(comurimain5)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain6));
                   mUploadTask = fileReference.putFile(comurimain6)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain7));
                   mUploadTask = fileReference.putFile(comurimain7)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);

                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain8));
                   mUploadTask = fileReference.putFile(comurimain8)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain9));
                   mUploadTask = fileReference.putFile(comurimain9)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null && urimain5 != null && urimain6 != null && urimain7 != null && urimain8 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null && comurimain5 != null && comurimain6 != null && comurimain7 != null && comurimain8 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain5));
                   mUploadTask = fileReference.putFile(comurimain5)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain6));
                   mUploadTask = fileReference.putFile(comurimain6)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain7));
                   mUploadTask = fileReference.putFile(comurimain7)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain8));
                   mUploadTask = fileReference.putFile(comurimain8)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null && urimain5 != null && urimain6 != null && urimain7 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null && comurimain5 != null && comurimain6 != null && comurimain7 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);

                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);

                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain5));
                   mUploadTask = fileReference.putFile(comurimain5)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);

                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain6));
                   mUploadTask = fileReference.putFile(comurimain6)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain7));
                   mUploadTask = fileReference.putFile(comurimain7)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null && urimain5 != null && urimain6 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null && comurimain5 != null && comurimain6 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain5));
                   mUploadTask = fileReference.putFile(comurimain5)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain6));
                   mUploadTask = fileReference.putFile(comurimain6)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null && urimain5 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null && comurimain5 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain5));
                   mUploadTask = fileReference.putFile(comurimain5)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null && urimain3 != null && urimain4 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain3 != null && comurimain4 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);

                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });


                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain4));
                   mUploadTask = fileReference.putFile(comurimain4)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null && urimain3 != null) {
               if (comurimain1 != null && comurimain2 != null && comurimain1 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });

                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain3));
                   mUploadTask = fileReference.putFile(comurimain3)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null && urimain2 != null) {
               if (comurimain1 != null && comurimain2 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
                   fileReference = mStorageRef.child(System.currentTimeMillis()
                           + "." + getFileExtension(urimain2));
                   mUploadTask = fileReference.putFile(comurimain2)
                           .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                   Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                                   while (!urlTask.isSuccessful()) ;
                                   Uri downloadUrl = urlTask.getResult();
                                   Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                                   String uploadId = mDatabaseRef.push().getKey();
                                   mDatabaseRef.child(uploadId).setValue(upload);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else if (urimain1 != null) {
               if (comurimain1 != null) {
                   mProgressBar.setVisibility(View.VISIBLE);
                   StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(urimain1));
                   mUploadTask = fileReference.putFile(comurimain1).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                       @Override
                       public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                           Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                           while (!urlTask.isSuccessful()) ;
                           Uri downloadUrl = urlTask.getResult();
                           Upload upload = new Upload(mEditTextFileName.getText().toString().trim(), downloadUrl.toString());
                           String uploadId = mDatabaseRef.push().getKey();
                           mDatabaseRef.child(uploadId).setValue(upload);
                           mProgressBar.setVisibility(View.INVISIBLE);
                           mProgressBar.setVisibility(View.INVISIBLE);
                       }
                   })
                           .addOnFailureListener(new OnFailureListener() {
                               @Override
                               public void onFailure(@NonNull Exception e) {
                                   Toast.makeText(Uploadinstant.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   mProgressBar.setVisibility(View.INVISIBLE);
                               }
                           })
                           .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                               @Override
                               public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               }
                           });
               }
           } else {
               Toast toast = Toast.makeText(Uploadinstant.this, "No Images Picked", Toast.LENGTH_LONG);
               toast.show();
           }
       }
       else {
           Toast toast = Toast.makeText(Uploadinstant.this, "No Tag", Toast.LENGTH_LONG);
           toast.show();
       }
    }

    private void uploadtags() {
        hDatabase.removeValue();
        if(cardimaheuri10!=null&&cardimaheuri9!=null&&
            cardimaheuri8!=null&&cardimaheuri7!=null&&
            cardimaheuri6!=null&&cardimaheuri5!=null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null) {

        String title10 = cardusername10;
        String imageur110 = cardimaheuri10;
        Upload post10 = new Upload(title10,imageur110);
        hDatabase.push().setValue(post10);

        String title9 = cardusername9;
        String imageurl9 = cardimaheuri9;
        Upload post9 = new Upload(title9,imageurl9);
        hDatabase.push().setValue(post9);


        String title8 = cardusername8;
        String imageurl8 = cardimaheuri8;
        Upload post8 = new Upload(title8,imageurl8);
        hDatabase.push().setValue(post8);


        String title7 = cardusername7;
        String imageurl7 = cardimaheuri7;
        Upload post7 = new Upload(title7,imageurl7);
        hDatabase.push().setValue(post7);


        String title6 = cardusername6;
        String imageurl6 = cardimaheuri6;
        Upload post6 = new Upload(title6,imageurl6);
        hDatabase.push().setValue(post6);


        String title5 = cardusername5;
        String imageurl5 = cardimaheuri5;
        Upload post5 = new Upload(title5,imageurl5);
        hDatabase.push().setValue(post5);



        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);


        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);



        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);



        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }


    else  if(cardimaheuri10==null&&cardimaheuri9!=null&&
            cardimaheuri8!=null&&cardimaheuri7!=null&&
            cardimaheuri6!=null&&cardimaheuri5!=null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {
        String title9 = cardusername9;
        String imageurl9 = cardimaheuri9;
        Upload post9 = new Upload(title9,imageurl9);
        hDatabase.push().setValue(post9);
        String title8 = cardusername8;
        String imageurl8 = cardimaheuri8;
        Upload post8 = new Upload(title8,imageurl8);
        hDatabase.push().setValue(post8);
        String title7 = cardusername7;
        String imageurl7 = cardimaheuri7;
        Upload post7 = new Upload(title7,imageurl7);
        hDatabase.push().setValue(post7);
        String title6 = cardusername6;
        String imageurl6 = cardimaheuri6;
        Upload post6 = new Upload(title6,imageurl6);
        hDatabase.push().setValue(post6);
        String title5 = cardusername5;
        String imageurl5 = cardimaheuri5;
        Upload post5 = new Upload(title5,imageurl5);
        hDatabase.push().setValue(post5);
        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);
        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }


    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8!=null&&cardimaheuri7!=null&&
            cardimaheuri6!=null&&cardimaheuri5!=null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {
        String title8 = cardusername8;
        String imageurl8 = cardimaheuri8;
        Upload post8 = new Upload(title8,imageurl8);
        hDatabase.push().setValue(post8);
        String title7 = cardusername7;
        String imageurl7 = cardimaheuri7;
        Upload post7 = new Upload(title7,imageurl7);
        hDatabase.push().setValue(post7);
        String title6 = cardusername6;
        String imageurl6 = cardimaheuri6;
        Upload post6 = new Upload(title6,imageurl6);
        hDatabase.push().setValue(post6);
        String title5 = cardusername5;
        String imageurl5 = cardimaheuri5;
        Upload post5 = new Upload(title5,imageurl5);
        hDatabase.push().setValue(post5);
        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);
        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }


    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7!=null&&
            cardimaheuri6!=null&&cardimaheuri5!=null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {
        String title7 = cardusername7;
        String imageurl7 = cardimaheuri7;
        Upload post7 = new Upload(title7,imageurl7);
        hDatabase.push().setValue(post7);
        String title6 = cardusername6;
        String imageurl6 = cardimaheuri6;
        Upload post6 = new Upload(title6,imageurl6);
        hDatabase.push().setValue(post6);
        String title5 = cardusername5;
        String imageurl5 = cardimaheuri5;
        Upload post5 = new Upload(title5,imageurl5);
        hDatabase.push().setValue(post5);
        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);
        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }




    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7==null&&
            cardimaheuri6!=null&&cardimaheuri5!=null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {
        String title6 = cardusername6;
        String imageurl6 = cardimaheuri6;
        Upload post6 = new Upload(title6,imageurl6);
        hDatabase.push().setValue(post6);
        String title5 = cardusername5;
        String imageurl5 = cardimaheuri5;
        Upload post5 = new Upload(title5,imageurl5);
        hDatabase.push().setValue(post5);
        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);
        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }


    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7==null&&
            cardimaheuri6==null&&cardimaheuri5!=null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {
        String title5 = cardusername5;
        String imageurl5 = cardimaheuri5;
        Upload post5 = new Upload(title5,imageurl5);
        hDatabase.push().setValue(post5);
        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);
        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }



    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7==null&&
            cardimaheuri6==null&&cardimaheuri5==null&&cardimaheuri4!=null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {

        String title4 = cardusername4;
        String imageurl4 = cardimaheuri4;
        Upload post4 = new Upload(title4,imageurl4);
        hDatabase.push().setValue(post4);
        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }




    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7==null&&
            cardimaheuri6==null&&cardimaheuri5==null&&cardimaheuri4==null&&
            cardimaheuri3!=null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {

        String title3 = cardusername3;
        String imageurl3 = cardimaheuri3;
        Upload post3 = new Upload(title3,imageurl3);
        hDatabase.push().setValue(post3);
        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }



    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7==null&&
            cardimaheuri6==null&&cardimaheuri5==null&&cardimaheuri4==null&&
            cardimaheuri3==null&&cardimaheuri2!=null&&cardimaheuri1!=null)
    {


        String title2 = cardusername2;
        String imageurl2 = cardimaheuri2;
        Upload post2 = new Upload(title2,imageurl2);
        hDatabase.push().setValue(post2);
        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }


    else  if(cardimaheuri10==null&&cardimaheuri9==null&&
            cardimaheuri8==null&&cardimaheuri7==null&&
            cardimaheuri6==null&&cardimaheuri5==null&&cardimaheuri4==null&&
            cardimaheuri3==null&&cardimaheuri2==null&&cardimaheuri1!=null)
    {

        String title1 = cardusername1;
        String imageurl1 = cardimaheuri1;
        Upload post1 = new Upload(title1,imageurl1);
        hDatabase.push().setValue(post1);
    }






    }
    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

}



