public class Admin extends User{
    private final Boolean radiusAdmin;

    public Admin(int id, String name, String password, int loginCount, Boolean isLoggedIn, Boolean webAdmin, Boolean radiusAdmin) {
        super(id, name, password, loginCount, isLoggedIn);
        this.radiusAdmin = radiusAdmin;
    }

    public Boolean getRadiusAdmin() {
        return radiusAdmin;
    }
}
