package pritibits.com.prothesis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import modules.Dimmer;

// main or default activity page with the list of devices which have been created and can then be operated
//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {

    static final int CREATE_DEVICE_RESULT = 2;
    ListView listView;
    private ArrayAdapter<Dimmer> deviceListAdapter;
    //a global variable to keep the list of devices
    List<Dimmer> devices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.devicesListView);
        deviceListAdapter = new ArrayAdapter<Dimmer>(this, android.R.layout.simple_list_item_1, android.R.id.text1, devices);

        Button createDeviceButton = (Button)findViewById(R.id.buttonAddDimmer);
        createDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCreateDeviceActivity();
            }
        });

        listView.setAdapter(deviceListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int itemPosition = i;

                Dimmer itemClicked = (Dimmer)listView.getItemAtPosition(itemPosition);

                startOperateDeviceActivity(itemClicked);
                //Toast.makeText(getApplicationContext(), "Position: "+itemPosition+" ListItem: "+itemClicked, Toast.LENGTH_LONG);
                //then open up the operate device view


            }
        });
    }

    void startOperateDeviceActivity(Dimmer dimmerToOperate){
        Intent intent =  new Intent(this, OperateDeviceActivity.class);
        //pass on the device to be operated;
        intent.putExtra("dimmerToOperate", dimmerToOperate);
        startActivity(intent);
    }

    void startCreateDeviceActivity(){
        Intent intent =  new Intent(this, CreateDeviceActivity.class);
        startActivityForResult(intent, CREATE_DEVICE_RESULT); //requestCode of 2

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == CREATE_DEVICE_RESULT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The device was successfully created
                Dimmer createdDevice = data.getParcelableExtra("createdDevice");
                //now add to the list of devices in the list
                devices.add(createdDevice);
                deviceListAdapter.notifyDataSetChanged();
                //refresh the devices list
                // Do something with the contact here (bigger example below)
            }
        }
    }
}
