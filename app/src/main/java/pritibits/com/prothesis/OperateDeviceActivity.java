package pritibits.com.prothesis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import modules.Dimmer;

public class OperateDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //retrieve which device it is that is being operated;
        Intent i = getIntent();
        final Dimmer dimmer = i.getParcelableExtra("dimmerToOperate"); //this will be used to format the commands to send to FHEM

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operate_device);

        // for each of the commands supported, handle the click event
        Button dimDownButton = (Button)findViewById(R.id.dimDownButton);
        Button dimUpButton = (Button)findViewById(R.id.dimUpButton);
        Button dimDownByButton = (Button)findViewById(R.id.dimDownByButton);
        Button dimUpByButton = (Button)findViewById(R.id.dimUpByButton);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        /** Button offTillButton = (Button)findViewById(R.id.offTillButton);
        Button onTillButton = (Button)findViewById(R.id.onTillButton); **/

        dimDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimmer.dimDown();
            }
        });

        dimUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimmer.dimUp();
            }
        });

        dimDownByButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        dimUpByButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimmer.toggle();
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dimmer.on();
                } else {
                    // The toggle is disabled
                    dimmer.off();
                }
            }
        });

    }
}
