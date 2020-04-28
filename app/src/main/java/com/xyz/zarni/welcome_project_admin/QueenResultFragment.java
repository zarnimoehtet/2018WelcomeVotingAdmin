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
public class QueenResultFragment extends Fragment {

    private DatabaseReference fVote;
    private TextView c1, c2, c3, c4, c5, c6, c7, c8, c9;
    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9;
    private String hhw, mms, nzt, tzlp, mcm, zpp, mas, spn, mppw;
    private String p1, p2, p3, p4, p5, p6, p7, p8, p9;

    public QueenResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_queen_result, container, false);


        fVote = FirebaseDatabase.getInstance().getReference().child("fVote");
        fVote.keepSynced(true);

        c1 = (TextView) v.findViewById(R.id.c1);
        c2 = (TextView) v.findViewById(R.id.c2);
        c3 = (TextView) v.findViewById(R.id.c3);
        c4 = (TextView) v.findViewById(R.id.c4);
        c5 = (TextView) v.findViewById(R.id.c5);
        c6 = (TextView) v.findViewById(R.id.c6);
        c7 = (TextView) v.findViewById(R.id.c7);
//        c8 = (TextView) v.findViewById(R.id.c8);
//        c9 = (TextView) v.findViewById(R.id.c9);

        i1 = (ImageView) v.findViewById(R.id.p1);
        i2 = (ImageView) v.findViewById(R.id.p2);
        i3 = (ImageView) v.findViewById(R.id.p3);
        i4 = (ImageView) v.findViewById(R.id.p4);
        i5 = (ImageView) v.findViewById(R.id.p5);
        i6 = (ImageView) v.findViewById(R.id.p6);
        i7 = (ImageView) v.findViewById(R.id.p7);
//        i8 = (ImageView) v.findViewById(R.id.p8);
//        i9 = (ImageView) v.findViewById(R.id.p9);

        p1 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2774.JPG?alt=media&token=3210d440-64a7-4194-84cc-9daf58eceb9f";
        p2 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2832.JPG?alt=media&token=30446c98-bb93-4917-ae21-5e7497e7d8db";
        p3 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2820.JPG?alt=media&token=0102a987-b214-4224-8cc4-b0a1385450fc";
        p4 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2785.JPG?alt=media&token=9d8ac9ff-227c-4601-bf4c-f6a47bc2f4a8";
        p5 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2839.JPG?alt=media&token=84f0f23e-8f9e-4663-b8b8-475188986ae0";
        p6 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2764.JPG?alt=media&token=43854120-2e1a-421b-bc43-7bd885c784e6";
        p7 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2794.JPG?alt=media&token=eea329f3-4d0c-4e3e-8df2-46237d5541b3";
//        p8 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2806.JPG?alt=media&token=606e1852-adcb-4b5f-800c-fbc57595496e";
//        p9 = "https://firebasestorage.googleapis.com/v0/b/welcome-voting-application.appspot.com/o/Girls_Images%2FIMG_2861.JPG?alt=media&token=ec18a2d5-55c0-4a81-9b10-460f2f999087";


        Glide.with(getActivity().getApplicationContext()).load(p1).into(i1);
        Glide.with(getActivity().getApplicationContext()).load(p2).into(i2);
        Glide.with(getActivity().getApplicationContext()).load(p3).into(i3);
        Glide.with(getActivity().getApplicationContext()).load(p4).into(i4);
        Glide.with(getActivity().getApplicationContext()).load(p5).into(i5);
        Glide.with(getActivity().getApplicationContext()).load(p6).into(i6);
        Glide.with(getActivity().getApplicationContext()).load(p7).into(i7);
//        Glide.with(getActivity().getApplicationContext()).load(p8).into(i8);
//        Glide.with(getActivity().getApplicationContext()).load(p9).into(i9);

        fVote = FirebaseDatabase.getInstance().getReference().child("fVote");
        fVote.keepSynced(true);

        fVote.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hhw = dataSnapshot.child("1").getChildrenCount() + "";
                mms = dataSnapshot.child("2").getChildrenCount() + "";
                nzt = dataSnapshot.child("3").getChildrenCount() + "";
                tzlp = dataSnapshot.child("4").getChildrenCount() + "";
                mcm = dataSnapshot.child("5").getChildrenCount() + "";
                zpp = dataSnapshot.child("6").getChildrenCount() + "";
                mas = dataSnapshot.child("7").getChildrenCount() + "";
//                spn = dataSnapshot.child("8").getChildrenCount() + "";
//                mppw = dataSnapshot.child("9").getChildrenCount() + "";

                c1.setText(hhw);
                c2.setText(mms);
                c3.setText(nzt);
                c4.setText(tzlp);
                c5.setText(mcm);
                c6.setText(zpp);
                c7.setText(mas);
//                c8.setText(spn);
//                c9.setText(mppw);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;
    }

}
