package bih.p003in.forestdept.entity;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import bih.p003in.forestDept.C0594R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ReportListAdapter extends ArrayAdapter<ReportClass> {
    Context context;
    ArrayList<ReportClass> data;
    String fileName;
    int layoutResourceId;

    public ReportListAdapter(Context context, int layoutResourceId, ArrayList<ReportClass> data) {
        super(context, layoutResourceId, data);
        this.data = new ArrayList<>();
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    public String getYN(String code) {
        return code.equals("1") ? this.context.getString(C0594R.string.yes) : this.context.getString(C0594R.string.f129no);
    }

    static class ImageHolder {
        TextView date;
        TextView level;

        /* renamed from: ms */
        TextView f191ms;

        /* renamed from: oc */
        TextView f192oc;
        TextView officeName;

        /* renamed from: p */
        TextView f193p;
        TextView projectName;
        LinearLayout projectNamelayout;

        ImageHolder() {
        }
    }
}