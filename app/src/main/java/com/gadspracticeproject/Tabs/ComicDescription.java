//package com.example.tsp.within.Fragments.ComicTabs;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//
//import android.text.method.ScrollingMovementMethod;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.tsp.within.Common.Common;
//import com.example.tsp.within.Helpers.Comics.Models.ComicDetails;
//import com.example.tsp.within.R;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class ComicDescription extends Fragment {
//    private TextView desc, writer;
//    private FirebaseDatabase firebaseDatabase;
//    private DatabaseReference databaseReference;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_comic_description, container, false);
//        writer= view.findViewById(R.id.comicWriter);
//        desc= view.findViewById(R.id.comic_desc);
//        desc.setMovementMethod(new ScrollingMovementMethod());
//        if (Common.comicSelected !=null){
//            fetch(Common.comicSelected);
//
//        }else{
//            fetch(Common.comicLibrarySelected);
//        }
//        return view;
//
//    }
//    private void fetch(ComicDetails comicSelected) {
//
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        String key = comicSelected.getPostKey();
//        databaseReference = firebaseDatabase.getReference("Comic Details").child(key);
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ComicDetails comicDetails =dataSnapshot.getValue(ComicDetails.class);
//                Log.d("TabDesc", ""+comicDetails.getDescription());
//                desc.setText(comicDetails.getDescription());
//                writer.setText(comicDetails.getWriter());
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//
//}
