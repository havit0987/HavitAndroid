package org.techtown.havit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Fragment5 extends Fragment {
    Button localenbtn, localkobtn;
    PackageManager pm;
    String[] items = {"언어설정","한국어","영어"};
    TextView textView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, container, false);

        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        textView = view.findViewById(R.id.textView4);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    textView.setText("언어설정");
                }

                else if (position == 1){
                    textView.setText("한국어");
                    Locale locale2 = new Locale("ko"); // 한국어 변경법
                    Locale.setDefault(locale2);
                    Configuration config2 = new Configuration();
                    config2.locale = locale2;
                    //getBaseContext().getResources().updateConfiguration(config2,getBaseContext().getResources().getDisplayMetrics()); // 일반 액티비티
                    getResources().updateConfiguration(config2,getResources().getDisplayMetrics()); // 프래그먼트
                    Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName()); //프래그먼트
                    // Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName()); //일반 액티비티
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                }
                else if(position ==2){
                    textView.setText("영어");
                    Locale locale2 = new Locale("en"); // 언어 변경법
                    Locale.setDefault(locale2);
                    Configuration config2 = new Configuration();
                    config2.locale = locale2;
                    //getBaseContext().getResources().updateConfiguration(config2,getBaseContext().getResources().getDisplayMetrics()); // 일반 액티비티
                    getResources().updateConfiguration(config2,getResources().getDisplayMetrics()); // 프래그먼트
                    Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName()); //프래그먼트
                    // Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName()); //일반 액티비티
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                }
                //textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");
            }
        });


        localenbtn = view.findViewById(R.id.localenbtn);
        localenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        localkobtn = view.findViewById(R.id.localkobtn);
        localkobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return  view;
    }



}
