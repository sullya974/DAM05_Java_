public class Point {
    private int x;
    private int y;
    private int z;
    private boolean visible;

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Point(int x, int y, int z, Boolean visible) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.visible = visible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Point(){
    }

    public Point(int z) {
        this.z = z;
    }

    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", is visible=" + visible +
                '}';
    }

    public void deplace(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distantDe(Point p){

        return Math.round(Math.sqrt((
                Math.pow((this.x-p.x), 2) +
                        Math.pow((this.y-p.getY()), 2) +
                        Math.pow((this.z-p.getZ()), 2))));
    }
}
