package org.techtown.havit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Fragment5 extends Fragment {
    Button localenbtn, localkobtn;
    PackageManager pm;
    String[] items = {"한국어","영어"};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, container, false);



        localenbtn = view.findViewById(R.id.localenbtn);
        localenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        localkobtn = view.findViewById(R.id.localkobtn);
        localkobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        return  view;
    }



}
