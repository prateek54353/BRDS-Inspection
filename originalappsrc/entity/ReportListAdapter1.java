package bih.p003in.forestdept.entity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import bih.p003in.forestdept.database.DataBaseHelper;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public class ReportListAdapter1 extends ArrayAdapter<ReportEntity> {
    Context context;
    ArrayList<ReportEntity> data;
    String fileName;
    int layoutResourceId;

    public ReportListAdapter1(Context context, int layoutResourceId, ArrayList<ReportEntity> data) {
        super(context, layoutResourceId, data);
        this.data = new ArrayList<>();
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageHolder holder;
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = ((Activity) this.context).getLayoutInflater();
            row = inflater.inflate(this.layoutResourceId, parent, false);
            holder = new ImageHolder();
            row.setTag(holder);
        } else {
            holder = (ImageHolder) row.getTag();
        }
        ReportEntity report = this.data.get(position);
        holder.txtId.setText(report.getAWCGOICode());
        String edate = report.getUpload_Date();
        StringTokenizer st1 = new StringTokenizer(edate, " ");
        String edate2 = st1.nextToken();
        holder.txtDate.setText(edate2);
        new DataBaseHelper(this.context);
        holder.txtName.setText(report.getAWCName());
        holder.txtRemarks.setText(report.getRemarks());
        return row;
    }

    static class ImageHolder {
        TextView txtDate;
        TextView txtId;
        TextView txtName;
        TextView txtRemarks;

        ImageHolder() {
        }
    }
}