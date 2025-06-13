package bih.p003in.forestdept.entity;

/* loaded from: classes3.dex */
public class ProjectListClass {
    public static Class<ProjectListClass> ProjectList_CLASS = ProjectListClass.class;
    private String count;
    private String projectCode;
    private String projectName;

    public String getProjectCode() {
        return this.projectCode;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public String getCount() {
        return this.count;
    }

    public ProjectListClass(String projectName, String projectCode, String count) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.count = count;
    }
}