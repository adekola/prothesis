package pritibits.com.prothesis;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import modules.Dimmer;
import modules.Mapper;

public class CreateDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_device);

        Button createButton = (Button) findViewById(R.id.buttonAddDevice);

        createButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //do something useful like generate the commands for creating the device
                        //or for now, just go back to the calling activity


                        //user selects the DEVICE_TYPE as well as TECHNOLOGY and this is passed to the mapper for generating the
                        // required FHEM commands to set same up on the FHEM side of things
                        //upon successful creation, control is returned to the MainActivity which lists active devices

                        String deviceName = ((EditText)findViewById(R.id.deviceNameText)).getText().toString();
                        String deviceManufacturer = ((EditText)findViewById(R.id.deviceManufacturerText)).getText().toString();

                        Spinner commTechSpinner = (Spinner) findViewById(R.id.commTechSpinner);
                        String commTech = commTechSpinner.getSelectedItem().toString();

                        Spinner deviceTypeSpinner = (Spinner) findViewById(R.id.deviceTypeSpinner);
                        String deviceType = commTechSpinner.getSelectedItem().toString();

                        Dimmer dimmer = new Dimmer(deviceName, deviceManufacturer, commTech);
                        //now do the actual define
                        Mapper.Do("define", dimmer);

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("createdDevice", dimmer);
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();

                    }
                });

    }
}
