package org.techtown.havit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private Button button,v1btn;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,container,false);

        button = view.findViewById(R.id.T1button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DisposableActivity.class);
                startActivity(intent);

            }
        });
        v1btn = view.findViewById(R.id.V1button);
        v1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RechargeableDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
