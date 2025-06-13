package bih.p003in.forestdept.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.adapter.OtherAreaAdapter;
import bih.p003in.forestdept.adapter.OtherAreaListener;
import bih.p003in.forestdept.model.OtherAreaInchargeList;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class SelectOtherAreaActivity extends Activity implements OtherAreaListener {
    ArrayList<OtherAreaInchargeList> areaList;
    RecyclerView rv_data;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0594R.layout.activity_select_other_area);
        this.rv_data = (RecyclerView) findViewById(C0594R.id.rv_data);
        populateLocalData();
    }

    public void populateLocalData() {
        ArrayList<OtherAreaInchargeList> arrayList = (ArrayList) getIntent().getSerializableExtra("data");
        this.areaList = arrayList;
        arrayList.add(0, new OtherAreaInchargeList());
        this.rv_data.setLayoutManager(new LinearLayoutManager(this));
        OtherAreaAdapter adapter = new OtherAreaAdapter(this, this.areaList, this);
        this.rv_data.setAdapter(adapter);
    }

    @Override // bih.p003in.forestdept.adapter.OtherAreaListener
    public void onAreaSelected(OtherAreaInchargeList area, int position) {
        SharedPreferences.Editor prefs = PreferenceManager.getDefaultSharedPreferences(this).edit();
        if (position > 0) {
            prefs.putBoolean("selectedArea", true);
            prefs.putString("_DistrictCode", area.get_DistrictCode());
            prefs.putString("_DistrictName", area.get_DistrictName());
            prefs.putString("_BlockCode", area.get_BlockCode());
            prefs.putString("_BlockName", area.get_BlockName());
            prefs.putString("_PanchayatCode", area.get_PanchayatCode());
            prefs.putString("_PanchayatName", area.get_PanchayatName());
        } else {
            prefs.putBoolean("selectedArea", false);
        }
        prefs.commit();
        finish();
    }
}