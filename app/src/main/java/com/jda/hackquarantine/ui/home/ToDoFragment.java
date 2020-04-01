package com.jda.hackquarantine.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jda.hackquarantine.R;
import com.jda.hackquarantine.ui.PageViewModel;

/**
 * ToDo TAB fragment (activity)
 */
public class ToDoFragment extends Fragment {

    private Button button;
    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static ToDoFragment newInstance(int index) {
        ToDoFragment fragment = new ToDoFragment();
        Bundle bundle = new Bundle(); // Maps string to number
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_to_do, container, false);
        //button = (Button) root.findViewById(R.id.button1);
        return root;
    }
}