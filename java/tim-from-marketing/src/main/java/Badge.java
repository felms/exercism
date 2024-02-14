class Badge {
    public String print(Integer id, String name, String department) {
        String idString = id != null ? "[" + id + "] - " : "";
        String departmentString = department != null ? department.toUpperCase() : "OWNER";

        return String.format("%s%s - %s", idString, name, departmentString);
    }
}
