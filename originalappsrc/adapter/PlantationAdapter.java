package bih.p003in.forestdept.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.activity.PlantationListActivity;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class PlantationAdapter extends BaseAdapter {
    ArrayList<PlantationInspDetails_Request> ThrList;
    Activity activity;
    LayoutInflater mInflater;
    String panchayatCode;
    String panchayatName = "";

    public PlantationAdapter(PlantationListActivity listViewshowedit, ArrayList<PlantationInspDetails_Request> rlist) {
        this.ThrList = new ArrayList<>();
        this.activity = listViewshowedit;
        this.ThrList = rlist;
        this.mInflater = (LayoutInflater) listViewshowedit.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ThrList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View convertView2 = this.mInflater.inflate(C0594R.layout.adaptor_plantation, (ViewGroup) null);
        ViewHolder holder = new ViewHolder();
        holder.tv_work_code = (TextView) convertView2.findViewById(C0594R.id.tv_work_code);
        holder.tv_work_name = (TextView) convertView2.findViewById(C0594R.id.tv_work_name);
        holder.tv_work_type = (TextView) convertView2.findViewById(C0594R.id.tv_work_type);
        holder.tv_agency_name = (TextView) convertView2.findViewById(C0594R.id.tv_agency_name);
        holder.tv_inspected_by = (TextView) convertView2.findViewById(C0594R.id.tv_inspected_by);
        convertView2.setTag(holder);
        String inspectedBy = this.ThrList.get(position).getIsInspectedByDSTAE().equals("Y") ? "DSTAE" : "";
        if (this.ThrList.get(position).getIsInspectedByDSTEE().equals("Y")) {
            if (!inspectedBy.equals("")) {
                inspectedBy = inspectedBy + ", ";
            }
            inspectedBy = inspectedBy + "DSTEE";
        }
        if (this.ThrList.get(position).getIsInspectedByDSTDRDA().equals("Y")) {
            if (!inspectedBy.equals("")) {
                inspectedBy = inspectedBy + ", ";
            }
            inspectedBy = inspectedBy + "DSTDRDA";
        }
        if (this.ThrList.get(position).getIsInspectedByDSTDDC().equals("Y")) {
            if (!inspectedBy.equals("")) {
                inspectedBy = inspectedBy + ", ";
            }
            inspectedBy = inspectedBy + "DSTDDC";
        }
        if (inspectedBy.equals("")) {
        }
        holder.tv_work_code.setText(this.ThrList.get(position).getWorkCode());
        holder.tv_work_name.setText(this.ThrList.get(position).getWorkName());
        holder.tv_work_type.setText(this.ThrList.get(position).getWorkStateFyear());
        holder.tv_agency_name.setText(this.ThrList.get(position).getAgencyName());
        holder.tv_inspected_by.setText(this.ThrList.get(position).getLastInspectionDetails());
        return convertView2;
    }

    private class ViewHolder {
        Button btn_inspect;
        Button btn_map;
        LinearLayout ll_inspected_by;
        TextView tv_agency_name;
        TextView tv_inspected_by;
        TextView tv_work_code;
        TextView tv_work_name;
        TextView tv_work_type;

        private ViewHolder() {
        }
    }
}