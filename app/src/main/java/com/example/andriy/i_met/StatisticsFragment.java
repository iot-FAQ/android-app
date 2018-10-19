package com.example.andriy.i_met;

import android.app.Fragment;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.dezlum.codelabs.getjson.GetJson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import javax.xml.transform.Result;

import it.sephiroth.android.library.widget.HListView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class StatisticsFragment extends Fragment {
    private HListView horizontalLIstOfLastData;
    private View view;
    private ArrayList arrayDevice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_statistics, container, false);
        horizontalLIstOfLastData = (HListView) view.findViewById(R.id.lastDataOfDevice);
        Spinner chooseAdress = view.findViewById(R.id.chooseAdress);
        chooseAdress.setPrompt("Виберіть адресу");
        String[] arrayAdress = {"Стрийська 81/17","Стрийська 115","Гашека 13"};
        ArrayAdapter<String> adapterSpinner=new ArrayAdapter<String>(getActivity(),R.layout.spinner_item,arrayAdress);
        chooseAdress.setAdapter(adapterSpinner);
        arrayDevice = new ArrayList();
        if(((MainActivity) getActivity()).isNetworkConnected()) {
            getData();
        }
        ArrayAdapter arrayAdapter = new LastDataOfDeviceAdapter(getActivity(), arrayDevice);
        horizontalLIstOfLastData.setAdapter(arrayAdapter);
        return view;
    }

    public void getData() {
        try {
            Map<String, Integer> map=new HashMap<>();
            JsonObject jsonObject = new GetJson().AsJSONObject("http://imet.pythonanywhere.com/get_data?email=alex@gmail.com&type=gas&counter=3663434534&week=week");
            Set<Map.Entry<String, JsonElement>> set=jsonObject.entrySet();
            for (Map.Entry i : set){
                Log.d("ok",i.getValue().toString().substring(1,i.getValue().toString().length()-1));
                map.put(i.getKey().toString(), Integer.parseInt( i.getValue().toString().substring(1,i.getValue().toString().length()-1)));
            }
            Device device=new Device("hello", TypeDevice.GAS, 56);
            device.setMapData(map);
            arrayDevice.add(device);
            Log.d("ok", jsonObject.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (IllegalStateException e){
            Toast.makeText( getActivity(),"no internet", Toast.LENGTH_SHORT ).show();
            Intent intent=new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }



}
