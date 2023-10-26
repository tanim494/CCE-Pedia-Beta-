package com.tanim.uniguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class faculty extends Fragment {

    String[] facultyNames = {"Eng. Md. Razu Ahmed", "Dr. Mohammed Saifuddin", "Amanul Hoque", "Md Jiabul Hoque", "Areez Hafiz Md Zahid", "Mohammad Nadib Hasan", "Md. Humayun Kabir", "Hassan Jaki", "Zarin Tanzim"};
    String[] facultyDesignations = {"Professor & Chairman", "Assistant Professor", "Assistant Professor", "Lecturer", "Lecturer", "Lecturer", "Lecturer", "Lecturer", "Lecturer"};
    String[] facultyContactNumbers = {"01874543665", "01945767849", "01818673657", "01989685996", "01977723403", "01521483958", "01515286984", "01950853985", "01850925671"};
    int[] facultyImages = {R.drawable.razus, R.drawable.saifs, R.drawable.amans, R.drawable.jias, R.drawable.dtea, R.drawable.nadibs, R.drawable.rabbys, R.drawable.zakis, R.drawable.dtea};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_faculty, container, false);

        ArrayAdapter<String> facultyAdapter = new ArrayAdapter<String>(requireContext(), R.layout.faculty_item, R.id.facultyName, facultyNames) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                ImageView facultyImage = view.findViewById(R.id.facultyImage);
                facultyImage.setImageResource(facultyImages[position]);

                return view;
            }
        };

        ListView facultyListView = rootView.findViewById(R.id.facultyListView);
        facultyListView.setAdapter(facultyAdapter);

        // Add the OnItemClickListener for opening the dialer and displaying a toast
        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phoneNumber = facultyContactNumbers[position];
                String facultyName = facultyNames[position];

                // Open the dialer
                dialPhoneNumber(phoneNumber);

                // Display a toast with the faculty's name
                Toast.makeText(requireContext(), "Calling " + facultyName + " Sir", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}