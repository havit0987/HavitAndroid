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
    Chip sunship,busanchip,seoulchip;
    ImageView imageView;
    TextView maintext,addreestext,numbertext;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4,container,false);
        sunship = view.findViewById(R.id.chipsuncheon);
        busanchip=view.findViewById(R.id.chipbusan);
        seoulchip=view.findViewById(R.id.seoulchip);
        imageView=view.findViewById(R.id.imageView2);
        maintext=view.findViewById(R.id.pname);
        addreestext=view.findViewById(R.id.paddress);
        numbertext=view.findViewById(R.id.pnum);

        numbertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = numbertext.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tel));
                startActivity(intent);
            }
        });

        sunship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.map2);
                maintext.setText("HAVIT 순천점");
                addreestext.setText("전남 순천시 팔마3길 11");
                numbertext.setText("0507-1437-5707");

            }
        });
        busanchip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.busanmap1);
                maintext.setText("HAVIT 부산점");
                addreestext.setText("부산광역시 해운대구 센텀1로 28");
                numbertext.setText("051-000-0000");
            }
        });
        seoulchip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.seoulmap2);
                maintext.setText("HAVIT 서울점");
                addreestext.setText("서울특별시 강남구 압구정로165");
                numbertext.setText("02-547-2233");

            }
        });


        return view;
    }
}
