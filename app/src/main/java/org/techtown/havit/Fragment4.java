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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.chip.Chip;

public class Fragment4 extends Fragment implements OnMapReadyCallback {
    //private GoogleMap mMap;
    private MapView mapView = null;
    private Chip sunship, busanchip, seoulchip;
    ImageView imageView;
    private TextView maintext, addreestext, numbertext;
    private String bb;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
        sunship = view.findViewById(R.id.chipsuncheon);
        busanchip = view.findViewById(R.id.chipbusan);
        seoulchip = view.findViewById(R.id.seoulchip);
        maintext = view.findViewById(R.id.pname);
        addreestext = view.findViewById(R.id.paddress);
        numbertext = view.findViewById(R.id.pnum);

        mapView = view.findViewById(R.id.mapView);
        mapView.getMapAsync(this);


        numbertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = numbertext.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + tel));
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//액티비티가 처음 생성될 때 실행되는 함수

        if(mapView != null)
        {
            mapView.onCreate(savedInstanceState);
        }

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


        LatLng SEOUL = new LatLng(34.934207, 127.516644);

        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(SEOUL);

        markerOptions.title("HAVIT");

        markerOptions.snippet("순천점");

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(SEOUL).zoom(18).build();
        googleMap.moveCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.addMarker(markerOptions);






        seoulchip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb = getResources().getString(R.string.seoul);

                LatLng SEOUL = new LatLng(37.527331, 127.027352);

                MarkerOptions markerOptions = new MarkerOptions();

                markerOptions.position(SEOUL);

                markerOptions.title("HAVIT");

                markerOptions.snippet("서울점");

                googleMap.addMarker(markerOptions);

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));

                googleMap.animateCamera(CameraUpdateFactory.zoomTo(18));
                maintext.setText("HAVIT"+bb);
                addreestext.setText(R.string.seoul_address);
                numbertext.setText(R.string.seoul_num);

            }
        });
        busanchip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb = getResources().getString(R.string.busan);

                LatLng SEOUL = new LatLng(35.165782, 129.131344);

                MarkerOptions markerOptions = new MarkerOptions();

                markerOptions.position(SEOUL);

                markerOptions.title("HAVIT");

                markerOptions.snippet("부산점");

                googleMap.addMarker(markerOptions);

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));

                googleMap.animateCamera(CameraUpdateFactory.zoomTo(18));
                maintext.setText("HAVIT"+bb);
                addreestext.setText(R.string.busan_address);
                numbertext.setText(R.string.busan_num);
            }
        });
        sunship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb = getResources().getString(R.string.suncheon);

                LatLng SEOUL = new LatLng(34.934207, 127.516644);

                MarkerOptions markerOptions = new MarkerOptions();

                markerOptions.position(SEOUL);

                markerOptions.title("HAVIT");

                markerOptions.snippet("순천점");

                googleMap.addMarker(markerOptions);

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));

                googleMap.animateCamera(CameraUpdateFactory.zoomTo(18));
                maintext.setText("HAVIT"+bb);
                addreestext.setText(R.string.suncheon_address);
                numbertext.setText(R.string.suncheon_num);

            }
        });

    }
}
