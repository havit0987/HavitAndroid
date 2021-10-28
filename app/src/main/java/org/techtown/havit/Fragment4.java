package org.techtown.havit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.Chip;

public class Fragment4 extends Fragment {

    Chip chips,chipb,chipse;
    ImageView imageView = null;
    TextView pname,paddress,pnum;
    int i = 0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment4,container,false);

        chips = view.findViewById(R.id.chipsuncheon);
        chipb = view.findViewById(R.id.chipbusan);
        chipse = view.findViewById(R.id.chip6);
        pname = view.findViewById(R.id.pname);
        paddress = view.findViewById(R.id.paddress);
        pnum = view.findViewById(R.id.pnum);
        imageView=view.findViewById(R.id.imageView2);


        pnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cintent = new Intent();
                cintent.setAction(Intent.ACTION_DIAL);
                cintent.setData(Uri.parse("tel:"+pnum.getText().toString()));
                startActivity(cintent);
            }
        });

        chips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    imageView.setImageResource(R.drawable.map2);
                    pname.setText("HAVIT 순천점");
                    paddress.setText("전남 순천시 팔마3길 11");
                    pnum.setText("0507-1437-5707");

            }

        });
        chipb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageResource(R.drawable.busanmap1);
                pname.setText("HAVIT 부산점");
                paddress.setText("부산광역시 해운대구 센텀1로 28");
                pnum.setText("051-000-0000");



            }
        });

        chipse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageResource(R.drawable.seoulmap2);
                pname.setText("HAVIT 서울점");
                paddress.setText("서울특별시 강남구 압구정로 165");
                pnum.setText("02-547-2233");


            }
        });
        return view;
    }
}
