package org.techtown.havit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    Button capbutton;
    Button mugbutton;
    Button BTbutton;
    Button WTbutton;
    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3,container,false);

        capbutton = view.findViewById(R.id.capbutton);
        mugbutton = view.findViewById(R.id.mugbutton);
        BTbutton = view.findViewById(R.id.BTbutton);
        WTbutton = view.findViewById(R.id.WTbutton);

        capbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CapDetail.class);
                startActivity(intent);
            }

        });

        mugbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MugDetail.class);
                startActivity(intent);
            }
        });
        BTbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BTDetail.class);
                startActivity(intent);
            }
        });
        WTbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WTDetail.class);
                startActivity(intent);
            }
        });

        return view;


    }
}
