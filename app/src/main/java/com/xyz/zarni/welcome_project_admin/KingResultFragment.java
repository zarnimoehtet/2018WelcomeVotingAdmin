package com.xyz.zarni.welcome_project_admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class KingResultFragment extends Fragment {

    private DatabaseReference mVote;
    private TextView c1, c2, c3, c4, c5, c6, c7, c8, c9;
    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9;
    private String pmh, aks, wykk, hhha, tpa, nmtm, kzh, nnmo, hal;
    private String p1, p2, p3, p4, p5, p6, p7, p8, p9;

    public KingResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_king_result, container, false);

        mVote = FirebaseDatabase.getInstance().getReference().child("mVote");
        mVote.keepSynced(true);

        c1 = (TextView) v.findViewById(R.id.c1);
        c2 = (TextView) v.findViewById(R.id.c2);
        c3 = (TextView) v.findViewById(R.id.c3);
        c4 = (TextView) v.findViewById(R.id.c4);
        c5 = (TextView) v.findViewById(R.id.c5);
        c6 = (TextView) v.findViewById(R.id.c6);
        c7 = (TextView) v.findViewById(R.id.c7);

        i1 = (ImageView) v.findViewById(R.id.p1);
        i2 = (ImageView) v.findViewById(R.id.p2);
        i3 = (ImageView) v.findViewById(R.id.p3);
        i4 = (ImageView) v.findViewById(R.id.p4);
        i5 = (ImageView) v.findViewById(R.id.p5);
        i6 = (ImageView) v.findViewById(R.id.p6);
        i7 = (ImageView) v.findViewById(R.id.p7);



        p1 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2696.JPG?alt=media&token=aa63fb3a-7511-4430-8766-57e4d9ef92a9";
        p2 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2684.JPG?alt=media&token=4c055de1-fed0-4978-9f7a-a8771036415f";
        p3 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2685.JPG?alt=media&token=c3eb6ac6-656b-4b9a-95c0-ecb6457f6676";
        p4 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2681.JPG?alt=media&token=f52e707f-392d-4072-b06e-efd27819cdac";
        p5 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2675.JPG?alt=media&token=9bb8f969-0d95-4de5-8259-4e71531a4cd1";
        p6 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2679.JPG?alt=media&token=1cc6ef55-b75c-44d8-b33a-acc34f00d0e6";
        p7 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2683.JPG?alt=media&token=317abc46-ca49-4db6-8b60-9f020e840358";
//        p8 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2674.JPG?alt=media&token=7ea3bffa-4b2b-4116-a979-4a05bd435bcb";
//        p9 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Images%2FIMG_2686.JPG?alt=media&token=9c00d679-9157-4094-b387-3f25e7c1e2f5";
//        // count = (TextView)v.findViewById(R.id.count);

        Glide.with(this).load(p1).into(i1);
        Glide.with(this).load(p2).into(i2);
        Glide.with(this).load(p3).into(i3);
        Glide.with(this).load(p4).into(i4);
        Glide.with(this).load(p5).into(i5);
        Glide.with(this).load(p6).into(i6);
        Glide.with(this).load(p7).into(i7);
//        Glide.with(this).load(p8).into(i8);
//        Glide.with(this).load(p9).into(i9);

        mVote.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    pmh = dataSnapshot.child("1").getChildrenCount() + "";
                    aks = dataSnapshot.child("2").getChildrenCount() + "";
                    wykk = dataSnapshot.child("3").getChildrenCount() + "";
                    hhha = dataSnapshot.child("4").getChildrenCount() + "";
                    tpa = dataSnapshot.child("5").getChildrenCount() + "";
                    nmtm = dataSnapshot.child("6").getChildrenCount() + "";
                    kzh = dataSnapshot.child("7").getChildrenCount() + "";
//                    nnmo = dataSnapshot.child("8").getChildrenCount() + "";
//                    hal = dataSnapshot.child("9").getChildrenCount() + "";

                    c1.setText(pmh);
                    c2.setText(aks);
                    c3.setText(wykk);
                    c4.setText(hhha);
                    c5.setText(tpa);
                    c6.setText(nmtm);
                    c7.setText(kzh);
//                    c8.setText(nnmo);
//                    c9.setText(hal);


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return v;
    }

}
