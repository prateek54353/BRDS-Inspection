package bih.p003in.forestdept.entity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ProjectListAdapter extends ArrayAdapter<ProjectListClass> {
    Context context;
    ArrayList<ProjectListClass> data;
    String fileName;
    int layoutResourceId;

    public ProjectListAdapter(Context context, int layoutResourceId, ArrayList<ProjectListClass> data) {
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
        ProjectListClass projectListClass = this.data.get(position);
        holder.projectName.setText(projectListClass.getProjectName());
        holder.countText.setText(projectListClass.getCount());
        return row;
    }

    static class ImageHolder {
        TextView countText;
        TextView projectName;

        ImageHolder() {
        }
    }
}