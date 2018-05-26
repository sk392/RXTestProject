package latte.example.com.rxtestproject;

public class ProjectItem {
    private String projectDate;
    private String projectName;
    private String projectorder;

    public ProjectItem(String projectDate, String projectName, String projectorder) {
        this.projectDate = projectDate;
        this.projectName = projectName;
        this.projectorder = projectorder;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectorder() {
        return projectorder;
    }

    @Override
    public String toString() {
        return "ProjectItem{" +
                "projectDate=" + projectDate +
                ", projectName='" + projectName + '\'' +
                ", projectorder=" + projectorder +
                '}';
    }
}
