package bih.p003in.forestdept.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.model.OtherAreaInchargeList;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class OtherAreaAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    OtherAreaListener listener;
    private ArrayList<OtherAreaInchargeList> mData;
    private LayoutInflater mInflater;

    public interface ItemClickListener {
        void onItemClick(View view, int i);
    }

    public OtherAreaAdapter(Context context, ArrayList<OtherAreaInchargeList> data, OtherAreaListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(C0594R.layout.adaptor_select_other_area, parent, false);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final OtherAreaInchargeList info = this.mData.get(position);
        if (position > 0) {
            holder.tv_count.setText(String.valueOf(position + 1) + ".");
            holder.tv_block.setText(info.get_BlockName());
            holder.tv_panchayat.setText(info.get_PanchayatName());
            holder.tv_district.setText(info.get_DistrictName());
            holder.tv_same_area.setVisibility(8);
            holder.ll_oth_area.setVisibility(0);
            String role = info.get_UserRole();
            if (role.equals("DSTPO") || role.equals("DSTAE") || role.equals("DSTEE") || role.equals("DSTDRDA") || role.equals("DSTDDC")) {
                holder.ll_block.setVisibility(4);
                holder.ll_panchayat.setVisibility(4);
            } else if (role.equals("BLKPO") || role.equals("BLKJE") || role.equals("BLKPTA")) {
                holder.ll_panchayat.setVisibility(4);
            }
        } else {
            holder.tv_same_area.setVisibility(0);
            holder.ll_oth_area.setVisibility(8);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.adapter.OtherAreaAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                OtherAreaAdapter.this.listener.onAreaSelected(info, position);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout ll_block;
        LinearLayout ll_oth_area;
        LinearLayout ll_panchayat;
        TextView tv_block;
        TextView tv_count;
        TextView tv_district;
        TextView tv_panchayat;
        TextView tv_same_area;

        ViewHolder(View itemView) {
            super(itemView);
            this.tv_district = (TextView) itemView.findViewById(C0594R.id.tv_district_oth);
            this.tv_block = (TextView) itemView.findViewById(C0594R.id.tv_block_oth);
            this.tv_panchayat = (TextView) itemView.findViewById(C0594R.id.tv_panchayat_oth);
            this.tv_count = (TextView) itemView.findViewById(C0594R.id.tv_count);
            this.ll_oth_area = (LinearLayout) itemView.findViewById(C0594R.id.ll_oth_area);
            this.tv_same_area = (TextView) itemView.findViewById(C0594R.id.tv_same_area);
            this.ll_panchayat = (LinearLayout) itemView.findViewById(C0594R.id.ll_panchayat);
            this.ll_block = (LinearLayout) itemView.findViewById(C0594R.id.ll_block);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    OtherAreaInchargeList getItem(int id) {
        return this.mData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
    }
}