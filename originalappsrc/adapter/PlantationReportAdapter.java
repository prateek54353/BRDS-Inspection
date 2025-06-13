package bih.p003in.forestdept.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.activity.PlantationReportActivity;
import bih.p003in.forestdept.model.PlantationReportList;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class PlantationReportAdapter extends BaseAdapter {
    ArrayList<PlantationReportList> ThrList;
    Activity activity;
    LayoutInflater mInflater;

    public PlantationReportAdapter(PlantationReportActivity listViewshowedit, ArrayList<PlantationReportList> rlist) {
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
        View convertView2 = this.mInflater.inflate(C0594R.layout.adaptor_plantation_report, (ViewGroup) null);
        ViewHolder holder = new ViewHolder();
        holder.tv_work_code = (TextView) convertView2.findViewById(C0594R.id.tv_work_code);
        holder.tv_work_name = (TextView) convertView2.findViewById(C0594R.id.tv_work_name);
        holder.tv_work_type = (TextView) convertView2.findViewById(C0594R.id.tv_work_type);
        holder.tv_agency_name = (TextView) convertView2.findViewById(C0594R.id.tv_agency_name);
        holder.tv_inspected_date = (TextView) convertView2.findViewById(C0594R.id.tv_inspected_date);
        convertView2.setTag(holder);
        holder.tv_work_code.setText(this.ThrList.get(position).getWorkCode());
        holder.tv_work_name.setText(this.ThrList.get(position).getWorkName());
        holder.tv_work_type.setText(this.ThrList.get(position).getWorktype());
        holder.tv_agency_name.setText(this.ThrList.get(position).getAgencyName());
        holder.tv_inspected_date.setText(this.ThrList.get(position).getWorkStateFyear());
        return convertView2;
    }

    private class ViewHolder {
        TextView tv_agency_name;
        TextView tv_inspected_date;
        TextView tv_work_code;
        TextView tv_work_name;
        TextView tv_work_type;

        private ViewHolder() {
        }
    }
}