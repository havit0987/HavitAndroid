package org.techtown.havit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Fragment5 extends Fragment {
    Button localenbtn, localkobtn;
    PackageManager pm;
    String str,str1,str2;
    TextView textView;
    String themeColor;

    SharedPreferences.Editor prefEditor;
    SharedPreferences prefs;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment5, container, false);

        prefEditor = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext()).edit();
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());


        String str = getResources().getString(R.string.language);
        String str1= getResources().getString(R.string.korean);
        String str2 = getResources().getString(R.string.english);
        Spinner spinner = view.findViewById(R.id.spinner);
        String [] items = {str,str1,str2};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, items);
        //fragment에서는 this 에 .getActivity 를 붙여야한다.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        textView = view.findViewById(R.id.textView4);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                } else if (position == 1) {

                    Locale locale2 = new Locale("ko"); // 한국어 변경법
                    Locale.setDefault(locale2);
                    Configuration config2 = new Configuration();
                    config2.locale = locale2;
                    //getBaseContext().getResources().updateConfiguration(config2,getBaseContext().getResources().getDisplayMetrics()); // 일반 액티비티
                    getResources().updateConfiguration(config2, getResources().getDisplayMetrics()); // 프래그먼트
                    Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName()); //프래그먼트
                    // Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName()); //일반 액티비티
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                } else if (position == 2) {

                    Locale locale2 = new Locale("en"); // 언어 변경법
                    Locale.setDefault(locale2);
                    Configuration config2 = new Configuration();
                    config2.locale = locale2;
                    //getBaseContext().getResources().updateConfiguration(config2,getBaseContext().getResources().getDisplayMetrics()); // 일반 액티비티
                    getResources().updateConfiguration(config2, getResources().getDisplayMetrics()); // 프래그먼트
                    Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName()); //프래그먼트
                    // Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName()); //일반 액티비티
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");
            }
        });


        Switch sw = (Switch) view.findViewById(R.id.switch1);


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    themeColor = ThemeUtil.DARK_MODE;
                    ThemeUtil.applyTheme(themeColor);
                    ThemeUtil.modSave(getContext(),themeColor);
                   // ThemeUtil.modLoad(getContext());
                   // sw.setChecked(true);
                    prefEditor.putString("checked","yes");
                    prefEditor.apply();
                }else{
                    themeColor = ThemeUtil.LIGHT_MODE;
                    ThemeUtil.applyTheme(themeColor);
                    ThemeUtil.modSave(getContext(),themeColor);
                   // ThemeUtil.modLoad(getContext());
                    //sw.setChecked(false);
                    prefEditor.putString("checked","false");
                    prefEditor.apply();
                }
            }
        });
            if (prefs.getString("checked","no").equals("yes")){

            sw.setChecked(true);

        }else {

            sw.setChecked(false);
        }


        return view;
    }


}
