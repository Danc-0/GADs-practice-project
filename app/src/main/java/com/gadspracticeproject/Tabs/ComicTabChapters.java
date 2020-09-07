//package com.example.tsp.within.Fragments.ComicTabs;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.tsp.within.Common.Common;
//import com.example.tsp.within.Helpers.Comics.Adapters.ComicListAdapter;
//import com.example.tsp.within.Helpers.Comics.Models.ComicChaptersDetails;
//import com.example.tsp.within.Helpers.Comics.Models.ComicDetails;
//import com.example.tsp.within.R;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ComicTabChapters extends Fragment {
//    private RecyclerView recyclerView;
//    private FirebaseDatabase firebaseDatabase;
//    private DatabaseReference databaseReference;
//    private List<ComicChaptersDetails> comicChaptersDetails;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_comic_tab_chapters, container, false);
//        recyclerView = view.findViewById(R.id.comicPreviewChaptersRecyclerView);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation()));
//        comicChaptersDetails = new ArrayList<>();
//        if (Common.comicSelected !=null){
//            fetch(Common.comicSelected);
//
//        }else{
//            fetch(Common.comicLibrarySelected);
//        }
//        return view;
//    }
//
//    private void fetch(ComicDetails comicSelected) {
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        String key = comicSelected.getPostKey();
//
//
//        databaseReference = firebaseDatabase.getReference("Comic Details").child(key).child("Chapter Details");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
//                    ComicChaptersDetails chaptersDetails = postSnapshot.getValue(ComicChaptersDetails.class);
//                    comicChaptersDetails.add(chaptersDetails);
//                    Common.comicChapterList = comicChaptersDetails;
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        recyclerView.setAdapter(new ComicListAdapter( getContext(),comicChaptersDetails));
//    }
//
//
//}
