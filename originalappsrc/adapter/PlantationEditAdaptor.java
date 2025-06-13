package bih.p003in.forestdept.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import bih.p003in.forestDept.C0594R;
import bih.p003in.forestdept.activity.PlantationInspectionActivity;
import bih.p003in.forestdept.activity.PlantationListEditActivity;
import bih.p003in.forestdept.api.ApiCall;
import bih.p003in.forestdept.database.DataBaseHelper;
import bih.p003in.forestdept.model.PlantationInspDetails_Request;
import bih.p003in.forestdept.security.Aes256CbcEncryptDecrypt;
import bih.p003in.forestdept.utility.CommonPref;
import bih.p003in.forestdept.utility.Utiilties;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public class PlantationEditAdaptor extends BaseAdapter {
    ArrayList<PlantationInspDetails_Request> ThrList;
    Activity activity;
    public DataBaseHelper dataBaseHelper;
    LayoutInflater mInflater;
    String version;

    public PlantationEditAdaptor(PlantationListEditActivity listViewshowedit, ArrayList<PlantationInspDetails_Request> rlist, String version) {
        this.ThrList = new ArrayList<>();
        this.activity = listViewshowedit;
        this.ThrList = rlist;
        this.mInflater = (LayoutInflater) listViewshowedit.getSystemService("layout_inflater");
        this.version = version;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View convertView2 = this.mInflater.inflate(C0594R.layout.adaptor_plantation_edit, (ViewGroup) null);
        ViewHolder holder = new ViewHolder();
        holder.tv_work_code = (TextView) convertView2.findViewById(C0594R.id.tv_work_code);
        holder.tv_work_name = (TextView) convertView2.findViewById(C0594R.id.tv_work_name);
        holder.tv_work_type = (TextView) convertView2.findViewById(C0594R.id.tv_work_type);
        holder.tv_agency_name = (TextView) convertView2.findViewById(C0594R.id.tv_agency_name);
        holder.btn_remove = (Button) convertView2.findViewById(C0594R.id.btn_remove);
        holder.btn_edit = (Button) convertView2.findViewById(C0594R.id.btn_edit);
        holder.btn_upload = (Button) convertView2.findViewById(C0594R.id.btn_upload);
        convertView2.setTag(holder);
        holder.tv_work_code.setText(this.ThrList.get(position).getWorkCode());
        holder.tv_work_name.setText(this.ThrList.get(position).getWorkName());
        holder.tv_work_type.setText(this.ThrList.get(position).getWorktype());
        holder.tv_agency_name.setText(this.ThrList.get(position).getAgencyName());
        holder.btn_remove.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                new AlertDialog.Builder(PlantationEditAdaptor.this.activity).setIcon(C0594R.drawable.headerbrds).setTitle(C0594R.string.confirmation).setMessage("क्या आप डाटा हटाना चाहते है?").setCancelable(false).setPositiveButton("हाँ", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int id) {
                        PlantationEditAdaptor.this.dataBaseHelper = new DataBaseHelper(PlantationEditAdaptor.this.activity);
                        String inspectionid = String.valueOf(PlantationEditAdaptor.this.ThrList.get(position).getInspectionID());
                        long c = PlantationEditAdaptor.this.dataBaseHelper.resetPlantationInspectionUpdatedData(inspectionid);
                        if (c > 0) {
                            Toast.makeText(PlantationEditAdaptor.this.activity, "Deleted Successfully", 0).show();
                            PlantationEditAdaptor.this.ThrList.remove(position);
                            PlantationEditAdaptor.this.notifyDataSetChanged();
                            return;
                        }
                        Toast.makeText(PlantationEditAdaptor.this.activity, "Failed to delete", 0).show();
                    }
                }).setNegativeButton("नहीं", (DialogInterface.OnClickListener) null).show();
            }
        });
        holder.btn_edit.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PlantationInspDetails_Request detail = PlantationEditAdaptor.this.ThrList.get(position);
                Intent i = new Intent(PlantationEditAdaptor.this.activity, (Class<?>) PlantationInspectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("data", detail);
                i.putExtras(bundle);
                PlantationEditAdaptor.this.activity.startActivity(i);
            }
        });
        holder.btn_upload.setOnClickListener(new View.OnClickListener() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PlantationEditAdaptor.this.ThrList.get(position).getPhoto() != null && PlantationEditAdaptor.this.ThrList.get(position).getPhoto1() != null) {
                    new AlertDialog.Builder(PlantationEditAdaptor.this.activity).setIcon(C0594R.drawable.headerbrds).setTitle(C0594R.string.confirmation).setMessage("क्या आप डाटा अपलोड करना चाहते है?").setCancelable(false).setPositiveButton("हाँ", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int id) {
                            if (Utiilties.isOnline(PlantationEditAdaptor.this.activity)) {
                                PlantationInspDetails_Request info = PlantationEditAdaptor.this.ThrList.get(position);
                                PlantationEditAdaptor.this.UploadPlantationDetail(info, position, PlantationEditAdaptor.this.version);
                            } else {
                                Toast.makeText(PlantationEditAdaptor.this.activity, "No Internet Connection", 0).show();
                            }
                        }
                    }).setNegativeButton("नहीं", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(PlantationEditAdaptor.this.activity, "इस डेटा का फोटो नहीं लिया गया है, कृपया फोटो लें और फिर अपलोड करें", 0).show();
                }
            }
        });
        return convertView2;
    }

    public void refresh(ArrayList<PlantationInspDetails_Request> events) {
        this.ThrList.clear();
        this.ThrList.addAll(events);
        notifyDataSetChanged();
    }

    public void chk_msg(String title, String msg) {
        AlertDialog.Builder ab = new AlertDialog.Builder(this.activity);
        ab.setCancelable(false);
        ab.setIcon(C0594R.drawable.headerbrds);
        ab.setTitle(title);
        Dialog dialog = new Dialog(this.activity);
        dialog.setCanceledOnTouchOutside(false);
        ab.setPositiveButton("ओके", new DialogInterface.OnClickListener() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int whichButton) {
                dialog2.dismiss();
            }
        });
        ab.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UploadPlantationDetail(final PlantationInspDetails_Request data, final int position, String version) {
        final ProgressDialog dialog = new ProgressDialog(this.activity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("अपलोड हो राहा है...");
        dialog.show();
        Aes256CbcEncryptDecrypt aes256CbcEncryptDecrypt = new Aes256CbcEncryptDecrypt();
        String temp32Enc_key = CommonPref.getUserDetails(this.activity).get_encriptionKey();
        String tempAuthToken = CommonPref.getUserDetails(this.activity).getAuthtoken();
        String Van_Posak_bhugtaan = data.getPosak_bhugtaanMonth() + "-" + data.getPosak_bhugtaanYear();
        PlantationInspDetails_Request detailsRequest = new PlantationInspDetails_Request();
        detailsRequest.setDeviceId(aes256CbcEncryptDecrypt.Encrypt(Utiilties.getDeviceIMEI(this.activity), temp32Enc_key));
        detailsRequest.setIpAddress(aes256CbcEncryptDecrypt.Encrypt(Utiilties.getLocalIpAddress(), temp32Enc_key));
        detailsRequest.setDistCode(aes256CbcEncryptDecrypt.Encrypt(data.getDistCode(), temp32Enc_key));
        detailsRequest.setBlockCode(aes256CbcEncryptDecrypt.Encrypt(data.getBlockCode(), temp32Enc_key));
        detailsRequest.setPanchayatCode(aes256CbcEncryptDecrypt.Encrypt(data.getPanchayatCode(), temp32Enc_key));
        detailsRequest.setBhumiType(aes256CbcEncryptDecrypt.Encrypt("", temp32Enc_key));
        detailsRequest.setYears(aes256CbcEncryptDecrypt.Encrypt(data.getPosak_bhugtaanYear(), temp32Enc_key));
        detailsRequest.setRemarks(aes256CbcEncryptDecrypt.Encrypt(data.getRemarks(), temp32Enc_key));
        detailsRequest.setInspectionID(aes256CbcEncryptDecrypt.Encrypt(data.getInspectionID(), temp32Enc_key));
        detailsRequest.setRopit_PlantNo(aes256CbcEncryptDecrypt.Encrypt(data.getRopit_PlantNo(), temp32Enc_key));
        detailsRequest.setUtarjibit_PlantNo(aes256CbcEncryptDecrypt.Encrypt(data.getUtarjibit_PlantNo(), temp32Enc_key));
        detailsRequest.setUtarjibitaPercent(aes256CbcEncryptDecrypt.Encrypt(data.getUtarjibitaPercent(), temp32Enc_key));
        detailsRequest.setUtarjibit_90PercentMore(aes256CbcEncryptDecrypt.Encrypt("", temp32Enc_key));
        detailsRequest.setUtarjibit_75_90Percent(aes256CbcEncryptDecrypt.Encrypt("", temp32Enc_key));
        detailsRequest.setUtarjibit_50_75Percent(aes256CbcEncryptDecrypt.Encrypt("", temp32Enc_key));
        detailsRequest.setUtarjibit_25PercentLess(aes256CbcEncryptDecrypt.Encrypt("", temp32Enc_key));
        detailsRequest.setIsInspected(aes256CbcEncryptDecrypt.Encrypt("Y", temp32Enc_key));
        detailsRequest.setIsInspectedDate(aes256CbcEncryptDecrypt.Encrypt(data.getIsInspectedDate(), temp32Enc_key));
        detailsRequest.setIsInspectedBy(aes256CbcEncryptDecrypt.Encrypt(data.getIsInspectedBy(), temp32Enc_key));
        detailsRequest.setAppVersion(aes256CbcEncryptDecrypt.Encrypt(version, temp32Enc_key));
        detailsRequest.setPhoto(data.getPhoto());
        detailsRequest.setPhoto1(data.getPhoto1());
        detailsRequest.setLatitude_Mob(aes256CbcEncryptDecrypt.Encrypt(data.getLatitude_Mob(), temp32Enc_key));
        detailsRequest.setLongitude_Mob(aes256CbcEncryptDecrypt.Encrypt(data.getLongitude_Mob(), temp32Enc_key));
        detailsRequest.setUserrole(aes256CbcEncryptDecrypt.Encrypt(data.getUserrole(), temp32Enc_key));
        detailsRequest.setPlantation_Site_Id(aes256CbcEncryptDecrypt.Encrypt(data.getPlantation_Site_Id(), temp32Enc_key));
        detailsRequest.setVan_Posako_No(aes256CbcEncryptDecrypt.Encrypt(data.getVan_Posako_No(), temp32Enc_key));
        detailsRequest.setVan_Posak_bhugtaan(aes256CbcEncryptDecrypt.Encrypt(Van_Posak_bhugtaan, temp32Enc_key));
        detailsRequest.setGavyan_percentage(aes256CbcEncryptDecrypt.Encrypt(data.getGavyan_percentage(), temp32Enc_key));
        detailsRequest.setAverage_height_Plant(aes256CbcEncryptDecrypt.Encrypt(data.getAverage_height_Plant(), temp32Enc_key));
        detailsRequest.setPlantAgainstDeadPlnt(aes256CbcEncryptDecrypt.Encrypt(data.getPlantAgainstDeadPlnt(), temp32Enc_key));
        detailsRequest.setPlantationGeoTaging_obj(aes256CbcEncryptDecrypt.Encrypt(data.getPlantationGeoTaging_obj(), temp32Enc_key));
        Call<String> call = ApiCall.getService().uploadPlantationData(tempAuthToken, detailsRequest);
        call.enqueue(new Callback<String>() { // from class: bih.in.forestdept.adapter.PlantationEditAdaptor.5
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call2, Response<String> response) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                if (response.body() != null) {
                    String[] separated = response.body().split("-");
                    if (separated[0].equalsIgnoreCase("1")) {
                        PlantationEditAdaptor.this.dataBaseHelper = new DataBaseHelper(PlantationEditAdaptor.this.activity);
                        long isDel = PlantationEditAdaptor.this.dataBaseHelper.resetPlantationInspectionUpdatedData(String.valueOf(data.getInspectionID()));
                        if (isDel > 0) {
                            Toast.makeText(PlantationEditAdaptor.this.activity, separated[1], 1).show();
                            PlantationEditAdaptor.this.ThrList.remove(position);
                            PlantationEditAdaptor.this.notifyDataSetChanged();
                            return;
                        }
                        Log.e("message", "data is uploaded but not deleted !!");
                        return;
                    }
                    if (separated[0].equalsIgnoreCase("0")) {
                        Toast.makeText(PlantationEditAdaptor.this.activity, separated[1], 0).show();
                        return;
                    }
                    return;
                }
                Toast.makeText(PlantationEditAdaptor.this.activity, "Internal Server Error (500)", 0).show();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call2, Throwable t) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
    }

    private class ViewHolder {
        Button btn_edit;
        Button btn_remove;
        Button btn_upload;
        TextView tv_agency_name;
        TextView tv_work_code;
        TextView tv_work_name;
        TextView tv_work_type;

        private ViewHolder() {
        }
    }
}