package com.cs463.lhrexplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDescription#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDescription extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView heading;
    private ImageView img;
    private TextView detail;

    public FragmentDescription() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDescription.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDescription newInstance(String param1, String param2) {
        FragmentDescription fragment = new FragmentDescription();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        heading = view.findViewById(R.id.tv_heading);
        img = view.findViewById(R.id.imageView);
        detail = view.findViewById(R.id.tv_detail);

        return view;
    }


    public void updateGUI(String tag) {
       String name = TagToTitle(tag);
       int imgId = TagToResourceId(tag, "drawable");
       String detail = ReadFile(tag);

       heading.setText(name);
       img.setImageResource(imgId);
       this.detail.setText(detail);
    }

    private String TagToTitle(String tag){
        switch(tag){
            case "1":
                return "Armacost Building";
            case "2":
                return "Army Meusium";
            case "3":
                return "Badshahi Mosque";
            case "4":
                return "Shrine of Iqbal";
            case "5":
                return "Lahore Fort";
            case "6":
                return "Liberty chowk";
            case "7":
                return "Lahore Meusium";
            case "8":
                return "Minar-e-Pakistan";
            case "9":
                return "Wazir khan mosque";
        }
        return "invalid";
    }

    private int TagToResourceId(String tag, String type){
        String filename = "frag_armacost";
        switch(tag){
            case "1":
                filename = "frag_armacost";
                break;
            case "2":
                filename = "frag_armymeusium";
                break;
            case "3":
                filename = "frag_badshahi";
                break;
            case "4":
                filename = "frag_iqbal";
                break;
            case "5":
                filename = "frag_lahorefort";
                break;
            case "6":
                filename = "frag_liberty";
                break;
            case "7":
                filename = "frag_meusium";
                break;
            case "8":
                filename = "frag_minar";
                break;
            case "9":
                filename = "frag_wazirkhan";
                break;
        }
        int imgId = getResources().getIdentifier(filename, type, getActivity().getPackageName());
        return imgId;
    }

    private String ReadFile(String tag){
        int fileId = TagToResourceId(tag,"raw");
        Scanner scanner = new Scanner( getResources().openRawResource(fileId) );
        String text = "";
        while(scanner.hasNextLine()){
            text += scanner.nextLine();
        }
        return text;
    }

}