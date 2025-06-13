package bih.p003in.forestdept.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.adapter.GeoTag_Adapter;
import bih.p003in.forestdept.model.GeoFencing;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class GeoTag_Adapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<GeoFencing> geoTagLatLonModelList;
    private final int limit = 4;
    private final Context mctx;

    public GeoTag_Adapter(Context mctx, ArrayList<GeoFencing> geoTagLatLonModelList) {
        this.mctx = mctx;
        this.geoTagLatLonModelList = geoTagLatLonModelList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.mctx).inflate(C0594R.layout.geotag_item, parent, false);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(this.geoTagLatLonModelList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.geoTagLatLonModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ad_txt_lat;
        TextView ad_txt_long;
        ImageView icon_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            this.ad_txt_lat = (TextView) itemView.findViewById(C0594R.id.ad_txt_lat);
            this.ad_txt_long = (TextView) itemView.findViewById(C0594R.id.ad_txt_long);
            ImageView imageView = (ImageView) itemView.findViewById(C0594R.id.icon_delete);
            this.icon_delete = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.adapter.GeoTag_Adapter$ViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeoTag_Adapter.ViewHolder.this.m312lambda$new$2$bihinforestdeptadapterGeoTag_Adapter$ViewHolder(view);
                }
            });
        }

        /* renamed from: lambda$new$2$bih-in-forestdept-adapter-GeoTag_Adapter$ViewHolder, reason: not valid java name */
        /* synthetic */ void m312lambda$new$2$bihinforestdeptadapterGeoTag_Adapter$ViewHolder(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(GeoTag_Adapter.this.mctx);
            builder.setIcon(C0594R.drawable.logo);
            builder.setTitle("Location Delete");
            builder.setMessage("Are you sure want to Delete the Location");
            builder.setPositiveButton("[Yes]", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.adapter.GeoTag_Adapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GeoTag_Adapter.ViewHolder.this.m311lambda$new$0$bihinforestdeptadapterGeoTag_Adapter$ViewHolder(dialogInterface, i);
                }
            });
            builder.setNegativeButton("[No]", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.adapter.GeoTag_Adapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        /* renamed from: lambda$new$0$bih-in-forestdept-adapter-GeoTag_Adapter$ViewHolder, reason: not valid java name */
        /* synthetic */ void m311lambda$new$0$bihinforestdeptadapterGeoTag_Adapter$ViewHolder(DialogInterface dialog, int which) {
            dialog.dismiss();
            GeoTag_Adapter.this.geoTagLatLonModelList.remove(GeoTag_Adapter.this.geoTagLatLonModelList.get(getPosition()));
            GeoTag_Adapter.this.notifyDataSetChanged();
        }

        public void bind(GeoFencing geoTagLatLonModel, int position) {
            if (geoTagLatLonModel != null) {
                this.ad_txt_lat.setText(geoTagLatLonModel.getGeoFenLatitude());
                this.ad_txt_long.setText(geoTagLatLonModel.getGeoFenLongitude());
                if (GeoTag_Adapter.this.geoTagLatLonModelList.size() == position + 1) {
                    this.icon_delete.setVisibility(0);
                } else {
                    this.icon_delete.setVisibility(8);
                }
            }
        }
    }
}