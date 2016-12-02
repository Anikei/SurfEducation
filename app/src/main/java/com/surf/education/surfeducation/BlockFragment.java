package com.surf.education.surfeducation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BlockFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);

        Button nextButton = (Button) view.findViewById(R.id.button_first);
        nextButton.setText("1234");

        return view;
    }

    /*
    onCreate() {}
    onCreateView() {}
    onPause() {}
    */

}
