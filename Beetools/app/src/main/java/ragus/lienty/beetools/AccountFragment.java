package ragus.lienty.beetools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;


public class AccountFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button syncBtn = (Button) view.findViewById(R.id.tSyncApi);
        syncBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                //action on click
                try {
                    displayChar(XmlParser.extractXMLString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Toast.makeText(getActivity(), "test toast btn", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void displayChar(List<Map> mapTab){
        Map<String, String> hm;
        String tmp ="";
        if (!(mapTab.get(0).isEmpty())) {
            hm = mapTab.get(0);
            TextView name0 = (TextView) getView().findViewById(R.id.tName0);
            TextView charId0 = (TextView) getView().findViewById(R.id.tCharId0);
            TextView accId0 = (TextView) getView().findViewById(R.id.tAccid0);
            tmp = name0.getText().toString();
            name0.setText(tmp + " " + hm.get("name"));

            tmp = charId0.getText().toString();
            charId0.setText(tmp + " " + hm.get("characterID"));

            tmp = accId0.getText().toString();
            accId0.setText(tmp + " " + hm.get("corporationID"));
        }

        if (!(mapTab.get(1).isEmpty())) {
            hm = mapTab.get(1);
            TextView name1 = (TextView) getView().findViewById(R.id.tName1);
            TextView charId1 = (TextView) getView().findViewById(R.id.tCharId1);
            TextView accId1 = (TextView) getView().findViewById(R.id.tAccid1);
            tmp = name1.getText().toString();
            name1.setText(tmp + " " + hm.get("name"));

            tmp = charId1.getText().toString();
            charId1.setText(tmp + " " + hm.get("characterID"));

            tmp = accId1.getText().toString();
            accId1.setText(tmp + " " + hm.get("corporationID"));
        }

        if (!(mapTab.get(2).isEmpty())) {
            hm = mapTab.get(2);
            TextView name2 = (TextView) getView().findViewById(R.id.tName2);
            TextView charId2 = (TextView) getView().findViewById(R.id.tCharId2);
            TextView accId2 = (TextView) getView().findViewById(R.id.tAccid2);
            tmp = name2.getText().toString();
            name2.setText(tmp + " " + hm.get("name"));

            tmp = charId2.getText().toString();
            charId2.setText(tmp + " " + hm.get("characterID"));

            tmp = accId2.getText().toString();
            accId2.setText(tmp + " " + hm.get("corporationID"));
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
