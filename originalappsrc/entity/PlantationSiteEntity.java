package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class PlantationSiteEntity implements Serializable {
    public static Class<PlantationSiteEntity> PlantationSiteEntity_CLASS = PlantationSiteEntity.class;

    /* renamed from: Id */
    private String f175Id;
    private String Site_Name;
    private String Site_NameHin;

    public static Class<PlantationSiteEntity> getPlantationSiteEntity_CLASS() {
        return PlantationSiteEntity_CLASS;
    }

    public static void setPlantationSiteEntity_CLASS(Class<PlantationSiteEntity> plantationSiteEntity_CLASS) {
        PlantationSiteEntity_CLASS = plantationSiteEntity_CLASS;
    }

    public String getSite_NameHin() {
        return this.Site_NameHin;
    }

    public void setSite_NameHin(String site_NameHin) {
        this.Site_NameHin = site_NameHin;
    }

    public String getId() {
        return this.f175Id;
    }

    public void setId(String id) {
        this.f175Id = id;
    }

    public String getSite_Name() {
        return this.Site_Name;
    }

    public void setSite_Name(String site_Name) {
        this.Site_Name = site_Name;
    }
}