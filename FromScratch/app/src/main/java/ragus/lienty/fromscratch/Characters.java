package ragus.lienty.fromscratch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Characters extends Fragment{
    TextView tNotif, tSkill;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_characters,
                container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // code here
        tNotif = (TextView)getView().findViewById(R.id.tNotifications);
        tNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Test on click Notif",Toast.LENGTH_SHORT).show();
            }
        });
        tSkill = (TextView)getView().findViewById(R.id.tSkillQueue);
        tSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Test on click Skills",Toast.LENGTH_SHORT).show();
            }
        });


    }


}
