package galaxy.tec.poiData.bean;

import galaxy.tec.poiData.bean.Point;

/**
 * 
 * 矩形区域
 */
public class Rectangle {
    /**
     * 当前区域名，
     */
    public String currentAreaName="";
    
//    矩形区域最左边最上面
    public Point leftTop;
    
    
//  矩形区域最右边最下面
    public Point rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(String currentAreaName, Point leftTop, Point rightBottom) {
        this.currentAreaName = currentAreaName;
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    @Override
    public String toString() {
        return "model.Rectangle{" + leftTop + ", " + rightBottom + '}';
    }
}
