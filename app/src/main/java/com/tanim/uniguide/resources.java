package com.tanim.uniguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class resources extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resources, container, false);

        TextView facebookPage = rootView.findViewById(R.id.openFacebookPage);
        TextView facebookFemPage = rootView.findViewById(R.id.openFacebookFemPage);
        TextView questionPage = rootView.findViewById(R.id.openQuestionPage);
        TextView semesterResourcesPage = rootView.findViewById(R.id.openSemesterResourcesPage);
        TextView impPage = rootView.findViewById(R.id.openImpPage);
        TextView busPage = rootView.findViewById(R.id.openBusPage);
        TextView routinePage = rootView.findViewById(R.id.openRoutinePage);
        TextView iiucPage = rootView.findViewById(R.id.openIIUCPage);

        facebookPage.setOnClickListener(v -> openWebPage("https://www.facebook.com/profile.php?id=100090282199663"));

        facebookFemPage.setOnClickListener(v -> openWebPage("https://www.facebook.com/profile.php?id=100091710725410"));

        questionPage.setOnClickListener(v -> openWebPage("https://drive.google.com/drive/folders/19kpQtcze690uvLwJRz0uhfmy4Ji0qp7e"));

        semesterResourcesPage.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            assert fragmentManager != null;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Midcontainer, new semesterResources());
            fragmentTransaction.addToBackStack(null); // Optional: Add transaction to the back stack
            fragmentTransaction.commit();
        });

        impPage.setOnClickListener(v -> openWebPage("https://jpst.it/3q6PY"));

        busPage.setOnClickListener(v -> openWebPage("https://jpst.it/3q4Pl"));

        routinePage.setOnClickListener(v -> openWebPage("https://jpst.it/3q4Rc"));

        iiucPage.setOnClickListener(v -> openWebPage("https://www.iiuc.ac.bd/cce/bachelor"));

        return rootView;
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
